package com.angonurse.anapp

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.angonurse.anapp.data.ConteudoRepo
import com.angonurse.anapp.databinding.ActivityConteudoBinding
import com.angonurse.anapp.util.SoundManager
import io.noties.markwon.Markwon

class ConteudoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConteudoBinding
    private lateinit var markwon: Markwon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConteudoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SoundManager.init(this)

        markwon = Markwon.create(this)

        val topics = ConteudoRepo.topics

        binding.btnBack.setOnClickListener {
            SoundManager.playClick()
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
        binding.tvTopicCount.text = "${topics.size} temas de estudo"

        val dp = resources.displayMetrics.density

        topics.forEachIndexed { index, topic ->
            val card = CardView(this).apply {
                radius = 14f * dp
                cardElevation = 2f * dp
                setCardBackgroundColor(getColor(R.color.card))
                val lp = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                lp.bottomMargin = (10 * dp).toInt()
                layoutParams = lp
            }

            val inner = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                val dp16 = (16 * dp).toInt()
                setPadding(dp16, dp16, dp16, dp16)
            }

            // Icon circle with emoji
            val iconFrame = FrameLayout(this).apply {
                val size = (48 * dp).toInt()
                layoutParams = LinearLayout.LayoutParams(size, size).apply {
                    marginEnd = (14 * dp).toInt()
                }
                setBackgroundResource(R.drawable.bg_icon_circle)
            }

            val badge = TextView(this).apply {
                text = topic.icon
                textSize = 20f
                val flp = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
                flp.gravity = Gravity.CENTER
                layoutParams = flp
            }
            iconFrame.addView(badge)

            // Text content
            val textCol = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
            }

            val title = TextView(this).apply {
                text = topic.title
                textSize = 15f
                setTextColor(getColor(R.color.foreground))
                paint.isFakeBoldText = true
            }

            val subtitle = TextView(this).apply {
                text = topic.summary
                textSize = 12f
                setTextColor(getColor(R.color.muted_foreground))
                maxLines = 1
                ellipsize = TextUtils.TruncateAt.END
            }

            textCol.addView(title)
            textCol.addView(subtitle)

            // Chevron
            val chevron = ImageView(this).apply {
                val size = (20 * dp).toInt()
                layoutParams = LinearLayout.LayoutParams(size, size)
                setImageResource(R.drawable.ic_chevron_right)
            }

            inner.addView(iconFrame)
            inner.addView(textCol)
            inner.addView(chevron)

            // Markdown content view (rendered by Markwon)
            var isExpanded = false
            val contentView = TextView(this).apply {
                textSize = 14f
                setTextColor(getColor(R.color.foreground))
                setLineSpacing(0f, 1.35f)
                visibility = View.GONE
                val dp16 = (16 * dp).toInt()
                setPadding(dp16, (8 * dp).toInt(), dp16, dp16)
            }
            // Pre-render markdown into the TextView
            markwon.setMarkdown(contentView, topic.markdownContent)

            val wrapper = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
            }
            wrapper.addView(inner)
            wrapper.addView(contentView)
            card.addView(wrapper)

            card.setOnClickListener {
                SoundManager.playClick()
                isExpanded = !isExpanded
                contentView.visibility = if (isExpanded) View.VISIBLE else View.GONE
            }

            binding.topicsContainer.addView(card)
        }
    }

    @Suppress("DEPRECATION")
    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
