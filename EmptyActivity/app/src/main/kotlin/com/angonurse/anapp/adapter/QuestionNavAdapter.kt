package com.angonurse.anapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R

class QuestionNavAdapter(
    private val totalQuestions: Int,
    private val answeredQuestions: Set<Int>,
    private var currentIndex: Int,
    private val onQuestionClick: (Int) -> Unit
) : RecyclerView.Adapter<QuestionNavAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvNumber: TextView = v.findViewById(R.id.tvNavNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_question_nav, parent, false)
        return VH(v)
    }

    override fun getItemCount() = totalQuestions

    override fun onBindViewHolder(holder: VH, position: Int) {
        val questionId = position + 1
        holder.tvNumber.text = questionId.toString()

        val isAnswered = answeredQuestions.contains(questionId)
        val isCurrent = position == currentIndex

        if (isAnswered) {
            holder.tvNumber.setBackgroundResource(R.drawable.bg_nav_answered)
            holder.tvNumber.setTextColor(holder.itemView.context.getColor(R.color.primary_foreground))
        } else {
            holder.tvNumber.setBackgroundResource(R.drawable.bg_nav_default)
            holder.tvNumber.setTextColor(holder.itemView.context.getColor(R.color.muted_foreground))
        }

        if (isCurrent) {
            holder.tvNumber.scaleX = 1.15f
            holder.tvNumber.scaleY = 1.15f
            if (!isAnswered) {
                holder.tvNumber.setBackgroundResource(R.drawable.bg_nav_default)
            }
        } else {
            holder.tvNumber.scaleX = 1f
            holder.tvNumber.scaleY = 1f
        }

        holder.itemView.setOnClickListener { onQuestionClick(position) }
    }

    fun updateState(newCurrentIndex: Int, newAnswered: Set<Int>) {
        currentIndex = newCurrentIndex
        notifyDataSetChanged()
    }
}
