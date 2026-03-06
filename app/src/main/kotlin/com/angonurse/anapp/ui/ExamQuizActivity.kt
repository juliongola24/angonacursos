package com.angonurse.anapp.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.data.Question
import com.angonurse.anapp.data.QuestionBank
import com.angonurse.anapp.data.ResultHistory
import com.angonurse.anapp.data.ResultRecord
import com.angonurse.anapp.databinding.ActivityExamQuizBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class ExamQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExamQuizBinding
    private val questions = QuestionBank.getQuestions()
    private val userAnswers = mutableMapOf<Int, String>()
    private var currentIndex = 0
    private var timer: CountDownTimer? = null
    private var participantName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showNameDialog()
    }

    private fun showNameDialog() {
        val input = EditText(this).apply {
            hint = "Digite seu nome completo"
            setPadding(48, 32, 48, 32)
        }
        val container = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 16, 48, 0)
            addView(input)
        }

        AlertDialog.Builder(this)
            .setTitle("Antes de Começar")
            .setView(container)
            .setCancelable(false)
            .setPositiveButton("Iniciar Teste") { _, _ ->
                val name = input.text.toString().trim()
                if (name.isEmpty()) {
                    Toast.makeText(this, "Nome obrigatório", Toast.LENGTH_SHORT).show()
                    showNameDialog()
                } else {
                    participantName = name
                    startExam()
                }
            }
            .setNegativeButton("Cancelar") { _, _ -> finish() }
            .show()
    }

    private fun startExam() {
        binding.examContent.visibility = View.VISIBLE
        setupNavGrid()
        showQuestion(0)
        startTimer()

        binding.btnPrevious.setOnClickListener {
            if (currentIndex > 0) showQuestion(currentIndex - 1)
        }
        binding.btnNext.setOnClickListener {
            if (currentIndex < questions.size - 1) showQuestion(currentIndex + 1)
        }
        binding.btnFinish.setOnClickListener { handleSubmit() }
        binding.btnExit.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Sair do Teste?")
                .setMessage("Todo o progresso será perdido.")
                .setPositiveButton("Sair") { _, _ -> finish() }
                .setNegativeButton("Continuar", null)
                .show()
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radio = group.findViewById<RadioButton>(checkedId) ?: return@setOnCheckedChangeListener
            val letter = radio.text.toString().substringBefore(")").trim()
            userAnswers[questions[currentIndex].id] = letter
            updateProgress()
            updateNavGrid()
        }
    }

    private fun showQuestion(index: Int) {
        currentIndex = index
        val q = questions[index]

        binding.tvQuestionNumber.text = "Questão ${index + 1}"
        binding.tvQuestionCount.text = "${index + 1} de ${questions.size}"
        binding.tvQuestionText.text = q.question

        binding.radioGroup.removeAllViews()
        q.options.forEach { option ->
            val radio = RadioButton(this).apply {
                text = option
                id = View.generateViewId()
                setPadding(16, 24, 16, 24)
                textSize = 16f
            }
            binding.radioGroup.addView(radio)

            val letter = option.substringBefore(")").trim()
            if (userAnswers[q.id] == letter) {
                radio.isChecked = true
            }
        }

        binding.btnPrevious.isEnabled = index > 0
        binding.btnNext.visibility = if (index < questions.size - 1) View.VISIBLE else View.GONE
        binding.btnFinish.visibility = if (index == questions.size - 1) View.VISIBLE else View.GONE

        updateProgress()
    }

    private fun startTimer() {
        val totalMs = QuestionBank.EXAM_DURATION_MINUTES * 60 * 1000L
        timer = object : CountDownTimer(totalMs, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val min = (millisUntilFinished / 1000) / 60
                val sec = (millisUntilFinished / 1000) % 60
                binding.tvTimer.text = String.format("%02d:%02d", min, sec)

                if (millisUntilFinished <= 60000) {
                    binding.tvTimer.setTextColor(getColor(R.color.red))
                } else if (millisUntilFinished <= 300000) {
                    binding.tvTimer.setTextColor(getColor(R.color.orange))
                }
            }

            override fun onFinish() {
                Toast.makeText(this@ExamQuizActivity, "Tempo esgotado!", Toast.LENGTH_LONG).show()
                finishExam()
            }
        }.start()
    }

    private fun handleSubmit() {
        val unanswered = questions.size - userAnswers.size
        if (unanswered > 0) {
            AlertDialog.Builder(this)
                .setTitle("Finalizar Teste?")
                .setMessage("Você ainda tem $unanswered questões não respondidas. Deseja realmente finalizar?")
                .setPositiveButton("Finalizar Mesmo Assim") { _, _ -> finishExam() }
                .setNegativeButton("Continuar Respondendo", null)
                .show()
        } else {
            finishExam()
        }
    }

    private fun finishExam() {
        timer?.cancel()
        val correctCount = questions.count { userAnswers[it.id] == it.correctAnswer }
        val percentage = String.format("%.1f", (correctCount.toDouble() / questions.size) * 100)

        ResultHistory.saveResult(this, ResultRecord(
            participantName = participantName,
            percentage = percentage,
            correctCount = correctCount,
            totalQuestions = questions.size
        ))

        val intent = Intent(this, ResultsActivity::class.java).apply {
            putExtra("participant_name", participantName)
            putExtra("percentage", percentage)
            putExtra("correct_count", correctCount)
            putExtra("total_questions", questions.size)
            // Pass answers as serializable
            val answersArray = ArrayList<String>()
            questions.forEach { q ->
                answersArray.add("${q.id}|${userAnswers[q.id] ?: ""}")
            }
            putStringArrayListExtra("answers", answersArray)
        }
        startActivity(intent)
        finish()
    }

    private fun updateProgress() {
        val answered = userAnswers.size
        val progress = (answered * 100) / questions.size
        binding.tvProgress.text = "$answered de ${questions.size} respondidas ($progress%)"
        binding.progressBar.progress = progress
    }

    private fun setupNavGrid() {
        binding.rvNavGrid.layoutManager = GridLayoutManager(this, 10)
        binding.rvNavGrid.adapter = NavAdapter()
    }

    private fun updateNavGrid() {
        binding.rvNavGrid.adapter?.notifyDataSetChanged()
    }

    inner class NavAdapter : RecyclerView.Adapter<NavAdapter.VH>() {
        inner class VH(val tv: TextView) : RecyclerView.ViewHolder(tv)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val tv = TextView(parent.context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    resources.getDimensionPixelSize(R.dimen.nav_cell_size),
                    resources.getDimensionPixelSize(R.dimen.nav_cell_size)
                )
                gravity = android.view.Gravity.CENTER
                textSize = 12f
                setPadding(4, 4, 4, 4)
            }
            return VH(tv)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            holder.tv.text = "${position + 1}"
            val q = questions[position]
            val isAnswered = userAnswers.containsKey(q.id)
            val isCurrent = position == currentIndex

            if (isAnswered) {
                holder.tv.setBackgroundColor(getColor(R.color.primary))
                holder.tv.setTextColor(getColor(R.color.white))
            } else {
                holder.tv.setBackgroundColor(getColor(R.color.nav_unanswered))
                holder.tv.setTextColor(getColor(R.color.nav_text))
            }

            if (isCurrent) {
                holder.tv.setBackgroundResource(R.drawable.nav_current_bg)
                holder.tv.setTextColor(getColor(R.color.primary))
            }

            holder.tv.setOnClickListener { showQuestion(position) }
        }

        override fun getItemCount() = questions.size
    }

    override fun onDestroy() {
        super.onDestroy()
        timer?.cancel()
    }
}
