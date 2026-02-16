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

        // 1. Coproparasitologia
        Topic(
            id = 1,
            title = "Coproparasitologia",
            icon = "🧬",
            summary = "Coprologia é a ciência que estuda as fezes",
            markdownContent = """
# Coproparasitologia

## Conceito de Coprologia
Coprologia é a ciência que estuda as fezes humanas e animais, permitindo identificar alterações fisiológicas, metabólicas e a presença de parasitas ou microrganismos. É essencial para diagnósticos laboratoriais e vigilância epidemiológica.

## Conceito de Parasitologia
Parasitologia é o estudo dos parasitas, organismos que vivem à custa de outros seres vivos, causando doenças. Engloba protozoários, helmintos e ectoparasitas, analisando seu ciclo de vida, patogenicidade e formas de transmissão.

## Importância do estudo das fezes
O exame de fezes permite diagnosticar infecções intestinais, parasitoses, distúrbios digestivos, alterações bioquímicas e hematológicas. Auxilia também na avaliação do estado nutricional e no monitoramento de terapias.

## Formação das fezes
As fezes se formam no intestino grosso, a partir da absorção de água e sais do quimo. A motilidade intestinal transforma o conteúdo em massa fecal, composta por resíduos alimentares, bactérias, células epiteliais descamadas e secreções digestivas.

## Característica fisiológica das fezes
As fezes normais possuem cor marrom devido à bilirrubina, odor característico, consistência moldável, forma cilíndrica e pH ligeiramente ácido.

## Principais componentes bioquímicos encontrados nas fezes
Incluem água, fibras alimentares, proteínas, lipídios, carboidratos não digeridos, sais minerais, enzimas digestivas e microrganismos simbióticos.

## Colheita, transporte e preservação de amostra
A amostra deve ser coletada em recipiente limpo, sem contato com urina ou água. O transporte deve ser imediato ou a amostra preservada em conservantes específicos, mantendo a integridade dos parasitas e estruturas celulares.

## Exame químico e microscópico das fezes
O exame químico detecta sangue oculto, gorduras e pH. O exame microscópico identifica ovos, cistos e larvas de parasitas, além de elementos celulares e bactérias patogénicas.

## Estudo dos protozoários
Protozoários intestinais mais comuns incluem *Giardia lamblia*, *Entamoeba histolytica* e *Cryptosporidium spp.*. Analisam-se morfologia, ciclo de vida, transmissibilidade e impacto clínico.

## Estudo dos platelmintos
Platelmintos, como tênias e trematódeos, são analisados quanto a ovos e segmentos eliminados nas fezes. A identificação permite diagnóstico e escolha adequada de terapêutica antiparasitária.

## Características gerais
O estudo coproparasitológico é essencial para a saúde pública, prevenção de epidemias e orientação de terapias individualizadas, sendo uma ferramenta fundamental em laboratórios de análises clínicas.
            """.trimIndent()
        ),

        // 2. Imunologia
        Topic(
            id = 2,
            title = "Imunologia",
            icon = "🛡️",
            summary = "Imunologia é a ciência que estuda o sistema imunitário",
            markdownContent = """
# Imunologia

## Conceitos de Imunologia
Imunologia é a ciência que estuda o sistema imunitário, seus componentes, mecanismos de defesa e respostas a agentes infecciosos, células anormais ou substâncias estranhas.

## Imunidade
Imunidade é a capacidade do organismo de reconhecer e neutralizar agentes estranhos, evitando doenças. Pode ser natural ou adquirida, ativa ou passiva.

## Funções do Sistema Imunológico
- Defesa contra patógenos
- Remoção de células neoplásicas
- Reconhecimento de substâncias estranhas
- Memória imunológica

## Imunidade Inata e Adquirida
A inata é imediata, não específica, formada por barreiras físicas, células fagocíticas e mediadores químicos. A adquirida é específica, envolve linfócitos T e B e produz anticorpos.

## Características das Imunidades
- Especificidade
- Diversidade
- Memória
- Tolerância a células próprias

## Principais componentes da Imunidade Inata
- Fagócitos: neutrófilos e macrófagos
- Barreiras físicas: pele e mucosas
- Mediadores químicos: citocinas, proteínas do complemento

## Principais componentes da Imunidade Adquirida
- Linfócitos T e B
- Anticorpos (IgG, IgM, IgA, IgE, IgD)
- Células apresentadoras de antígeno (APCs)

## Sistema de Complemento
Conjunto de proteínas plasmáticas que auxiliam na lise de células estranhas, opsonização e inflamação.

## Antigénios
Substâncias capazes de induzir resposta imunológica. Incluem proteínas, polissacarídeos e lipídios de patógenos, células e vacinas.

## Determinantes Antigénicos
Regiões específicas do antigénio que são reconhecidas por anticorpos ou receptores de células T.

## Imunogenicidade
Capacidade de um antigénio induzir resposta imunitária.

## Tipos de Antigénios
- Exógenos: provenientes do exterior
- Endógenos: produzidos pelo próprio organismo
- Autoantigénios: do próprio organismo, mas reconhecidos como estranhos em autoimunidade

## Antigénios dos grupos sanguíneos
Determinantes de sistemas ABO e Rh, importantes para transfusões e compatibilidade hemática.

## Imunoglobulinas
Proteínas produzidas pelos linfócitos B que reconhecem e neutralizam antigénios específicos.

## Resposta primária e secundária na elaboração de anticorpos
Primária: lenta, IgM predominante; Secundária: rápida, IgG predominante, memória imunológica.

## Hipersensibilidade
Resposta exagerada ou inadequada do sistema imunitário a antígenos, podendo ser imediata ou retardada.

## Diagnóstico das doenças sexualmente transmissíveis
Inclui testes sorológicos, detecção de antígenos, PCR e exames clínicos direcionados.
            """.trimIndent()
        ),

        // 3. Hematologia
        Topic(
            id = 3,
            title = "Hematologia",
            icon = "🩸",
            summary = "Hematologia é o estudo do sangue, suas células e funções fisiológicas.",
            markdownContent = """
# Hematologia

## Conceito, Composição e Função
Hematologia é o estudo do sangue, suas células e funções fisiológicas. O sangue é composto por plasma, eritrócitos, leucócitos e plaquetas, desempenhando transporte de gases, nutrientes, defesa e coagulação.

## Hematopoiese pré e pós-natal
Processo de formação das células sanguíneas. Pré-natal: fígado e baço; Pós-natal: medula óssea, principalmente esterno e pelve.

## Eritrócito: Tamanho, Forma, Cor e Composição
Células anucleadas, bicôncavas, 7–8 μm, cor avermelhada por hemoglobina, transportam O₂ e CO₂.

## Função Respiratória do Eritrócito
Hemoglobina transporta O₂ dos pulmões para tecidos e CO₂ do metabolismo celular para eliminação.

## Valores Normais e Variações
Homens: 4,5–5,9 milhões/μL; Mulheres: 4,1–5,1 milhões/μL. Variações: fisiológicas (altitude, gestação) e patológicas (anemias, policitemia).

## Volume Globular
Proporção do sangue ocupada por eritrócitos (hematócrito). Determinação: macrométodo e micrométodo. Valores normais: 40–54% homens, 37–47% mulheres. Possíveis erros: má mistura, anticoagulante inadequado.

## Contagem Global de Eritrócitos
Contagem direta ou automatizada; avaliação da concentração de células, usada para diagnosticar anemias e policitemia.

## Contagem de Reticulócitos
Avalia eritropoiese recente. Material: frotis, corantes supravital. Valores normais: 0,5–2,5% do total de eritrócitos.

## Anemias
Deficiência de eritrócitos ou hemoglobina. Classificação etiológica: ferropénica, megaloblástica, hemolítica; segundo resposta medular: regenerativa ou não regenerativa.

## Anemia Ferropénica
Causada por défice de ferro, alterações laboratoriais: microcitose, hipocromia, baixa ferritina.

## Anemia Megaloblástica
Défice de vitamina B12 ou ácido fólico; eritrocitos aumentados, hipersegmentação de neutrófilos, baixa maturação medular.

## Anemia Hemolítica
Destruição precoce de eritrócitos; icterícia, aumento de LDH e bilirrubina indireta.

## Policitemia
Aumento de eritrócitos; hematócrito elevado, risco de trombose.
            """.trimIndent()
        ),

        // 4. Microbiologia
        Topic(
            id = 4,
            title = "Microbiologia",
            icon = "🔬",
            summary = "Classificação Geral dos Microrganismos",
            markdownContent = """
# Microbiologia

## Classificação Geral dos Microrganismos
Inclui bactérias, vírus, fungos, protozoários e helmintos.

## Nomenclatura dos Microrganismos
Seguindo regras de binomial: gênero + espécie, conforme Código Internacional de Nomenclatura.

## Bactérias: Conceito e Estrutura
Unicelulares, procarióticas, parede celular, membrana, citoplasma, ribossomos. Movimentam-se por flagelos.

## Classificação e Taxonomia
Gram-positivas e Gram-negativas; aerobias, anaerobias; cocos, bacilos, espirilos.

## Metabolismo
Fonte de energia: fototróficos ou quimiotróficos; carbono: autotróficos ou heterotróficos.

## Reprodução
Bipartição, conjugação, transformação e transdução.

## Importância das Bactérias
Papel na digestão, síntese de vitaminas, patogenicidade e biotecnologia.

## Vírus
Agentes subcelulares, DNA ou RNA, parasitismo intracelular obrigatório, replicação específica ao hospedeiro.

## Ciclo Viral
Adsorção, penetração, replicação, montagem e liberação.

## Amostras em Bacteriologia
Coleta deve ser estéril, transporte correto, conservação adequada para viabilidade.
            """.trimIndent()
        ),

        // 5. Urinologia
        Topic(
            id = 5,
            title = "Urinologia",
            icon = "🚰",
            summary = "Estudo dos rins, formação da urina...",
            markdownContent = """
# Urinologia

## Os Rins: Sistema Primário
Órgãos responsáveis pela filtração do sangue, produção de urina, manutenção de equilíbrio hídrico e eletrolítico.

## Formação da Urina
Filtração glomerular, reabsorção tubular e secreção. Urina primária transformada em urina definitiva no túbulo renal.

## Colheita de Amostra de Urina
Urina deve ser coletada de forma asséptica, preferencialmente meia-manhã. Uso de recipiente limpo, preservação adequada.

## Exame Sumário de Urina
Avaliação física: cor, odor, aspecto, volume.  
Exame químico: pH, densidade, proteínas, glicose, bilirrubina, corpos cetónicos.  
Exame microscópico: células epiteliais, leucócitos, eritrócitos, cristais, cilindros.

## Urocultura
Avalia crescimento bacteriano, identifica patógenos e determina sensibilidade a antibióticos.

## Urina de 24, 12 e 8 Horas
Coleta seriada para dosagem de substâncias metabólicas e função renal.

## Exame Físico e Químico
Observa-se cor, odor, turbidez, volume, pH e densidade. Testes químicos podem ser feitos com tiras reativas ou métodos laboratoriais.

## Sedimento Urinário
Preparação e análise microscópica de elementos celulares, cilindros e cristais para diagnóstico clínico.
            """.trimIndent()
        ),
        // Parte 2 – Tópicos 6 a 10

