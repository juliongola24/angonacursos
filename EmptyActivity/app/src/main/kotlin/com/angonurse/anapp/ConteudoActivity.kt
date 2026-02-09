package com.angonurse.anapp

import android.os.Bundle
import android.text.Html
import android.widget.LinearLayout
import android.widget.TextView
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

        topics.forEachIndexed { index, topic ->
            val card = CardView(this).apply {
                radius = 12f * resources.displayMetrics.density
                cardElevation = 4f * resources.displayMetrics.density
                setCardBackgroundColor(getColor(R.color.card))
                val lp = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                lp.bottomMargin = (12 * resources.displayMetrics.density).toInt()
                layoutParams = lp
            }

            val inner = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                val dp20 = (20 * resources.displayMetrics.density).toInt()
                setPadding(dp20, dp20, dp20, dp20)
            }

            // Badge + Title
            val titleRow = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = android.view.Gravity.CENTER_VERTICAL
                val lp = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                lp.bottomMargin = (12 * resources.displayMetrics.density).toInt()
                layoutParams = lp
            }

            val badge = TextView(this).apply {
                text = "${index + 1}"
                textSize = 14f
                setTextColor(getColor(R.color.primary_foreground))
                val size = (32 * resources.displayMetrics.density).toInt()
                val lp = LinearLayout.LayoutParams(size, size)
                lp.marginEnd = (12 * resources.displayMetrics.density).toInt()
                layoutParams = lp
                gravity = android.view.Gravity.CENTER
                setBackgroundResource(R.drawable.bg_score_badge)
            }

            val title = TextView(this).apply {
                text = topic.title
                textSize = 16f
                setTextColor(getColor(R.color.foreground))
                paint.isFakeBoldText = true
            }

            titleRow.addView(badge)
            titleRow.addView(title)

            val content = TextView(this).apply {
                text = topic.content
                textSize = 13f
                setTextColor(getColor(R.color.muted_foreground))
                setLineSpacing(0f, 1.4f)
            }

            inner.addView(titleRow)
            inner.addView(content)
            card.addView(inner)
            binding.topicsContainer.addView(card)
        }
    }
}
