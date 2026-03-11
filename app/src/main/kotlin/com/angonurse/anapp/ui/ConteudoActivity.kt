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
import com.angonurse.anapp.databinding.ActivityConteudoBinding
import io.noties.markwon.Markwon

data class Topic(val title: String, val content: String)

class ConteudoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConteudoBinding
    private lateinit var markwon: Markwon

    private val topics = listOf(
        Topic("Anatomia e Fisiologia Humana",
            """Estudo detalhado dos sistemas do corpo humano:

- **Sistema Nervoso** — central e periférico, arco reflexo
- **Sistema Cardiovascular** — coração, vasos, ciclo cardíaco
- **Sistema Respiratório** — mecânica ventilatória, trocas gasosas
- **Sistema Digestivo** — digestão mecânica e química
- **Sistema Urinário** — filtração glomerular, equilíbrio ácido-base
- **Sistema Endócrino** — eixos hormonais, feedback
- **Sistema Musculoesquelético** — articulações, contracção
- **Sistema Linfático** — imunidade inata e adaptativa"""),
        Topic("Farmacologia e Terapêutica",
            """Estudo das classes de medicamentos e farmacocinética:

- **Farmacocinética** — absorção, distribuição, metabolismo, excreção
- **Farmacodinâmica** — receptores, agonistas, antagonistas
- **Anti-infecciosos** — antibióticos, antifúngicos, antivirais
- **Analgésicos e Anti-inflamatórios** — AINEs, opióides
- **Fármacos Cardiovasculares** — anti-hipertensores, diuréticos
- **Interacções Medicamentosas**
- **Os 9 certos** da administração de medicamentos"""),
        Topic("Enfermagem Clínica e Cirúrgica",
            """Cuidados pré, intra e pós-operatórios:

- **Avaliação Pré-operatória** — checklist cirúrgico
- **Sinais Vitais** — PA, FC, FR, temperatura, SpO₂
- **Gestão da Dor** — escalas EVA, Wong-Baker
- **Cuidados com Feridas** — cicatrização, pensos
- **Prevenção de IACS** — técnica asséptica
- **Drenos e Sondas**
- **Complicações Pós-operatórias** — hemorragia, TVP, embolia"""),
        Topic("Saúde Materno-Infantil",
            """Assistência à mulher grávida e ao recém-nascido:

- **Assistência Pré-natal** — consultas, sinais de alarme
- **Trabalho de Parto** — fases, partograma
- **Cuidados ao Recém-nascido** — Apgar, triagem neonatal
- **Aleitamento Materno** — técnicas, vantagens
- **Vacinação Infantil** — calendário vacinal angolano
- **Crescimento e Desenvolvimento**
- **Patologias Pediátricas** — diarreia, pneumonia, malária"""),
        Topic("Saúde Pública e Epidemiologia",
            """Determinantes de saúde e vigilância epidemiológica:

- **Epidemiologia** — incidência, prevalência
- **Indicadores de Saúde** — mortalidade, esperança de vida
- **Doenças Transmissíveis** — malária, TB, VIH, cólera
- **Doenças Não Transmissíveis** — HTA, diabetes, cancro
- **Promoção da Saúde** — educação sanitária
- **Vigilância Epidemiológica** — notificação, investigação de surtos
- **Programas Nacionais** — PAV, PNCT"""),
        Topic("Microbiologia e Parasitologia",
            """Microrganismos patogénicos relevantes em Angola:

- **Bacteriologia** — Gram-positivas e negativas, resistência
- **Virologia** — VIH, hepatites, Ébola, SARS-CoV-2
- **Parasitologia** — *Plasmodium*, helmintas, protozoários
- **Micologia** — Candida, dermatófitos
- **Diagnóstico Laboratorial** — Gram, culturas, testes rápidos
- **Controlo de Infecções** — esterilização, biossegurança
- **Ciclos de Transmissão** — vectores, hospedeiros"""),
        Topic("Ética e Deontologia em Saúde",
            """Princípios éticos da prática profissional:

- **Bioética** — autonomia, beneficência, não-maleficência, justiça
- **Consentimento Informado**
- **Sigilo Profissional** — confidencialidade
- **Direitos do Paciente** — dignidade, privacidade
- **Código Deontológico** — deveres profissionais
- **Dilemas Éticos** — fim de vida, recusa de tratamento
- **Relação Terapêutica** — comunicação empática"""),
        Topic("Primeiros Socorros e Emergências",
            """Suporte básico de vida e emergências:

- **Cadeia de Sobrevivência** — algoritmo SBV
- **RCP** — compressões, ventilações, DEA
- **Abordagem ABCDE**
- **Hemorragias** — hemostase, torniquete
- **Fracturas e Imobilização** — talas
- **Queimaduras** — regra dos 9
- **Intoxicações** — descontaminação, antídotos""")
    )

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
            val topic = topics[position]
            holder.tvNumber.text = "${position + 1}"
            holder.tvTitle.text = topic.title
            markwon.setMarkdown(holder.tvContent, topic.content)
        }

        override fun getItemCount() = topics.size
    }
}