// 6. Bioquímica Clínica
Topic(
    id = 6,
    title = "Bioquímica Clínica",
    icon = "🧪",
    summary = "Bioquímica clínica estuda substâncias químicas no corpo humano...",
    markdownContent = """
# Bioquímica Clínica

## Definição e Importância
Bioquímica clínica estuda substâncias químicas no corpo humano, suas alterações patológicas e indicadores diagnósticos, auxiliando no tratamento e monitoramento de doenças.

## Métodos Analíticos
- Gravimétricos: pesagem de substâncias após reação química.
- Turbidimétricos: medição de turbidez causada por precipitados.
- Colorimétricos: intensidade de cor proporcional à concentração.
- Gasométricos: determinação de gases sanguíneos.

## Proteínas do Soro e LCR
Determinação qualitativa e quantitativa de albumina e globulinas, usando métodos turbidimétricos, gravimétricos, colorimétricos e eletroforese.

## Método de Biuret
Fundamento: reação do cobre com ligações peptídicas. Permite dosagem total de proteínas no soro.

## Verde de Bromocresol
Usado para avaliar albumina e globulinas. Medição colorimétrica e cálculos proporcionais.

## Provas Qualitativas de Frações Proteicas
Identificação de proteínas específicas como imunoglobulinas e proteínas de fase aguda.

## Eletroforese
Separação de proteínas por mobilidade elétrica. Permite fracionamento em albumina, α, β e γ-globulinas.

## Curvas de Calibração
Criação de padrões de concentração conhecidos para quantificação de analitos.

## Ureia e Metabolismo da Glicose
Determinação da ureia, fundamentos, valores normais, causas de erro. Revisão do metabolismo da glicose, glicogénio e glicólise, regulação e implicações clínicas.

## Principais Causas de Alteração da Glicose
Diabetes mellitus, hipoglicemia, distúrbios hormonais e efeitos farmacológicos.
    """.trimIndent()
),

