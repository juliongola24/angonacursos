package com.angonurse.anapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.data.ResultHistory
import com.angonurse.anapp.data.ResultRecord
import com.angonurse.anapp.databinding.ActivityHistoricoBinding
import java.text.SimpleDateFormat
import java.util.*

class HistoricoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoricoBinding
    private var history = listOf<ResultRecord>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoricoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.btnClearHistory.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Limpar Histórico?")
                .setMessage("Esta acção irá apagar todos os registos. Não é possível desfazer.")
                .setPositiveButton("Apagar Tudo") { _, _ ->
                    ResultHistory.clearHistory(this)
                    loadHistory()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        loadHistory()
    }

    private fun loadHistory() {
        history = ResultHistory.getHistory(this)
        binding.rvHistory.layoutManager = LinearLayoutManager(this)
        binding.rvHistory.adapter = HistoryAdapter()

        binding.tvEmpty.visibility = if (history.isEmpty()) View.VISIBLE else View.GONE
        binding.rvHistory.visibility = if (history.isEmpty()) View.GONE else View.VISIBLE
        binding.btnClearHistory.visibility = if (history.isEmpty()) View.GONE else View.VISIBLE
        binding.tvCount.text = if (history.isEmpty()) "Nenhum teste realizado ainda."
        else "${history.size} tentativa${if (history.size > 1) "s" else ""} registada${if (history.size > 1) "s" else ""}"
    }

    private fun formatDate(iso: String): String {
        return try {
            val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
            formatter.format(parser.parse(iso)!!)
        } catch (_: Exception) { iso }
    }

    inner class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.VH>() {
        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tvIndex: TextView = view.findViewById(R.id.tvIndex)
            val tvName: TextView = view.findViewById(R.id.tvName)
            val tvDate: TextView = view.findViewById(R.id.tvDate)
            val tvPercentage: TextView = view.findViewById(R.id.tvPercentage)
            val tvScore: TextView = view.findViewById(R.id.tvScoreDetail)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_result_history, parent, false)
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val record = history[position]
            holder.tvIndex.text = "${history.size - position}"
            holder.tvName.text = record.participantName
            holder.tvDate.text = formatDate(record.date)
            holder.tvPercentage.text = "${record.percentage}%"
            holder.tvScore.text = "${record.correctCount}/${record.totalQuestions}"

            val pct = record.percentage.toFloatOrNull() ?: 0f
            val color = when {
                pct >= 80 -> getColor(R.color.green)
                pct >= 50 -> getColor(R.color.orange)
                else -> getColor(R.color.red)
            }
            holder.tvPercentage.setTextColor(color)
        }

        override fun getItemCount() = history.size
    }
}
