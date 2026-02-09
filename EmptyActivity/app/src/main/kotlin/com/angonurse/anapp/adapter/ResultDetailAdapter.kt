package com.angonurse.anapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.data.Question

class ResultDetailAdapter(
    private val questions: List<Question>,
    private val userAnswers: Map<Int, String>
) : RecyclerView.Adapter<ResultDetailAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvQuestionTitle: TextView = v.findViewById(R.id.tvQuestionTitle)
        val ivStatus: ImageView = v.findViewById(R.id.ivResultStatus)
        val tvQuestionText: TextView = v.findViewById(R.id.tvQuestionText)
        val tvUserAnswer: TextView = v.findViewById(R.id.tvUserAnswer)
        val tvCorrectAnswer: TextView = v.findViewById(R.id.tvCorrectAnswer)
        val tvCorrectOption: TextView = v.findViewById(R.id.tvCorrectOption)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_result_detail, parent, false)
        return VH(v)
    }

    override fun getItemCount() = questions.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val q = questions[position]
        val ctx = holder.itemView.context
        val userAnswer = userAnswers[q.id]
        val isCorrect = userAnswer == q.correctAnswer

        holder.tvQuestionTitle.text = ctx.getString(R.string.question_n, position + 1)

        if (isCorrect) {
            holder.ivStatus.setImageResource(R.drawable.ic_check_circle)
            (holder.itemView as? androidx.cardview.widget.CardView)?.setCardBackgroundColor(ctx.getColor(R.color.card))
        } else {
            holder.ivStatus.setImageResource(R.drawable.ic_x_circle)
            (holder.itemView as? androidx.cardview.widget.CardView)?.setCardBackgroundColor(ctx.getColor(R.color.card))
        }

        holder.tvQuestionText.text = q.question

        val answerText = if (userAnswer != null) userAnswer.uppercase() else ctx.getString(R.string.not_answered)
        holder.tvUserAnswer.text = "${ctx.getString(R.string.your_answer)}$answerText"
        holder.tvUserAnswer.setTextColor(
            if (isCorrect) ctx.getColor(R.color.success) else ctx.getColor(R.color.destructive)
        )

        if (!isCorrect) {
            holder.tvCorrectAnswer.visibility = View.VISIBLE
            holder.tvCorrectAnswer.text = "${ctx.getString(R.string.correct_answer)}${q.correctAnswer.uppercase()}"
        } else {
            holder.tvCorrectAnswer.visibility = View.GONE
        }

        val correctOptionText = q.options.find { it.startsWith(q.correctAnswer) }?.substring(3) ?: ""
        holder.tvCorrectOption.text = correctOptionText
    }
}