// 7. Covid-19
Topic(
    id = 7,
    title = "Covid-19",
    icon = "🦠",
    summary = "Doença respiratória causada pelo vírus SARS-CoV-2...",
    markdownContent = """
# Covid-19

## Conceito
Doença respiratória causada pelo vírus SARS-CoV-2, podendo variar de assintomática a grave.

## Etiologia
Causada por um coronavírus de RNA, altamente contagioso, transmitido por gotículas respiratórias, contato e aerossóis.

## Quadro Clínico
Febre, tosse seca, cansaço, dor de garganta, anosmia, dispneia em casos graves.

## Classificação
- Leve: sintomas respiratórios sem dificuldade.
- Moderada: pneumonia sem hipóxia grave.
- Grave: insuficiência respiratória, necessidade de oxigênio.
- Crítica: SDRA, choque séptico, falência de órgãos.

## Critérios de Diagnóstico
Exame PCR, antígeno, sorologia, histórico clínico e epidemiológico.

## Complicações
SDRA, trombose, miocardite, falência renal, sepse.

## Conduta
Isolamento, suporte sintomático, oxigenoterapia, anticoagulação quando indicada, monitoramento clínico.

## Prognóstico
Variável; dependente de idade, comorbidades, resposta imunológica e tratamento precoce.
    """.trimIndent()
),

