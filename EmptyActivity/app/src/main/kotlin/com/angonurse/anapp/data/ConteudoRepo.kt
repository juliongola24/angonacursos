package com.angonurse.anapp.data

data class Topic(
    val id: Int,
    val title: String,
    val icon: String,
    val summary: String,
    val markdownContent: String
)

object ConteudoRepo {

    val topics: List<Topic> = listOf(
        Topic(
            id = 1,
            title = "Anatomia e Fisiologia Humana",
            icon = "🧬",
            summary = "Estudo detalhado dos sistemas do corpo humano.",
            markdownContent = """
# Anatomia e Fisiologia Humana

> *Estudo detalhado dos sistemas do corpo humano e suas funções vitais.*

---

## Sistema Nervoso
O sistema nervoso divide-se em **central** (encéfalo e medula espinhal) e **periférico** (nervos cranianos e espinhais).

- **Neurónios** — unidade funcional do sistema nervoso
- **Sinapses** — transmissão de impulsos nervosos
- **Arco reflexo** — resposta involuntária a estímulos

## Sistema Cardiovascular
Responsável pelo transporte de **oxigénio**, nutrientes e resíduos metabólicos.

- **Coração** — 4 câmaras, ciclo cardíaco
- **Vasos sanguíneos** — artérias, veias, capilares
- **Circulação** — pulmonar e sistémica

## Sistema Respiratório
Garante as trocas gasosas entre o organismo e o meio externo.

- **Mecânica ventilatória** — inspiração e expiração
- **Hematose** — troca gasosa alveolar
- **Volumes pulmonares** — capacidade vital, volume residual

## Sistema Digestivo
Responsável pela **digestão mecânica e química** dos alimentos.

- **Boca → Esófago → Estômago** — digestão inicial
- **Intestino delgado** — absorção de nutrientes
- **Intestino grosso** — absorção de água, formação de fezes

## Sistema Urinário
Filtra o sangue e elimina resíduos metabólicos.

- **Filtração glomerular** — nefrão como unidade funcional
- **Reabsorção tubular** — glicose, aminoácidos, água
- **Equilíbrio hidro-electrolítico** — regulação do pH

## Sistema Endócrino
Sistema de comunicação por **hormonas** que regulam funções corporais.

- **Eixos hormonais** — hipotálamo-hipófise-órgão alvo
- **Tiróide** — T3, T4, metabolismo
- **Pâncreas** — insulina, glucagon

## Sistema Musculoesquelético
Suporte estrutural e locomoção do corpo.

- **Tipos de articulações** — sinoviais, fibrosas, cartilagíneas
- **Músculos** — esqueléticos, lisos, cardíaco
- **Ossos** — tipos, composição, remodelação

## Sistema Linfático
Defesa imunológica e drenagem de líquidos intersticiais.

- **Imunidade inata** — barreiras físicas, fagócitos
- **Imunidade adaptativa** — linfócitos T e B, anticorpos
- **Órgãos linfóides** — timo, baço, gânglios
            """.trimIndent()
        ),

        Topic(
            id = 2,
            title = "Farmacologia e Terapêutica",
            icon = "💊",
            summary = "Estudo das classes de medicamentos e farmacocinética.",
            markdownContent = """
# Farmacologia e Terapêutica

> *Compreender os mecanismos de acção dos fármacos e a sua aplicação clínica.*

---

## Farmacocinética — ADME

O percurso do fármaco no organismo segue quatro etapas:

1. **Absorção** — passagem do fármaco para a corrente sanguínea
2. **Distribuição** — transporte para os tecidos-alvo
3. **Metabolismo** — biotransformação hepática (citocromo P450)
4. **Excreção** — eliminação renal, hepática, pulmonar

## Farmacodinâmica

Estudo do **efeito do fármaco** no organismo.

- **Receptores** — proteínas-alvo dos fármacos
- **Agonistas** — activam o receptor
- **Antagonistas** — bloqueiam o receptor
- **Dose-resposta** — curva sigmoide, ED50

## Anti-infecciosos

| Classe | Exemplos | Mecanismo |
|--------|----------|-----------|
| **Antibióticos** | Amoxicilina, Ciprofloxacina | Inibição da parede celular |
| **Antifúngicos** | Fluconazol, Anfotericina B | Alteração da membrana fúngica |
| **Antivirais** | Aciclovir, Oseltamivir | Inibição da replicação viral |

## Analgésicos

- **AINEs** — ibuprofeno, diclofenac (inibição COX)
- **Opióides** — morfina, tramadol (receptores μ)
- **Escala da OMS** — 3 degraus para controlo da dor

## Fármacos Cardiovasculares

- **Anti-hipertensores** — IECAs, ARAs, bloqueadores dos canais de cálcio
- **Diuréticos** — tiazídicos, da ansa, poupadores de potássio
- **Anticoagulantes** — heparina, varfarina

## Cuidados de Enfermagem

> **Os 9 Certos da Administração de Medicamentos:**
> 1. Paciente certo
> 2. Medicamento certo
> 3. Dose certa
> 4. Via certa
> 5. Hora certa
> 6. Registo certo
> 7. Orientação certa
> 8. Forma certa
> 9. Resposta certa
            """.trimIndent()
        ),

        Topic(
            id = 3,
            title = "Enfermagem Clínica e Cirúrgica",
            icon = "🏥",
            summary = "Cuidados pré, intra e pós-operatórios.",
            markdownContent = """
# Enfermagem Clínica e Cirúrgica

> *Cuidados de enfermagem nas fases pré, intra e pós-operatórias.*

---

## Avaliação Pré-operatória

- **Checklist cirúrgico** — protocolo de segurança da OMS
- **Anamnese** — antecedentes, alergias, medicação
- **Exames** — hemograma, coagulação, ECG
- **Jejum** — mínimo 6–8 horas

## Sinais Vitais

| Parâmetro | Valores Normais |
|-----------|----------------|
| **PA** | 120/80 mmHg |
| **FC** | 60–100 bpm |
| **FR** | 12–20 cpm |
| **Temperatura** | 36–37.5°C |
| **SpO₂** | 95–100% |

## Gestão da Dor

Escalas de avaliação:
- **EVA** — Escala Visual Analógica (0–10)
- **Wong-Baker** — faces para crianças
- **FLACC** — para neonatos e lactentes

## Cuidados com Feridas

- **Cicatrização** — 1ª, 2ª e 3ª intenção
- **Pensos** — húmidos, secos, alginatos, hidrogéis
- **Técnica asséptica** — limpeza de dentro para fora

## Drenos e Sondas

- **Drenos** — Penrose, Jackson-Pratt, tórax
- **Sondas** — nasogástrica, vesical (Foley)
- **Cuidados** — fixação, débito, permeabilidade

## Complicações Pós-operatórias

- **Hemorragia** — sinais de choque hipovolémico
- **TVP** — trombose venosa profunda, sinal de Homans
- **Infecção** — sinais flogísticos, febre >38.5°C
- **Atelectasia** — exercícios respiratórios, espirometria
            """.trimIndent()
        ),

        Topic(
            id = 4,
            title = "Saúde Materno-Infantil",
            icon = "👶",
            summary = "Assistência à mulher grávida e ao recém-nascido.",
            markdownContent = """
# Saúde Materno-Infantil

> *Assistência integral à mulher no ciclo gravídico-puerperal e cuidados ao recém-nascido.*

---

## Assistência Pré-natal

- **Consultas** — mínimo 8 consultas (OMS)
- **Exames** — hemograma, tipagem, serologias, ecografia
- **Sinais de alarme** — hemorragia, edema, cefaleias intensas

## Trabalho de Parto

Fases do parto:
1. **Dilatação** — contracções regulares, dilatação cervical
2. **Expulsão** — nascimento do bebé
3. **Dequitadura** — saída da placenta

> **Partograma** — registo gráfico da evolução do trabalho de parto

## Cuidados ao Recém-nascido

- **Índice de Apgar** — avaliação ao 1º e 5º minuto
- **Triagem neonatal** — teste do pezinho
- **Cuidados imediatos** — aquecimento, aspiração, clampagem

## Aleitamento Materno

- **Técnicas** — pega correcta, posicionamento
- **Vantagens** — imunológicas, nutricionais, vínculo afectivo
- **Contra-indicações** — VIH, medicamentos específicos

## Vacinação Infantil

Calendário vacinal angolano inclui:
- **BCG** — nascimento
- **VPO/VIP** — pólio
- **Pentavalente** — DPT + HepB + Hib
- **Sarampo** — 9 meses

## Patologias Pediátricas Comuns

- **Diarreia** — TRO, plano de tratamento A/B/C
- **Pneumonia** — classificação AIDI, antibioterapia
- **Malária** — ACT, prevenção com mosquiteiros
            """.trimIndent()
        ),

        Topic(
            id = 5,
            title = "Saúde Pública e Epidemiologia",
            icon = "📊",
            summary = "Determinantes de saúde e vigilância epidemiológica.",
            markdownContent = """
# Saúde Pública e Epidemiologia

> *Estudo dos determinantes de saúde, prevenção de doenças e vigilância epidemiológica.*

---

## Conceitos Epidemiológicos

- **Incidência** — casos novos / população em risco
- **Prevalência** — casos existentes / população total
- **Mortalidade** — óbitos / população
- **Letalidade** — óbitos / casos confirmados

## Indicadores de Saúde

| Indicador | Significado |
|-----------|------------|
| **Taxa de mortalidade infantil** | Óbitos <1 ano / nascidos vivos × 1000 |
| **Esperança de vida** | Anos médios de vida esperados |
| **Taxa de natalidade** | Nascimentos / população × 1000 |

## Doenças Transmissíveis

- **Malária** — *Plasmodium falciparum*, transmissão por *Anopheles*
- **Tuberculose** — *Mycobacterium tuberculosis*, DOTS
- **VIH/SIDA** — prevenção, TARV, adesão terapêutica

## Doenças Não Transmissíveis

- **Hipertensão arterial** — factores de risco, monitorização
- **Diabetes mellitus** — tipo 1 e 2, HbA1c
- **Cancro** — rastreio, prevenção primária

## Promoção da Saúde

- **Educação sanitária** — mudança de comportamentos
- **Saneamento básico** — água potável, eliminação de resíduos
- **Prevenção** — primária, secundária, terciária

## Programas Nacionais de Saúde

- **PAV** — Programa Alargado de Vacinação
- **PNCT** — Programa Nacional de Controlo da Tuberculose
- **PNLP** — Programa Nacional de Luta contra o Paludismo
            """.trimIndent()
        ),

        Topic(
            id = 6,
            title = "Microbiologia e Parasitologia",
            icon = "🔬",
            summary = "Microrganismos patogénicos e infecções relevantes.",
            markdownContent = """
# Microbiologia e Parasitologia

> *Estudo dos microrganismos causadores de doenças e mecanismos de controlo de infecções.*

---

## Bacteriologia

- **Gram-positivas** — *Staphylococcus*, *Streptococcus*
- **Gram-negativas** — *E. coli*, *Klebsiella*, *Pseudomonas*
- **Coloração de Gram** — método de identificação rápida
- **Resistência antimicrobiana** — MRSA, bactérias MDR

## Virologia

- **VIH** — retrovírus, destruição de CD4
- **Hepatites** — A (feco-oral), B e C (sangue)
- **Ébola** — febre hemorrágica, alta letalidade
- **COVID-19** — SARS-CoV-2, medidas de prevenção

## Parasitologia

- **Plasmodium** — ciclo de vida, malária
- **Helmintas** — *Ascaris*, *Ancylostoma*, *Schistosoma*
- **Protozoários** — *Giardia*, *Entamoeba*, *Trypanosoma*

## Micologia

- **Candida** — candidíase oral e vaginal
- **Dermatófitos** — tinhas, onicomicose
- **Fungos oportunistas** — *Aspergillus*, *Cryptococcus*

## Controlo de Infecções

> **Cadeia de transmissão:**
> Agente → Reservatório → Porta de saída → Modo de transmissão → Porta de entrada → Hospedeiro

- **Esterilização** — autoclave, calor seco
- **Desinfecção** — álcool 70%, hipoclorito
- **Biossegurança** — EPIs, precauções padrão
            """.trimIndent()
        ),

        Topic(
            id = 7,
            title = "Ética e Deontologia em Saúde",
            icon = "⚖️",
            summary = "Princípios éticos da prática profissional.",
            markdownContent = """
# Ética e Deontologia em Saúde

> *Princípios éticos fundamentais que orientam a prática profissional de enfermagem.*

---

## Princípios da Bioética

Os quatro pilares fundamentais:

1. **Autonomia** — respeito pela decisão do paciente
2. **Beneficência** — agir em benefício do paciente
3. **Não-maleficência** — *primum non nocere* (primeiro, não causar dano)
4. **Justiça** — distribuição equitativa dos recursos de saúde

## Consentimento Informado

- **Requisitos** — informação completa, compreensão, voluntariedade
- **Capacidade** — avaliação da competência do paciente
- **Documentação** — formulário escrito, assinatura

## Sigilo Profissional

> *"O enfermeiro deve guardar segredo profissional sobre os factos de que tenha conhecimento no exercício da sua profissão."*

- **Confidencialidade** — protecção dos dados do paciente
- **Excepções** — ordem judicial, doenças de notificação obrigatória

## Direitos do Paciente

- **Dignidade** — tratamento respeitoso
- **Privacidade** — durante exames e procedimentos
- **Informação** — sobre diagnóstico e tratamento
- **Recusa** — direito de recusar tratamento

## Código Deontológico

- **Deveres** — competência, actualização, respeito
- **Proibições** — discriminação, negligência
- **Responsabilidade** — disciplinar, civil, penal

## Dilemas Éticos

- **Fim de vida** — cuidados paliativos vs. obstinação terapêutica
- **Recusa de tratamento** — respeito pela autonomia
- **Alocação de recursos** — critérios de priorização
            """.trimIndent()
        ),

        Topic(
            id = 8,
            title = "Primeiros Socorros e Emergências",
            icon = "🚑",
            summary = "Suporte básico de vida e emergências.",
            markdownContent = """
# Primeiros Socorros e Emergências

> *Procedimentos de emergência e suporte básico de vida para salvar vidas.*

---

## Suporte Básico de Vida (SBV)

**Cadeia de sobrevivência:**
1. Reconhecimento precoce e pedido de ajuda
2. RCP precoce
3. Desfibrilhação precoce
4. Suporte avançado de vida

## Reanimação Cardiopulmonar (RCP)

- **Compressões torácicas** — 30:2, profundidade 5–6 cm
- **Frequência** — 100–120 compressões/minuto
- **DEA** — Desfibrilhador Externo Automático, ritmos desfibrilháveis

> ⚠️ **Não interromper compressões por mais de 10 segundos!**

## Abordagem ABCDE

| Letra | Significado | Acção |
|-------|------------|-------|
| **A** | *Airway* | Permeabilizar via aérea |
| **B** | *Breathing* | Avaliar respiração, O₂ |
| **C** | *Circulation* | Controlar hemorragias, acessos |
| **D** | *Disability* | Escala de Glasgow, pupilas |
| **E** | *Exposure* | Exposição, prevenir hipotermia |

## Hemorragias

- **Classificação** — classes I a IV (por volume perdido)
- **Hemostase** — compressão directa, torniquete (último recurso)
- **Sinais de choque** — taquicardia, hipotensão, palidez

## Fracturas

- **Tipos** — abertas vs. fechadas, completas vs. incompletas
- **Imobilização** — talas, triângulo, posição anatómica
- **Sinais** — dor, deformidade, crepitação, edema

## Queimaduras

- **Graus** — 1º (eritema), 2º (flictenas), 3º (escara)
- **Regra dos 9** — estimativa da área corporal queimada
- **Tratamento** — arrefecimento, cobrir, fluidoterapia

## Intoxicações

- **Descontaminação** — lavagem gástrica, carvão activado
- **Antídotos** — naloxona (opióides), atropina (organofosforados)
- **Monitorização** — sinais vitais, nível de consciência
            """.trimIndent()
        )
    )
}
