package com.angonurse.anapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ImageView
import android.widget.FrameLayout
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.angonurse.anapp.databinding.ActivityConteudoBinding
import com.angonurse.anapp.util.SoundManager

class ConteudoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConteudoBinding

    private data class Topic(val title: String, val content: String)

    private val topics = listOf(
        Topic("Anatomia e Fisiologia Humana",
            "Estudo detalhado dos sistemas do corpo humano.\n\n• Sistema Nervoso — central e periférico\n• Sistema Cardiovascular — coração, vasos sanguíneos\n• Sistema Respiratório — mecânica ventilatória\n• Sistema Digestivo — digestão mecânica e química\n• Sistema Urinário — filtração glomerular\n• Sistema Endócrino — eixos hormonais\n• Sistema Musculoesquelético — tipos de articulações\n• Sistema Linfático — imunidade inata e adaptativa"),
        Topic("Farmacologia e Terapêutica",
            "Estudo das classes de medicamentos e farmacocinética.\n\n• Farmacocinética — absorção, distribuição, metabolismo (ADME)\n• Farmacodinâmica — receptores, agonistas, antagonistas\n• Anti-infecciosos — antibióticos, antifúngicos\n• Analgésicos — AINEs, opióides, escala da OMS\n• Fármacos Cardiovasculares — anti-hipertensores, diuréticos\n• Interacções Medicamentosas\n• Cuidados de Enfermagem — os 9 certos"),
        Topic("Enfermagem Clínica e Cirúrgica",
            "Cuidados pré, intra e pós-operatórios.\n\n• Avaliação Pré-operatória — checklist cirúrgico\n• Sinais Vitais — PA, FC, FR, temperatura, SpO₂\n• Gestão da Dor — escalas EVA, Wong-Baker\n• Cuidados com Feridas — cicatrização, pensos\n• Prevenção de IACS — técnica asséptica\n• Drenos e Sondas — tipos e cuidados\n• Complicações Pós-operatórias — hemorragia, TVP"),
        Topic("Saúde Materno-Infantil",
            "Assistência à mulher grávida e ao recém-nascido.\n\n• Assistência Pré-natal — consultas, sinais de alarme\n• Trabalho de Parto — fases, partograma\n• Cuidados ao Recém-nascido — Apgar, triagem neonatal\n• Aleitamento Materno — técnicas, vantagens\n• Vacinação Infantil — calendário vacinal angolano\n• Crescimento e Desenvolvimento — marcos, curvas\n• Patologias Pediátricas — diarreia, pneumonia, malária"),
        Topic("Saúde Pública e Epidemiologia",
            "Determinantes de saúde e vigilância epidemiológica.\n\n• Epidemiologia — incidência, prevalência\n• Indicadores de Saúde — mortalidade infantil\n• Doenças Transmissíveis — malária, TB, VIH/SIDA\n• Doenças Não Transmissíveis — hipertensão, diabetes\n• Promoção da Saúde — educação sanitária\n• Vigilância Epidemiológica — notificação obrigatória\n• Programas Nacionais — PAV, PNCT"),
        Topic("Microbiologia e Parasitologia",
            "Microrganismos patogénicos e infecções relevantes.\n\n• Bacteriologia — Gram-positivas e negativas\n• Virologia — VIH, hepatites, Ébola\n• Parasitologia — Plasmodium, helmintas\n• Micologia — Candida, dermatófitos\n• Diagnóstico Laboratorial — coloração de Gram\n• Controlo de Infecções — esterilização, biossegurança\n• Ciclos de Transmissão — vectores, prevenção"),
        Topic("Ética e Deontologia em Saúde",
            "Princípios éticos da prática profissional.\n\n• Bioética — autonomia, beneficência, justiça\n• Consentimento Informado — requisitos legais\n• Sigilo Profissional — confidencialidade\n• Direitos do Paciente — dignidade, privacidade\n• Código Deontológico — deveres profissionais\n• Dilemas Éticos — fim de vida, recusa de tratamento\n• Relação Terapêutica — comunicação empática"),
        Topic("Primeiros Socorros e Emergências",
            "Suporte básico de vida e emergências.\n\n• Suporte Básico de Vida — cadeia de sobrevivência\n• RCP — compressões torácicas, DEA\n• Abordagem ABCDE — via aérea, respiração, circulação\n• Hemorragias — classificação, hemostase\n• Fracturas — tipos, talas, imobilização\n• Queimaduras — classificação, regra dos 9\n• Intoxicações — descontaminação, antídotos")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConteudoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SoundManager.init(this)

        binding.btnBack.setOnClickListener { SoundManager.playClick(); finish() }
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
                foreground = getDrawable(android.R.attr.selectableItemBackground.let {
                    val attrs = intArrayOf(it)
                    val ta = obtainStyledAttributes(attrs)
                    val d = ta.getDrawable(0)
                    ta.recycle()
                    return@let 0
                }.let { android.R.attr.selectableItemBackground })
            }

            val inner = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                val dp16 = (16 * dp).toInt()
                setPadding(dp16, dp16, dp16, dp16)
            }

            // Icon circle with badge number
            val iconFrame = FrameLayout(this).apply {
                val size = (48 * dp).toInt()
                layoutParams = LinearLayout.LayoutParams(size, size).apply {
                    marginEnd = (14 * dp).toInt()
                }
                setBackgroundResource(R.drawable.bg_icon_circle)
            }

            val badge = TextView(this).apply {
                text = "${index + 1}"
                textSize = 16f
                setTextColor(getColor(R.color.primary))
                val flp = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
                flp.gravity = Gravity.CENTER
                layoutParams = flp
                paint.isFakeBoldText = true
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
                text = topic.content.split("\n").first()
                textSize = 12f
                setTextColor(getColor(R.color.muted_foreground))
                maxLines = 1
                ellipsize = android.text.TextUtils.TruncateAt.END
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
            card.addView(inner)

            // Click to expand/collapse
            var isExpanded = false
            val contentView = TextView(this).apply {
                text = topic.content
                textSize = 13f
                setTextColor(getColor(R.color.muted_foreground))
                setLineSpacing(0f, 1.4f)
                visibility = android.view.View.GONE
                val dp16 = (16 * dp).toInt()
                setPadding(dp16, 0, dp16, dp16)
            }

            val wrapper = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
            }
            wrapper.addView(inner)
            wrapper.addView(contentView)

            card.removeAllViews()
            card.addView(wrapper)

            card.setOnClickListener {
                SoundManager.playClick()
                isExpanded = !isExpanded
                contentView.visibility = if (isExpanded) android.view.View.VISIBLE else android.view.View.GONE
            }

            binding.topicsContainer.addView(card)
        }
    }
}
