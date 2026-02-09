package com.angonurse.anapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.data.ResultRecord
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter(
    private val items: List<ResultRecord>
) : RecyclerView.Adapter<HistoryAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvIndex: TextView = v.findViewById(R.id.tvIndex)
        val tvName: TextView = v.findViewById(R.id.tvName)
        val tvDate: TextView = v.findViewById(R.id.tvDate)
        val tvPercentage: TextView = v.findViewById(R.id.tvPercentage)
        val tvCorrectCount: TextView = v.findViewById(R.id.tvCorrectCount)
        val ivStatus: ImageView = v.findViewById(R.id.ivStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return VH(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val record = items[position]
        val ctx = holder.itemView.context
        holder.tvIndex.text = (items.size - position).toString()
        holder.tvName.text = record.participantName
        holder.tvDate.text = formatDate(record.date)
        holder.tvPercentage.text = "${record.percentage}%"
        holder.tvCorrectCount.text = "${record.correctCount}/${record.totalQuestions}"

        val pct = record.percentage.toFloatOrNull() ?: 0f
        if (pct >= 50f) {
            holder.ivStatus.setImageResource(R.drawable.ic_check_circle)
            holder.tvPercentage.setTextColor(ctx.getColor(R.color.success))
        } else {
            holder.ivStatus.setImageResource(R.drawable.ic_x_circle)
            holder.tvPercentage.setTextColor(ctx.getColor(R.color.destructive))
        }
    }

    private fun formatDate(iso: String): String {
        return try {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val date = parser.parse(iso) ?: return iso
            SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(date)
        } catch (e: Exception) {
            iso
        }
    }
}
