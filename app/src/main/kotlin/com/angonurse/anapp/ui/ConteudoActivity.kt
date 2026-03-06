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

data class Topic(val title: String, val content: String)

class ConteudoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConteudoBinding

    private val topics = listOf(
        Topic("Anatomia e Fisiologia Humana",
            "Estudo detalhado dos sistemas do corpo humano:\n\n• Sistema Nervoso — central e periférico, arco reflexo\n• Sistema Cardiovascular — coração, vasos, ciclo cardíaco\n• Sistema Respiratório — mecânica ventilatória, trocas gasosas\n• Sistema Digestivo — digestão mecânica e química\n• Sistema Urinário — filtração glomerular, equilíbrio ácido-base\n• Sistema Endócrino — eixos hormonais, feedback\n• Sistema Musculoesquelético — articulações, contracção\n• Sistema Linfático — imunidade inata e adaptativa"),
        Topic("Farmacologia e Terapêutica",
            "Estudo das classes de medicamentos e farmacocinética:\n\n• Farmacocinética — absorção, distribuição, metabolismo, excreção\n• Farmacodinâmica — receptores, agonistas, antagonistas\n• Anti-infecciosos — antibióticos, antifúngicos, antivirais\n• Analgésicos e Anti-inflamatórios — AINEs, opióides\n• Fármacos Cardiovasculares — anti-hipertensores, diuréticos\n• Interacções Medicamentosas\n• Os 9 certos da administração de medicamentos"),
        Topic("Enfermagem Clínica e Cirúrgica",
            "Cuidados pré, intra e pós-operatórios:\n\n• Avaliação Pré-operatória — checklist cirúrgico\n• Sinais Vitais — PA, FC, FR, temperatura, SpO₂\n• Gestão da Dor — escalas EVA, Wong-Baker\n• Cuidados com Feridas — cicatrização, pensos\n• Prevenção de IACS — técnica asséptica\n• Drenos e Sondas\n• Complicações Pós-operatórias — hemorragia, TVP, embolia"),
        Topic("Saúde Materno-Infantil",
            "Assistência à mulher grávida e ao recém-nascido:\n\n• Assistência Pré-natal — consultas, sinais de alarme\n• Trabalho de Parto — fases, partograma\n• Cuidados ao Recém-nascido — Apgar, triagem neonatal\n• Aleitamento Materno — técnicas, vantagens\n• Vacinação Infantil — calendário vacinal angolano\n• Crescimento e Desenvolvimento\n• Patologias Pediátricas — diarreia, pneumonia, malária"),
        Topic("Saúde Pública e Epidemiologia",
            "Determinantes de saúde e vigilância epidemiológica:\n\n• Epidemiologia — incidência, prevalência\n• Indicadores de Saúde — mortalidade, esperança de vida\n• Doenças Transmissíveis — malária, TB, VIH, cólera\n• Doenças Não Transmissíveis — HTA, diabetes, cancro\n• Promoção da Saúde — educação sanitária\n• Vigilância Epidemiológica — notificação, investigação de surtos\n• Programas Nacionais — PAV, PNCT"),
        Topic("Microbiologia e Parasitologia",
            "Microrganismos patogénicos relevantes em Angola:\n\n• Bacteriologia — Gram-positivas e negativas, resistência\n• Virologia — VIH, hepatites, Ébola, SARS-CoV-2\n• Parasitologia — Plasmodium, helmintas, protozoários\n• Micologia — Candida, dermatófitos\n• Diagnóstico Laboratorial — Gram, culturas, testes rápidos\n• Controlo de Infecções — esterilização, biossegurança\n• Ciclos de Transmissão — vectores, hospedeiros"),
        Topic("Ética e Deontologia em Saúde",
            "Princípios éticos da prática profissional:\n\n• Bioética — autonomia, beneficência, não-maleficência, justiça\n• Consentimento Informado\n• Sigilo Profissional — confidencialidade\n• Direitos do Paciente — dignidade, privacidade\n• Código Deontológico — deveres profissionais\n• Dilemas Éticos — fim de vida, recusa de tratamento\n• Relação Terapêutica — comunicação empática"),
        Topic("Primeiros Socorros e Emergências",
            "Suporte básico de vida e emergências:\n\n• Cadeia de Sobrevivência — algoritmo SBV\n• RCP — compressões, ventilações, DEA\n• Abordagem ABCDE\n• Hemorragias — hemostase, torniquete\n• Fracturas e Imobilização — talas\n• Queimaduras — regra dos 9\n• Intoxicações — descontaminação, antídotos")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConteudoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }

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
            holder.tvContent.text = topic.content
        }

        override fun getItemCount() = topics.size
    }
}
