package com.angonurse.anapp.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.data.QuestionBank
import com.angonurse.anapp.databinding.ActivityResultsBinding
import com.angonurse.anapp.util.SoundManager

class ResultsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultsBinding
    private lateinit var soundManager: SoundManager
    private var participantName = ""
    private var percentage = ""
    private var correctCount = 0
    private var totalQuestions = 0
    private val userAnswers = mutableMapOf<Int, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        soundManager = SoundManager(this)

        participantName = intent.getStringExtra("participant_name") ?: ""
        percentage = intent.getStringExtra("percentage") ?: "0"
        correctCount = intent.getIntExtra("correct_count", 0)
        totalQuestions = intent.getIntExtra("total_questions", 0)

        val answersRaw = intent.getStringArrayListExtra("answers") ?: arrayListOf()
        answersRaw.forEach {
            val parts = it.split("|")
            if (parts.size == 2 && parts[1].isNotEmpty()) {
                userAnswers[parts[0].toInt()] = parts[1]
            }
        }

        binding.tvPercentage.text = "$percentage%"
        binding.tvScore.text = "$correctCount de $totalQuestions questões corretas"

        // Show all questions in gabarito
        val allQuestions = QuestionBank.questions
        binding.tvGabaritoCount.text = "${allQuestions.size} questões"

        binding.btnRestart.setOnClickListener {
            soundManager.playClick()
            startActivity(Intent(this, ExamQuizActivity::class.java))
            finish()
        }

        binding.btnShare.setOnClickListener {
            soundManager.playClick()
            val text = "🎓 Teste Online - Resultado\n\n$participantName obteve $percentage% ($correctCount/$totalQuestions questões corretas)!\n\nExperimenta também o Teste Online!"
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, text)
            }
            startActivity(Intent.createChooser(intent, "Compartilhar Resultado"))
        }

        binding.btnHome.setOnClickListener { finish() }

        // Setup gabarito with ALL questions
        binding.rvGabarito.layoutManager = LinearLayoutManager(this)
        binding.rvGabarito.isNestedScrollingEnabled = false
        binding.rvGabarito.adapter = GabaritoAdapter(allQuestions, userAnswers)
    }

    inner class GabaritoAdapter(
        private val questions: List<com.angonurse.anapp.data.Question>,
        private val userAnswers: Map<Int, String>
    ) : RecyclerView.Adapter<GabaritoAdapter.VH>() {

        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tvNum: TextView = view.findViewById(R.id.tvQuestionNum)
            val tvQuestion: TextView = view.findViewById(R.id.tvQuestionText)
            val tvUserAnswer: TextView = view.findViewById(R.id.tvUserAnswer)
            val tvCorrectAnswer: TextView = view.findViewById(R.id.tvCorrectAnswer)
            val ivIcon: ImageView = view.findViewById(R.id.ivResultIcon)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gabarito, parent, false)
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val q = questions[position]
            val userAnswer = userAnswers[q.id]
            val isCorrect = userAnswer == q.correctAnswer
            val wasAnswered = userAnswer != null

            holder.tvNum.text = "Questão ${position + 1}"
            
            if (!wasAnswered) {
                holder.tvUserAnswer.text = "Não respondida"
                holder.tvUserAnswer.setTextColor(getColor(R.color.orange))
            } else {
                holder.tvUserAnswer.text = "Sua resposta: ${userAnswer.uppercase()}"
                holder.tvUserAnswer.setTextColor(getColor(if (isCorrect) R.color.green else R.color.red))
            }

            holder.tvQuestion.text = q.question

            if (isCorrect) {
                holder.tvCorrectAnswer.visibility = View.GONE
                holder.ivIcon.setImageResource(R.drawable.ic_check)
            } else {
                holder.tvCorrectAnswer.visibility = View.VISIBLE
                holder.tvCorrectAnswer.text = "Resposta correta: ${q.correctAnswer.uppercase()}"
                holder.ivIcon.setImageResource(R.drawable.ic_wrong)
            }
        }

        override fun getItemCount() = questions.size
    }
}