// 8. Eritrograma
Topic(
    id = 8,
    title = "Eritrograma",
    icon = "🩸",
    summary = "Estudo dos hematométricos, avaliação...",
    markdownContent = """
# Eritrograma

## Avaliação Quantitativa
Determinação da concentração de eritrócitos por microlitro de sangue, hematócrito e hemoglobina.

## Avaliação Qualitativa
Observação de tamanho (microcítico, macrocítico), forma (anisocitose, poiquilocitose), coloração (hipocrômicos ou normocrômicos) e inclusões eritrocitárias.

## Índices Hematométricos
- VCM (Volume Corpuscular Médio)
- HCM (Hemoglobina Corpuscular Média)
- CHCM (Concentração de Hemoglobina Corpuscular Média)

## Interpretação Clínica
Auxilia no diagnóstico de anemias, policitemias e distúrbios hematológicos variados.
    """.trimIndent()
),

// 9. Leucograma
Topic(
    id = 9,
    title = "Leucograma",
    icon = "⚪",
    summary = "Estudo do Leucograma e suas avaliações.",
    markdownContent = """
# Leucograma

## Avaliação Quantitativa
Contagem total de leucócitos no sangue, útil para identificar leucocitose ou leucopenia.

## Avaliação Qualitativa
Análise morfológica dos leucócitos, presença de formas imaturas, segmentação de neutrófilos e linfócitos atípicos.

## Fórmula Leucocitária
Percentual de cada tipo celular (neutrófilos, linfócitos, monócitos, eosinófilos e basófilos).

## Importância Clínica
Diagnóstico de infecções, inflamações, imunodeficiências e desordens hematológicas.

## Interpretação dos Resultados
Comparação com valores normais, análise do padrão celular e correlação clínica.
    """.trimIndent()
),

// 10. Plaquetograma
Topic(
    id = 10,
    title = "Plaquetograma",
    icon = "🟣",
    summary = "Estudo da Plaquetograma e suas avaliações.",
    markdownContent = """
# Plaquetograma

## Avaliação Quantitativa e Qualitativa
Contagem de plaquetas e análise morfológica para detectar trombocitopenia ou trombocitose.

## Coagulograme
Avaliação da função plaquetária e fatores de coagulação.

## Factores de Coagulação
Identificação de deficiências ou disfunções de fatores VIII, IX, X, V e II, essenciais para hemostasia.

## Importância Clínica
Prevenção de hemorragias, monitoramento de terapias anticoagulantes e avaliação de risco trombótico.

## Hemóstase e Coagulação
Estudo integrado da fase vascular, plaquetária e plasmática da coagulação sanguínea.

## Interpretação dos Resultados
Integra dados quantitativos e qualitativos para orientar diagnóstico e tratamento.
    """.trimIndent()
),
// Parte 3 – Tópicos 11 a 15

