package com.angonurse.anapp

import android.content.Intent
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.angonurse.anapp.adapter.ResultDetailAdapter
import com.angonurse.anapp.data.ExamRepo
import com.angonurse.anapp.databinding.ActivityResultsBinding
import com.angonurse.anapp.util.SoundManager
import java.io.File
import java.io.FileOutputStream

class ResultsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultsBinding
    private var participantName = ""
    private var percentage = ""
    private var correctCount = 0
    private var totalQuestions = 0
    private val userAnswers = mutableMapOf<Int, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SoundManager.init(this)

        participantName = intent.getStringExtra("participantName") ?: ""
        percentage = intent.getStringExtra("percentage") ?: "0"
        correctCount = intent.getIntExtra("correctCount", 0)
        totalQuestions = intent.getIntExtra("totalQuestions", 0)

        val answersBundle = intent.getBundleExtra("answers")
        answersBundle?.keySet()?.forEach { key ->
            userAnswers[key.toInt()] = answersBundle.getString(key, "")
        }

        binding.tvPercentage.text = "${percentage}%"
        binding.tvCorrectCount.text = getString(R.string.correct_of_total, correctCount, totalQuestions)

        // Detailed results
        val adapter = ResultDetailAdapter(ExamRepo.questions, userAnswers)
        binding.rvResultDetails.layoutManager = LinearLayoutManager(this)
        binding.rvResultDetails.isNestedScrollingEnabled = false
        binding.rvResultDetails.adapter = adapter

        binding.btnRestart.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(this, ExamActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }

        binding.btnShareResult.setOnClickListener {
            SoundManager.playClick()
            val shareText = getString(R.string.share_result_text, participantName, percentage, correctCount, totalQuestions)
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(intent, getString(R.string.share_via)))
        }

        binding.btnDownloadPdf.setOnClickListener {
            SoundManager.playClick()
            generatePdf()
        }
    }

    private fun generatePdf() {
        try {
            val doc = PdfDocument()
            val questions = ExamRepo.questions
            var pageNum = 1
            var y = 60f
            val pageWidth = 595
            val pageHeight = 842
            var page = doc.startPage(PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNum).create())
            var canvas = page.canvas
            val paint = android.graphics.Paint().apply {
                textSize = 14f
                color = android.graphics.Color.BLACK
            }
            val boldPaint = android.graphics.Paint(paint).apply { isFakeBoldText = true; textSize = 18f }

            canvas.drawText("EXAME DE FISIOTERAPIA - GABARITO", 120f, y, boldPaint)
            y += 30f
            paint.textSize = 12f
            canvas.drawText("Participante: $participantName", 40f, y, paint)
            y += 25f
            boldPaint.textSize = 14f
            canvas.drawText("Resultado: ${percentage}% ($correctCount/$totalQuestions)", 40f, y, boldPaint)
            y += 35f

            paint.textSize = 10f
            for ((index, q) in questions.withIndex()) {
                if (y > pageHeight - 60) {
                    doc.finishPage(page)
                    pageNum++
                    page = doc.startPage(PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNum).create())
                    canvas = page.canvas
                    y = 40f
                }
                val answer = userAnswers[q.id]
                val isCorrect = answer == q.correctAnswer
                boldPaint.textSize = 10f
                canvas.drawText("${index + 1}. ${q.question}", 40f, y, boldPaint)
                y += 16f
                paint.textSize = 10f
                canvas.drawText("Resposta: ${answer?.uppercase() ?: "N/R"}", 50f, y, paint)
                y += 14f
                if (!isCorrect) {
                    canvas.drawText("Correta: ${q.correctAnswer.uppercase()}", 50f, y, paint)
                    y += 14f
                }
                y += 8f
            }
            doc.finishPage(page)

            val dir = File(cacheDir, "pdfs")
            dir.mkdirs()
            val file = File(dir, "gabarito_${participantName.replace(" ", "_")}.pdf")
            doc.writeTo(FileOutputStream(file))
            doc.close()

            Toast.makeText(this, getString(R.string.pdf_saved), Toast.LENGTH_SHORT).show()

            // Share the PDF
            val uri = androidx.core.content.FileProvider.getUriForFile(this, "$packageName.fileprovider", file)
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "application/pdf"
                putExtra(Intent.EXTRA_STREAM, uri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_via)))
        } catch (e: Exception) {
            Toast.makeText(this, "Erro ao gerar PDF: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        })
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        finish()
    }
}
