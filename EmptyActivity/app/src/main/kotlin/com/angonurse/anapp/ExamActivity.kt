package com.angonurse.anapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.angonurse.anapp.adapter.QuestionNavAdapter
import com.angonurse.anapp.data.ExamRepo
import com.angonurse.anapp.databinding.ActivityExamBinding
import com.angonurse.anapp.util.ResultHistory
import com.angonurse.anapp.util.SoundManager

class ExamActivity : AppCompatActivity() {
    private lateinit var binding: ActivityExamBinding
    private val questions = ExamRepo.questions
    private val userAnswers = mutableMapOf<Int, String>()
    private var currentIndex = 0
    private lateinit var navAdapter: QuestionNavAdapter
    private var participantName = ""
    private val optionViews = mutableListOf<TextView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SoundManager.init(this)

        // Name input
        binding.btnBeginExam.setOnClickListener {
            SoundManager.playClick()
            val name = binding.etParticipantName.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_required_desc), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            participantName = name
            binding.viewFlipper.displayedChild = 1
            startQuiz()
        }
    }

    private fun startQuiz() {
        // Setup nav grid
        navAdapter = QuestionNavAdapter(questions.size, emptySet(), 0) { index ->
            SoundManager.playClick()
            currentIndex = index
            displayQuestion()
        }
        binding.rvQuestionNav.layoutManager = GridLayoutManager(this, 5)
        binding.rvQuestionNav.adapter = navAdapter

        // Start background music
        SoundManager.startBackgroundMusic(this)

        // Navigation buttons
        binding.btnPrevious.setOnClickListener {
            SoundManager.playClick()
            if (currentIndex > 0) { currentIndex--; displayQuestion() }
        }
        binding.btnNext.setOnClickListener {
            SoundManager.playClick()
            if (currentIndex == questions.size - 1) {
                handleSubmit()
            } else {
                currentIndex++; displayQuestion()
            }
        }
        binding.btnExit.setOnClickListener {
            SoundManager.playClick()
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.exit_confirm_title))
                .setMessage(getString(R.string.exit_confirm))
                .setPositiveButton(getString(R.string.yes)) { _, _ -> finish() }
                .setNegativeButton(getString(R.string.no), null)
                .show()
        }

        displayQuestion()
    }

    private fun displayQuestion() {
        val q = questions[currentIndex]
        binding.tvQuestionNumber.text = getString(R.string.question_n, currentIndex + 1)
        binding.tvQuestionOf.text = getString(R.string.question_of, currentIndex + 1, questions.size)
        binding.tvQuestionText.text = q.question

        // Update progress
        val answered = userAnswers.size
        val pct = if (questions.isNotEmpty()) (answered * 100 / questions.size) else 0
        binding.tvProgress.text = getString(R.string.answered_count, answered, questions.size, pct.toString())
        binding.progressBar.progress = pct

        // Update nav button text
        if (currentIndex == questions.size - 1) {
            binding.btnNext.text = getString(R.string.finish_test)
        } else {
            binding.btnNext.text = getString(R.string.next)
        }
        binding.btnPrevious.isEnabled = currentIndex > 0
        binding.btnPrevious.alpha = if (currentIndex > 0) 1f else 0.5f

        // Build options
        val container = binding.optionsContainer
        val selectedAnswer = userAnswers[q.id]

        container.removeAllViews()
        optionViews.clear()

        for (option in q.options) {
            val letter = option[0].toString()
            val optionView = TextView(this).apply {
                text = option
                textSize = 15f
                setTextColor(getColor(R.color.foreground))
                setPadding(40, 36, 40, 36)
                setBackgroundResource(
                    if (letter == selectedAnswer) R.drawable.bg_option_selected
                    else R.drawable.bg_option_default
                )
                val lp = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                lp.bottomMargin = 10
                layoutParams = lp
                isClickable = true
                isFocusable = true
                tag = letter
                setOnClickListener {
                    SoundManager.playClick()
                    userAnswers[q.id] = letter
                    updateOptionSelection(letter)
                    updateProgressInfo()
                    navAdapter.updateState(currentIndex, userAnswers.keys.map { id -> id }.toSet())
                }
            }
            optionViews.add(optionView)
            container.addView(optionView)
        }

        // Update nav grid
        navAdapter.updateState(currentIndex, userAnswers.keys.map { id -> id }.toSet())
    }

    private fun updateOptionSelection(selectedLetter: String) {
        for (view in optionViews) {
            val letter = view.tag as String
            view.setBackgroundResource(
                if (letter == selectedLetter) R.drawable.bg_option_selected
                else R.drawable.bg_option_default
            )
        }
    }

    private fun updateProgressInfo() {
        val answered = userAnswers.size
        val pct = if (questions.isNotEmpty()) (answered * 100 / questions.size) else 0
        binding.tvProgress.text = getString(R.string.answered_count, answered, questions.size, pct.toString())
        binding.progressBar.progress = pct
    }

    private fun handleSubmit() {
        val unanswered = questions.size - userAnswers.size
        if (unanswered > 0) {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.finish_confirm_title))
                .setMessage(getString(R.string.finish_confirm_desc, unanswered))
                .setPositiveButton(getString(R.string.finish_anyway)) { _, _ -> finishExam() }
                .setNegativeButton(getString(R.string.continue_answering), null)
                .show()
        } else {
            finishExam()
        }
    }

    private fun finishExam() {
        SoundManager.stopBackgroundMusic()

        val correctCount = questions.count { userAnswers[it.id] == it.correctAnswer }
        val percentage = String.format("%.1f", correctCount * 100.0 / questions.size)

        ResultHistory.saveResult(this, participantName, percentage, correctCount, questions.size)

        val intent = Intent(this, ResultsActivity::class.java).apply {
            putExtra("participantName", participantName)
            putExtra("percentage", percentage)
            putExtra("correctCount", correctCount)
            putExtra("totalQuestions", questions.size)
            val answersBundle = Bundle()
            userAnswers.forEach { (id, ans) -> answersBundle.putString(id.toString(), ans) }
            putExtra("answers", answersBundle)
        }
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }

    override fun onResume() {
        super.onResume()
        if (binding.viewFlipper.displayedChild == 1) {
            SoundManager.resumeBackgroundMusic()
        }
    }

    override fun onPause() {
        super.onPause()
        SoundManager.pauseBackgroundMusic()
    }

    override fun onDestroy() {
        super.onDestroy()
        SoundManager.stopBackgroundMusic()
    }
}