// 11. Poiquilocitose Eritrocitária
Topic(
    id = 11,
    title = "Poiquilocitose Eritrocitária",
    icon = "🔴",
    summary = "Alterações morfológicas na forma dos eritrócitos, indicando desordens hematológicas.",
    markdownContent = """
# Poiquilocitose Eritrocitária

## Conceito
Alterações morfológicas na forma dos eritrócitos, indicando desordens hematológicas.

## Importância Clínica
Presente em anemias diversas (ferropénica, megaloblástica, hemolítica) e patologias hereditárias, como talassemia.

## Interpretação dos Resultados
Avaliação de formas anormais: ovalócitos, esferócitos, eliptócitos, dacriócitos, entre outros, correlacionando com quadro clínico.
    """.trimIndent()
),

// 12. Hemoglobinas Normais
Topic(
    id = 12,
    title = "Hemoglobinas Normais",
    icon = "🩸",
    summary = "Estudo das Hemoglobinas e Interpretação de resultados",
    markdownContent = """
# Hemoglobinas Normais

## Tipos
- HbA (α2β2): principal no adulto.
- HbA2 (α2δ2): presente em pequenas proporções.
- HbF (α2γ2): predominante no feto, normalmente <1% no adulto.

## Interpretação dos Resultados
Valores fora da faixa normal podem indicar hemoglobinopatias ou distúrbios eritrocitários.
    """.trimIndent()
),

// 13. Hemoglobinopatias
Topic(
    id = 13,
    title = "Hemoglobinopatias",
    icon = "🧬",
    summary = "Estudo das Hemoglobinopatias.",
    markdownContent = """
# Hemoglobinopatias

## Drepanocitose (Anemia Falciforme)
Mutação genética causando HbS; eritrócitos em foice, fragilidade celular, risco de crises vaso-oclusivas.

## Talassemias
Deficiência na produção de cadeias globínicas α ou β; anemia microcítica e variabilidade clínica.

## Diagnóstico
Eletroforese de hemoglobina, HPLC, testes genéticos, exame clínico e hematológico.

## Interpretação dos Resultados
Identificação de tipos de hemoglobina anormais e determinação da gravidade clínica.
    """.trimIndent()
),

// 14. Factores de Virulência Microbianos e Estratégias de Escape
Topic(
    id = 14,
    title = "Factores de Virulência Microbianos",
    icon = "🦠",
    summary = "Mecanismos que permitem aos microrganismos causar doença e evadir a resposta imunológica.",
    markdownContent = """
# Factores de Virulência Microbianos e Estratégias de Escape

## Conceito
Mecanismos que permitem aos microrganismos causar doença e evadir a resposta imunológica.

## Principais Factores
- Andesinas e toxinas: danificam células e tecidos.
- Enzimas: degradam barreiras teciduais e imunológicas.
- Resistência ao complemento: inibe lise celular mediada por proteínas do sistema complemento.
- Escape à fagocitose: inibição da ingestão ou sobrevivência intracelular.
- Parasitismo intracelular: replicação protegida dentro de células hospedeiras.
- Escape ao sistema imunológico: variação antigénica, mimetismo molecular.

## Importância Clínica
Conhecimento fundamental para diagnóstico, prevenção, desenvolvimento de vacinas e terapias antimicrobianas.
    """.trimIndent()
),

// 15. Causas e Consequências da Infecção
Topic(
    id = 15,
    title = "Causas e Consequências da Infecção",
    icon = "🧫",
    summary = "Causas, Consequências e Importância Clínica.",
    markdownContent = """
# Causas e Consequências da Infecção

## Causas
- Microorganismos patogénicos: bactérias, vírus, fungos e parasitas.
- Condições do hospedeiro: imunodeficiência, doenças crónicas, higiene deficiente.
- Fatores ambientais: saneamento, clima, contaminação alimentar ou hídrica.

## Consequências
- Locais: inflamação, necrose tecidual, abscessos.
- Sistémicas: febre, choque séptico, falência de órgãos.
- Alterações laboratoriais: leucocitose, elevação de marcadores inflamatórios, alterações bioquímicas e hematológicas.

## Importância Clínica
Avaliação integrada de fatores causais e resposta do organismo permite diagnóstico, tratamento e prevenção de complicações.
    """.trimIndent()
)
)
}
