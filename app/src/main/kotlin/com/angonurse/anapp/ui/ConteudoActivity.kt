package com.angonurse.anapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.angonurse.anapp.R
import com.angonurse.anapp.data.ConteudoRepo
import com.angonurse.anapp.data.Topic
import com.angonurse.anapp.databinding.ActivityConteudoBinding
import io.noties.markwon.Markwon

class ConteudoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConteudoBinding
    private lateinit var markwon: Markwon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConteudoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        markwon = Markwon.create(this)

        binding.btnBack.setOnClickListener { finish() }

        binding.rvTopics.layoutManager = LinearLayoutManager(this)
        binding.rvTopics.adapter = TopicAdapter()
    }

    inner class TopicAdapter : RecyclerView.Adapter<TopicAdapter.VH>() {
        inner class VH(view: View) : RecyclerView.ViewHolder(view) {
            val tvNumber: TextView = view.findViewById(R.id.tvTopicNumber)
            val tvTitle: TextView = view.findViewById(R.id.tvTopicTitle)
            val tvContent: TextView = view.findViewById(R.id.tvTopicContent)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_conteudo_topic, parent, false)
            return VH(view)
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val topic = ConteudoRepo.topics[position]
            holder.tvNumber.text = topic.icon
            holder.tvTitle.text = topic.title
            markwon.setMarkdown(holder.tvContent, topic.markdownContent)
        }

        override fun getItemCount() = ConteudoRepo.topics.size
    }
}
