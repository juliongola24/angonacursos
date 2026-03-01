package com.angonurse.anapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.data.AppNotification

class NotificationAdapter(
    private val items: MutableList<AppNotification>,
    private val onDelete: (AppNotification) -> Unit
) : RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvBody: TextView = view.findViewById(R.id.tvBody)
        val tvDate: TextView = view.findViewById(R.id.tvDate)
        val unreadDot: View = view.findViewById(R.id.unreadDot)
        val btnDelete: ImageButton = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notification, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvTitle.text = item.title
        holder.tvBody.text = item.body
        holder.tvDate.text = item.receivedAt
        holder.unreadDot.visibility = if (item.isRead) View.GONE else View.VISIBLE
        holder.tvTitle.alpha = if (item.isRead) 0.7f else 1f

        holder.btnDelete.setOnClickListener {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                onDelete(items[pos])
                items.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }
    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<AppNotification>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
