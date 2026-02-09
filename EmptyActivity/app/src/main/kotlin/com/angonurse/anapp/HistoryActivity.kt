package com.angonurse.anapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.angonurse.anapp.adapter.HistoryAdapter
import com.angonurse.anapp.databinding.ActivityHistoryBinding
import com.angonurse.anapp.util.ResultHistory
import com.angonurse.anapp.util.SoundManager

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SoundManager.init(this)

        binding.btnBack.setOnClickListener { SoundManager.playClick(); finish() }

        loadHistory()

        binding.btnClearHistory.setOnClickListener {
            SoundManager.playClick()
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.clear_confirm_title))
                .setMessage(getString(R.string.clear_confirm_desc))
                .setPositiveButton(getString(R.string.delete_all)) { _, _ ->
                    ResultHistory.clearHistory(this)
                    loadHistory()
                }
                .setNegativeButton(getString(R.string.cancel), null)
                .show()
        }

        binding.btnGoToTest.setOnClickListener {
            SoundManager.playClick()
            startActivity(Intent(this, ExamActivity::class.java))
            finish()
        }
    }

    private fun loadHistory() {
        val history = ResultHistory.getHistory(this)
        if (history.isEmpty()) {
            binding.emptyState.visibility = View.VISIBLE
            binding.rvHistory.visibility = View.GONE
            binding.btnClearHistory.visibility = View.GONE
            binding.tvHistoryInfo.text = getString(R.string.no_tests_yet)
        } else {
            binding.emptyState.visibility = View.GONE
            binding.rvHistory.visibility = View.VISIBLE
            binding.btnClearHistory.visibility = View.VISIBLE
            binding.tvHistoryInfo.text = getString(R.string.attempts_count, history.size)
            binding.rvHistory.layoutManager = LinearLayoutManager(this)
            binding.rvHistory.adapter = HistoryAdapter(history)
        }
    }
}
