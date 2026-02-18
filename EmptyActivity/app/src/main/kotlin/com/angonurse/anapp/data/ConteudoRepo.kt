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

        // 1. Conceitos Básicos de Fisioterapia
        Topic(
            id = 1,
            title = "Conceitos Básicos de Fisioterapia",
            icon = "🏃",
            summary = "Definição, objectivos, áreas de actuação e princípios fundamentais da Fisioterapia.",
            markdownContent = """
# Conceitos Básicos de Fisioterapia

## Definição

A Fisioterapia é a ciência da saúde que estuda, diagnostica, previne e trata os distúrbios cinético-funcionais do corpo humano. Utiliza recursos físicos como movimento, calor, frio, electricidade, luz e água para promover a recuperação funcional, aliviar a dor e restaurar a qualidade de vida do paciente.

O fisioterapeuta é o profissional habilitado a avaliar, diagnosticar e tratar alterações do movimento humano, actuando em todas as fases da vida — desde o neonato até ao idoso — com abordagem tanto preventiva quanto curativa.

## Objectivos da Fisioterapia

Os principais objectivos incluem a reabilitação funcional do paciente, a prevenção de incapacidades, a promoção da saúde e do bem-estar, a melhoria da qualidade de vida, o alívio da dor, a manutenção e recuperação da amplitude de movimento articular, o fortalecimento muscular e a reeducação postural.

## Áreas de Actuação

A Fisioterapia actua em diversas áreas especializadas: Fisioterapia Respiratória e Cardíaca, Fisioterapia Traumato-Ortopédica, Fisioterapia Neurológica, Fisioterapia Desportiva, Fisioterapia Dermatofuncional, Fisioterapia em Terapia Intensiva, Fisioterapia Materno-Infantil, Fisioterapia Geriátrica, Fisioterapia do Trabalho e Fisioterapia Neuromuscular.

## Princípios Fundamentais

A prática fisioterapêutica baseia-se na avaliação cinético-funcional completa do paciente, na elaboração de um plano terapêutico individualizado, na aplicação de técnicas baseadas em evidência científica, na reavaliação periódica dos resultados e na alta fisioterapêutica quando os objectivos são alcançados. O fisioterapeuta deve respeitar a autonomia do paciente, actuar de forma ética e manter-se actualizado cientificamente.
            """.trimIndent()
        ),

        // 2. Fisioterapia Respiratória e Cardíaca
        Topic(
            id = 2,
            title = "Fisioterapia Respiratória e Cardíaca",
            icon = "🫁",
            summary = "Insuficiência Cardíaca, DPOC e Insuficiência Respiratória: abordagem fisioterapêutica.",
            markdownContent = """
# Fisioterapia Respiratória e Cardíaca

## Insuficiência Cardíaca (IC)

A Insuficiência Cardíaca é a incapacidade do coração de bombear sangue suficiente para suprir as necessidades metabólicas do organismo. Manifesta-se com dispneia, fadiga, edema periférico e intolerância ao exercício.

A fisioterapia na IC visa melhorar a capacidade funcional e a qualidade de vida. Os recursos incluem exercícios aeróbicos de baixa a moderada intensidade, treino de resistência muscular periférica, exercícios respiratórios para melhorar a ventilação, técnicas de conservação de energia e educação do paciente sobre auto-cuidado. A reabilitação cardíaca é dividida em fases: fase hospitalar (I), fase ambulatorial precoce (II), fase ambulatorial tardia (III) e fase de manutenção (IV).

## Doença Pulmonar Obstrutiva Crónica (DPOC)

A DPOC é uma doença prevenível e tratável caracterizada por limitação persistente do fluxo aéreo, geralmente progressiva, associada a resposta inflamatória crónica das vias aéreas e dos pulmões a partículas e gases nocivos. Inclui a bronquite crónica e o enfisema pulmonar.

A fisioterapia respiratória na DPOC inclui técnicas de desobstrução brônquica como drenagem postural, percussão torácica e vibração, reeducação diafragmática, exercícios de expansão pulmonar, treino de resistência muscular inspiratória, exercícios aeróbicos adaptados e orientação sobre uso correcto de inaladores.

## Insuficiência Respiratória (IR)

A Insuficiência Respiratória ocorre quando o sistema respiratório não consegue manter a troca gasosa adequada. Pode ser do tipo I (hipoxémica) com PaO2 inferior a 60 mmHg, ou tipo II (hipercápnica) com PaCO2 superior a 50 mmHg.

A abordagem fisioterapêutica inclui oxigenoterapia, ventilação não invasiva com CPAP ou BiPAP, manobras de higiene brônquica, posicionamento terapêutico para optimizar a relação ventilação-perfusão, aspiração de secreções quando necessário, e mobilização precoce conforme tolerância do paciente.
            """.trimIndent()
        ),

        // 3. Fisioterapia Traumato-Ortopédica
        Topic(
            id = 3,
            title = "Fisioterapia Traumato-Ortopédica",
            icon = "🦴",
            summary = "Fracturas, entorses, luxações, sub-luxações e factores de risco de doenças traumáticas.",
            markdownContent = """
# Fisioterapia Traumato-Ortopédica

## Fracturas

Fractura é a perda total ou parcial da continuidade de um osso. Pode resultar de trauma directo, indirecto, por fadiga ou patológica. Os sinais clínicos incluem dor intensa, edema, deformidade, crepitação e impotência funcional.

A classificação quanto à origem inclui fracturas traumáticas causadas por impacto mecânico, fracturas patológicas decorrentes de doenças que enfraquecem o osso como osteoporose ou tumores, e fracturas por stress ou fadiga resultantes de sobrecarga repetitiva.

A fisioterapia nas fracturas actua na fase de imobilização com exercícios isométricos e mobilização das articulações adjacentes, e na fase pós-imobilização com recuperação da amplitude de movimento, fortalecimento muscular progressivo e treino funcional.

## Entorse

A entorse é a lesão dos ligamentos de uma articulação causada por um movimento brusco que ultrapassa a amplitude normal. Classifica-se em grau I (estiramento sem ruptura), grau II (ruptura parcial) e grau III (ruptura total). O tratamento fisioterapêutico inclui crioterapia, compressão, elevação, exercícios proprioceptivos e fortalecimento.

## Luxação e Sub-Luxação

A luxação é o deslocamento completo das superfícies articulares, perdendo todo o contacto entre si. A sub-luxação é o deslocamento parcial, mantendo algum contacto articular. Ambas requerem redução e posterior reabilitação fisioterapêutica com recuperação da mobilidade, estabilidade articular e fortalecimento muscular periarticular.

## Factores de Risco de Doenças Traumáticas

Os principais factores incluem sedentarismo, obesidade, osteoporose, idade avançada, práticas desportivas sem preparação adequada, acidentes de trânsito, condições laborais inadequadas, uso de calçado impróprio, pisos irregulares e falta de equipamento de protecção individual.
            """.trimIndent()
        ),

        // 4. Fisioterapia Endócrina
        Topic(
            id = 4,
            title = "Fisioterapia Endócrina",
            icon = "💆",
            summary = "Drenagem linfática e massagem terapêutica na prática fisioterapêutica.",
            markdownContent = """
# Fisioterapia Endócrina

## Drenagem Linfática

A drenagem linfática manual (DLM) é uma técnica fisioterapêutica que consiste em manobras suaves, rítmicas e lentas que estimulam o sistema linfático a reabsorver o excesso de líquido intersticial. É indicada para linfedemas, edemas pós-operatórios, edemas pós-traumáticos, insuficiência venosa crónica e lipedema.

A técnica segue princípios fundamentais: pressão suave e constante, movimentos lentos e rítmicos, direcção centrípeta (das extremidades para o centro), e abertura prévia dos gânglios linfáticos proximais antes de drenar os distais. As contra-indicações incluem infecções agudas, trombose venosa profunda, insuficiência cardíaca descompensada, neoplasias activas e erisipela.

## Massagem Terapêutica

A massagem terapêutica é a aplicação sistemática de pressão e movimento sobre os tecidos moles do corpo com finalidade terapêutica. Os efeitos fisiológicos incluem aumento da circulação sanguínea e linfática, redução da tensão muscular, alívio da dor, libertação de endorfinas, melhoria da flexibilidade e promoção do relaxamento.

As principais técnicas incluem deslizamento superficial (effleurage), amassamento (pétrissage), fricção profunda, percussão (tapotement) e vibração. Cada técnica tem indicações específicas e é seleccionada conforme a avaliação e objectivos terapêuticos.

A massagem é indicada para contracturas musculares, dor crónica, fibromialgia, stress e ansiedade, reabilitação pós-lesão desportiva e melhoria da circulação em pacientes acamados.
            """.trimIndent()
        ),

        // 5. Fisioterapia Neurológica
        Topic(
            id = 5,
            title = "Fisioterapia Neurológica",
            icon = "🧠",
            summary = "Paralisia Infantil, Hidrocefalia, AVC e Sequelas de AVC.",
            markdownContent = """
# Fisioterapia Neurológica

## Paralisia Infantil (Poliomielite)

A poliomielite é uma doença viral que afecta os neurónios motores do corno anterior da medula espinal, causando paralisia flácida assimétrica, principalmente nos membros inferiores. A fisioterapia actua na prevenção de deformidades, fortalecimento da musculatura remanescente, estimulação neuromuscular, prescrição de órteses e treino de marcha com ou sem auxiliares.

## Hidrocefalia

A hidrocefalia é o acúmulo excessivo de líquido cefalorraquidiano nos ventrículos cerebrais, causando aumento da pressão intracraniana. Em crianças, manifesta-se com aumento do perímetro cefálico, fontanela tensa e atraso no desenvolvimento neuropsicomotor.

A fisioterapia na hidrocefalia foca na estimulação do desenvolvimento motor, posicionamento adequado, prevenção de deformidades, exercícios de controlo cefálico, exercícios de equilíbrio e coordenação, e orientação aos cuidadores.

## Acidente Vascular Cerebral (AVC)

O AVC é a interrupção do fluxo sanguíneo cerebral, podendo ser isquémico (por obstrução) ou hemorrágico (por ruptura vascular). As sequelas incluem hemiplegia ou hemiparesia, alterações de sensibilidade, afasia, disfagia, alterações cognitivas e espasticidade.

## Sequelas de AVC

As sequelas de AVC requerem reabilitação intensiva e prolongada. A fisioterapia inclui mobilização passiva e activa, exercícios de fortalecimento, treino de equilíbrio e marcha, reeducação funcional das actividades de vida diária, controlo da espasticidade com alongamentos e posicionamento, estimulação sensorial e terapia de restrição e indução do movimento (TRIM). O objectivo é maximizar a independência funcional e a qualidade de vida do paciente.
            """.trimIndent()
        ),

        // 6. Fisioterapia em Doentes Queimados
        Topic(
            id = 6,
            title = "Fisioterapia em Doentes Queimados",
            icon = "🔥",
            summary = "Prevenção de contraturas e tratamento de equimoses em pacientes queimados.",
            markdownContent = """
# Fisioterapia em Doentes Queimados

## Prevenção de Contraturas

As contraturas são uma das complicações mais frequentes e limitantes em pacientes queimados. Resultam do processo cicatricial que tende a encurtar os tecidos, principalmente em áreas articulares. A prevenção é fundamental e começa precocemente.

As estratégias fisioterapêuticas para prevenção de contraturas incluem posicionamento adequado e anti-deformidade com talas e órteses, mobilização articular passiva e activa precoce, alongamentos suaves e progressivos, uso de malhas compressivas para controlo da cicatrização hipertrófica, e hidroterapia para facilitar o movimento em ambiente aquático.

O posicionamento anti-contractura varia conforme a localização da queimadura: pescoço em extensão, ombro em abdução de 90 graus, cotovelo em extensão, punho em posição neutra ou ligeira extensão, mãos em posição funcional, quadril em extensão e abdução, e joelho em extensão.

## Equimoses

As equimoses são extravasamentos de sangue nos tecidos subcutâneos resultantes de trauma nos vasos sanguíneos. Nos pacientes queimados, podem ocorrer associadas ao trauma inicial ou como complicação dos procedimentos terapêuticos.

O tratamento fisioterapêutico das equimoses inclui crioterapia nas primeiras 48 horas para reduzir o edema e a hemorragia, seguida de termoterapia para promover a reabsorção do hematoma. A drenagem linfática manual, ultrassom terapêutico em modo pulsado e exercícios suaves para estimular a circulação também são utilizados. A abordagem deve ser cuidadosa, respeitando o estado da pele e dos tecidos adjacentes.
            """.trimIndent()
        ),

        // 7. Fisioterapia em Doentes Amputados
        Topic(
            id = 7,
            title = "Fisioterapia em Doentes Amputados",
            icon = "🦿",
            summary = "Níveis de amputação, protetização, próteses, órteses e controlo da dor.",
            markdownContent = """
# Fisioterapia em Doentes Amputados

## Nível de Amputação

O nível de amputação é determinado pela condição vascular, extensão da lesão e potencial funcional de reabilitação. Nos membros inferiores, os níveis incluem amputação de dedos, transmetatarsiana, transtibial (abaixo do joelho), desarticulação do joelho, transfemoral (acima do joelho), desarticulação do quadril e hemipelvectomia. Nos membros superiores incluem amputação de dedos, transmetacarpal, transradial (abaixo do cotovelo), desarticulação do cotovelo, transumeral (acima do cotovelo) e desarticulação do ombro.

## Fase de Protetização

A fase de protetização compreende a preparação do coto para receber a prótese. Inclui o controlo do edema com enfaixamento adequado, dessensibilização do coto, fortalecimento muscular do membro residual e contralateral, exercícios de equilíbrio e transferências, e moldagem cónica do coto. O enfaixamento em oito é fundamental para modelar o coto de forma cónica e facilitar a adaptação à prótese.

## Próteses e Órteses

As próteses substituem total ou parcialmente um membro amputado, devolvendo função e estética. As órteses são dispositivos externos que auxiliam, corrigem ou suportam uma estrutura corporal existente. A selecção depende do nível de amputação, condição física, objectivos funcionais e condições socioeconómicas do paciente.

## Recursos Fisioterapêuticos no Controlo da Dor

A dor no membro fantasma é uma experiência dolorosa referida ao membro ausente. Os recursos fisioterapêuticos incluem estimulação eléctrica nervosa transcutânea (TENS), terapia em espelho, dessensibilização do coto, massagem do coto, crioterapia, termoterapia, técnicas de relaxamento, biofeedback e exercícios activos. A abordagem deve ser multimodal e individualizada.
            """.trimIndent()
        ),

        // 8. Doenças Degenerativas
        Topic(
            id = 8,
            title = "Doenças Degenerativas",
            icon = "🦷",
            summary = "Osteoporose, Reumatologia e Escoliose: abordagem fisioterapêutica.",
            markdownContent = """
# Doenças Degenerativas

## Osteoporose

A osteoporose é uma doença metabólica óssea caracterizada pela diminuição da densidade mineral óssea e deterioração da microarquitectura do tecido ósseo, aumentando a fragilidade e o risco de fracturas. Afecta principalmente mulheres na pós-menopausa e idosos.

A fisioterapia na osteoporose inclui exercícios de impacto controlado como caminhada e subir escadas, exercícios de fortalecimento muscular com carga progressiva, exercícios de equilíbrio e propriocepção para prevenção de quedas, reeducação postural, orientação sobre actividades de vida diária seguras e exercícios aquáticos. Os exercícios de flexão da coluna devem ser evitados pelo risco de fracturas vertebrais por compressão.

## Reumatologia

As doenças reumatológicas englobam um conjunto de condições que afectam articulações, ossos, músculos, tendões e ligamentos. A artrite reumatóide, a osteoartrose e o lúpus são exemplos comuns.

A fisioterapia reumatológica visa reduzir a dor e a inflamação, manter e melhorar a amplitude de movimento, fortalecer a musculatura periarticular, proteger as articulações, manter a capacidade funcional e orientar sobre economia articular. Os recursos incluem cinesioterapia, hidroterapia, termoterapia, crioterapia e electroterapia.

## Escoliose

A escoliose é o desvio lateral da coluna vertebral associado a rotação dos corpos vertebrais. Pode ser estrutural (com alteração anatómica) ou funcional (postural, sem alteração óssea). Classifica-se pelo ângulo de Cobb em leve (até 20 graus), moderada (20 a 40 graus) e grave (acima de 40 graus).

A fisioterapia na escoliose inclui exercícios de alongamento e fortalecimento muscular assimétrico, reeducação postural global (RPG), método Schroth, exercícios de estabilização da coluna, uso de órteses (coletes) quando indicado e orientação postural para actividades diárias.
            """.trimIndent()
        ),

        // 9. Fisioterapia no Síndrome de Imobilismo
        Topic(
            id = 9,
            title = "Fisioterapia no Síndrome de Imobilismo",
            icon = "🛏️",
            summary = "Complicações da imobilização prolongada e intervenção fisioterapêutica precoce.",
            markdownContent = """
# Fisioterapia no Síndrome de Imobilismo

## Definição

O síndrome de imobilismo é o conjunto de alterações fisiológicas decorrentes da restrição prolongada ao leito ou da inactividade física. Afecta múltiplos sistemas orgânicos e pode ocorrer em pacientes hospitalizados, idosos acamados, pós-operatórios prolongados e pacientes em unidades de terapia intensiva.

## Complicações da Imobilização Prolongada

No sistema musculoesquelético ocorre atrofia muscular (perda de 1 a 3% de massa muscular por dia de repouso), rigidez articular, contraturas, osteoporose por desuso e diminuição da força muscular.

No sistema cardiovascular ocorrem hipotensão ortostática, aumento da frequência cardíaca em repouso, diminuição do volume de ejecção, estase venosa e risco aumentado de trombose venosa profunda e embolia pulmonar.

No sistema respiratório ocorre diminuição da capacidade vital, acúmulo de secreções, atelectasia, pneumonia hipostática e redução da eficiência da tosse.

No sistema tegumentar há risco elevado de úlceras de pressão, especialmente nas proeminências ósseas como sacro, calcâneos, trocânteres e escápulas.

## Intervenção Fisioterapêutica

A mobilização precoce é a principal estratégia de prevenção e tratamento. Inclui mudanças de decúbito a cada duas horas, exercícios passivos e activos no leito, sedestação progressiva, ortostatismo assistido, deambulação precoce, exercícios respiratórios, posicionamento adequado com uso de almofadas e coxins, e estimulação neuromuscular eléctrica quando indicada.
            """.trimIndent()
        ),

        // 10. Interpretação dos Exames Complementares
        Topic(
            id = 10,
            title = "Interpretação dos Exames Complementares",
            icon = "🔬",
            summary = "Exames laboratoriais e imagiológicos relevantes para a prática fisioterapêutica.",
            markdownContent = """
# Interpretação dos Exames Complementares

## Exames Laboratoriais

O fisioterapeuta deve saber interpretar exames laboratoriais que influenciam a conduta terapêutica. O hemograma completo avalia os glóbulos vermelhos (anemia pode limitar exercício), glóbulos brancos (leucocitose sugere infecção) e plaquetas (trombocitopenia aumenta risco de sangramento).

A gasometria arterial é fundamental na fisioterapia respiratória, avaliando pH (normal: 7,35-7,45), PaO2 (normal: 80-100 mmHg), PaCO2 (normal: 35-45 mmHg) e saturação de O2 (normal acima de 95%). Alterações indicam insuficiência respiratória e orientam a ventiloterapia.

Os marcadores inflamatórios como VHS e PCR indicam processos inflamatórios activos, importantes em pacientes reumatológicos. A creatinoquinase (CK) eleva-se em lesões musculares. A glicemia é relevante em pacientes diabéticos durante o exercício.

## Exames Imagiológicos

A radiografia convencional é o exame de primeira linha para avaliar fracturas, desvios ósseos, escoliose e alterações articulares degenerativas. O fisioterapeuta utiliza-a para planear a reabilitação pós-fractura e avaliar alinhamento articular.

A tomografia computadorizada fornece imagens detalhadas em cortes transversais, útil para avaliação de lesões complexas, hérnias discais e patologias intracranianas.

A ressonância magnética é o exame de eleição para avaliação de tecidos moles como músculos, ligamentos, tendões, meniscos e disco intervertebral. Não utiliza radiação ionizante.

A ecografia musculoesquelética permite avaliação dinâmica em tempo real de tendões, músculos e articulações, sendo útil para guiar procedimentos e avaliar lesões musculares e tendinosas.
            """.trimIndent()
        ),

        // 11. Critérios de Admissão nos Serviços de Fisioterapia
        Topic(
            id = 11,
            title = "Critérios de Admissão nos Serviços de Fisioterapia",
            icon = "📋",
            summary = "Critérios para admissão, avaliação inicial e alta nos serviços de Fisioterapia.",
            markdownContent = """
# Critérios de Admissão dos Pacientes nos Serviços de Fisioterapia

## Critérios de Admissão

A admissão nos serviços de fisioterapia requer encaminhamento médico ou avaliação directa pelo fisioterapeuta, conforme a legislação vigente. Os critérios incluem presença de défice funcional, limitação da mobilidade, dor que interfere nas actividades diárias, alteração respiratória com indicação de fisioterapia, pré ou pós-operatório com indicação de reabilitação, condição neurológica com comprometimento motor e risco de complicações da imobilização.

## Avaliação Inicial

A avaliação cinético-funcional é obrigatória na admissão e inclui anamnese detalhada com história clínica e queixas principais, exame físico com avaliação da postura, amplitude de movimento, força muscular (escala de 0 a 5), sensibilidade, reflexos, equilíbrio e marcha. Devem ser aplicadas escalas validadas como a Escala Visual Analógica (EVA) para dor, Escala de Ashworth para espasticidade, Índice de Barthel para funcionalidade e a Medida de Independência Funcional (MIF).

## Plano Terapêutico

Com base na avaliação, o fisioterapeuta elabora um plano terapêutico individualizado com objectivos a curto, médio e longo prazo, selecção de técnicas e recursos, frequência e duração das sessões e critérios de reavaliação.

## Critérios de Alta

A alta fisioterapêutica é dada quando os objectivos terapêuticos são alcançados, quando não há mais ganho funcional esperado, quando o paciente atinge a máxima independência funcional possível, ou quando há contra-indicação para continuidade do tratamento.
            """.trimIndent()
        ),

        // 12. Fisioterapia na U.T.I
        Topic(
            id = 12,
            title = "Fisioterapia na U.T.I",
            icon = "🏨",
            summary = "Ventilação mecânica, intubação orotraqueal, desintubação e gasometria.",
            markdownContent = """
# Fisioterapia na Unidade de Terapia Intensiva

## Ventilação Mecânica

A ventilação mecânica é o suporte ventilatório oferecido por um equipamento que substitui total ou parcialmente a função respiratória do paciente. Pode ser invasiva (através de tubo endotraqueal ou traqueostomia) ou não invasiva (por máscara facial ou nasal).

Os modos ventilatórios principais incluem ventilação controlada a volume (VCV), ventilação controlada a pressão (PCV), ventilação com suporte de pressão (PSV), ventilação mandatória intermitente sincronizada (SIMV) e pressão positiva contínua nas vias aéreas (CPAP). O fisioterapeuta participa no ajuste de parâmetros, no desmame ventilatório e na prevenção de complicações.

## Intubação Orotraqueal

A intubação orotraqueal consiste na inserção de um tubo endotraqueal pela boca até a traqueia para estabelecer uma via aérea artificial. O fisioterapeuta auxilia no posicionamento do paciente, na verificação da pressão do cuff e na fixação do tubo.

## Desintubação (Extubação)

A desintubação é a retirada do tubo endotraqueal quando o paciente reúne condições para respirar espontaneamente. Os critérios incluem resolução ou melhoria da causa da intubação, nível de consciência adequado, reflexo de tosse presente, oxigenação satisfatória, capacidade de manter ventilação espontânea e estabilidade hemodinâmica. O fisioterapeuta participa do teste de respiração espontânea e da assistência pós-extubação.

## Gasometria Arterial

A gasometria é o exame que analisa os gases e o equilíbrio ácido-base do sangue arterial. Valores normais: pH 7,35-7,45; PaO2 80-100 mmHg; PaCO2 35-45 mmHg; HCO3 22-26 mEq/L; SaO2 acima de 95%. A interpretação orienta a conduta do fisioterapeuta na ventiloterapia e no ajuste dos parâmetros ventilatórios.
            """.trimIndent()
        ),

        // 13. Ética e Deontologia da Carreira de Fisioterapia
        Topic(
            id = 13,
            title = "Ética e Deontologia da Fisioterapia",
            icon = "⚖️",
            summary = "Princípios éticos, deveres e responsabilidades do fisioterapeuta.",
            markdownContent = """
# Ética e Deontologia da Carreira de Fisioterapia

## Princípios Éticos Fundamentais

A prática da Fisioterapia é regida por princípios éticos que norteiam a conduta profissional. O princípio da beneficência obriga o fisioterapeuta a agir em benefício do paciente, buscando sempre o melhor resultado terapêutico. O princípio da não maleficência impõe a obrigação de não causar dano ao paciente.

O princípio da autonomia reconhece o direito do paciente de tomar decisões informadas sobre o seu tratamento. O fisioterapeuta deve informar o paciente sobre a sua condição, opções de tratamento, riscos e benefícios, e respeitar a sua decisão. O princípio da justiça exige tratamento equitativo e justo a todos os pacientes, sem discriminação.

## Deveres do Fisioterapeuta

O fisioterapeuta deve manter sigilo profissional sobre informações do paciente, actuar com competência técnica e científica, manter-se actualizado através de formação contínua, respeitar os limites de sua competência profissional, encaminhar o paciente a outros profissionais quando necessário, elaborar registo adequado de todos os procedimentos e respeitar os colegas e demais profissionais de saúde.

## Responsabilidades Profissionais

O fisioterapeuta é responsável pela avaliação, diagnóstico cinético-funcional, prescrição e execução do plano terapêutico. Deve documentar adequadamente todos os procedimentos, manter a confidencialidade das informações do paciente e responder civil, penal e eticamente pelos seus actos profissionais.

## Código Deontológico

O código deontológico regula as relações do fisioterapeuta com os pacientes, colegas, instituições e sociedade. Estabelece normas de conduta, define infracções éticas e prevê sanções disciplinares para o exercício irregular da profissão.
            """.trimIndent()
        ),

        // 14. Fisioterapia Musculoesquelética
        Topic(
            id = 14,
            title = "Fisioterapia Musculoesquelética",
            icon = "💪",
            summary = "Posicionamento, alongamento muscular e mobilização articular.",
            markdownContent = """
# Fisioterapia Musculoesquelética

## Princípios Básicos do Posicionamento

O posicionamento adequado do paciente é fundamental para prevenir complicações da imobilidade, promover conforto, facilitar a função respiratória e prevenir deformidades. Os princípios incluem alinhamento corporal adequado, distribuição uniforme de pressão, protecção de proeminências ósseas, manutenção de posturas funcionais e mudanças de decúbito regulares.

As posições básicas incluem decúbito dorsal (supino), decúbito ventral (prono), decúbito lateral direito e esquerdo, posição de Fowler (semi-sentado) e posição sentada. Cada posição tem indicações, contra-indicações e cuidados específicos que o fisioterapeuta deve conhecer.

## Alongamento Muscular

O alongamento muscular é a técnica que visa aumentar o comprimento dos tecidos moles encurtados, recuperando ou mantendo a flexibilidade. Pode ser estático (manter a posição por 15 a 30 segundos), dinâmico (movimentos controlados de amplitude progressiva) ou através de facilitação neuromuscular proprioceptiva (FNP) que combina contracção isométrica com alongamento.

Os benefícios incluem aumento da amplitude de movimento, prevenção de lesões musculares, melhoria da postura, redução da tensão muscular e aumento da flexibilidade. Deve ser realizado após aquecimento prévio e respeitando o limiar de dor do paciente.

## Mobilização Articular

A mobilização articular consiste em movimentos passivos, acessórios ou fisiológicos, aplicados pelo fisioterapeuta sobre as superfícies articulares para restaurar ou manter a mobilidade. Classifica-se em graus de I a IV segundo Maitland, conforme a amplitude e resistência aplicada.

A mobilização é indicada para hipomobilidade articular, dor articular, rigidez pós-imobilização e aderências articulares. As contra-indicações incluem fracturas não consolidadas, artrite séptica, instabilidade articular significativa e tumores ósseos.
            """.trimIndent()
        ),

        // 15. Fisioterapia Materno-Infantil
        Topic(
            id = 15,
            title = "Fisioterapia Materno-Infantil",
            icon = "👶",
            summary = "Desenvolvimento motor, actividade reflexa, avaliação em neonatologia e pediatria.",
            markdownContent = """
# Fisioterapia Materno-Infantil

## Movimento Espontâneo e Coordenações Sensório-Motoras

O desenvolvimento motor do recém-nascido e lactente inicia-se com movimentos espontâneos que progressivamente se tornam mais organizados e intencionais. As coordenações sensório-motoras resultam da integração entre os sistemas sensorial e motor, permitindo ao bebé explorar o ambiente e desenvolver habilidades funcionais progressivamente mais complexas.

A estimulação adequada nos primeiros meses de vida é crucial para o desenvolvimento das conexões neuronais e a formação de padrões motores normais.

## Evolução Normal da Motricidade e Suas Variações

O desenvolvimento motor segue uma sequência previsível: controlo cefálico (2-4 meses), rolar (4-6 meses), sentar sem apoio (6-9 meses), arrastar e gatinhar (8-10 meses), ficar em pé com apoio (9-12 meses) e marcha independente (12-18 meses). Variações individuais são normais dentro de faixas etárias específicas.

O fisioterapeuta deve conhecer os marcos do desenvolvimento motor para identificar atrasos e intervir precocemente.

## Actividade Reflexa e Reacções

Os reflexos primitivos são respostas motoras automáticas presentes ao nascimento que devem desaparecer progressivamente. Incluem o reflexo de Moro (sobressalto), preensão palmar e plantar, reflexo tónico cervical assimétrico, reflexo de sucção e marcha automática. A persistência além do período esperado sugere disfunção neurológica.

As reacções posturais incluem as reacções de endireitamento, protecção e equilíbrio, que se desenvolvem progressivamente e permitem o controlo postural contra a gravidade.

## Avaliação em Neonatologia e Pediatria

A avaliação fisioterapêutica do neonato e da criança inclui avaliação da idade gestacional, tónus muscular, postura, reflexos primitivos, movimentos espontâneos, resposta aos estímulos sensoriais e marcos do desenvolvimento. Instrumentos como a Escala de Alberta, o Teste de Denver e a Escala de Bayley são utilizados para avaliação padronizada do desenvolvimento motor.
            """.trimIndent()
        ),

        // 16. Fisioterapia Neuromuscular
        Topic(
            id = 16,
            title = "Fisioterapia Neuromuscular",
            icon = "⚡",
            summary = "Sistema Nervoso Central e Periférico, neurónios, unidade motora e sua função.",
            markdownContent = """
# Fisioterapia Neuromuscular

## Conceito

A Fisioterapia Neuromuscular é a área especializada que avalia e trata distúrbios do sistema nervoso e muscular que afectam o movimento e a função. Actua em condições como neuropatias periféricas, miopatias, doenças do neurónio motor, esclerose múltipla, síndrome de Guillain-Barré e distrofias musculares.

## Introdução e Fundamentos do Sistema Nervoso

O sistema nervoso é responsável pela integração, coordenação e controlo de todas as funções do organismo. Recebe informações sensoriais do ambiente interno e externo, processa-as e gera respostas motoras adequadas. É a base anatómica e fisiológica de toda a reabilitação neuromuscular.

## Sistema Nervoso Central (SNC)

O SNC é composto pelo encéfalo (cérebro, cerebelo e tronco encefálico) e pela medula espinal. O cérebro é responsável pelas funções superiores como pensamento, memória e controlo motor voluntário. O cerebelo coordena os movimentos e o equilíbrio. O tronco encefálico controla funções vitais como respiração e frequência cardíaca. A medula espinal conduz informações entre o encéfalo e o corpo e integra reflexos espinais.

## Sistema Nervoso Periférico (SNP)

O SNP é constituído pelos nervos cranianos (12 pares) e nervos espinais (31 pares), que conectam o SNC aos órgãos, músculos e receptores sensoriais. Divide-se em sistema nervoso somático (voluntário) e sistema nervoso autónomo (involuntário, com divisões simpática e parassimpática).

## Neurónio, Tipos e Unidade Motora

O neurónio é a célula funcional do sistema nervoso, composto por corpo celular, dendrites e axónio. Os neurónios sensoriais (aferentes) transmitem informações dos receptores ao SNC. Os neurónios motores (eferentes) transmitem comandos do SNC aos músculos. Os interneurónios fazem a conexão entre neurónios dentro do SNC.

A unidade motora é o conjunto formado por um neurónio motor alfa e todas as fibras musculares que ele inerva. É a unidade funcional do controlo motor. O recrutamento de unidades motoras segue o princípio do tamanho: unidades menores são recrutadas primeiro para movimentos finos, e unidades maiores são adicionadas para movimentos que exigem maior força.
            """.trimIndent()
        ),

        // 17. Fisioterapia em Ortoprotesia
        Topic(
            id = 17,
            title = "Fisioterapia em Ortoprotesia",
            icon = "🦾",
            summary = "Resumo histórico, definição e aplicação de órteses e próteses.",
            markdownContent = """
# Fisioterapia em Ortoprotesia

## Resumo Histórico, Definição, Objectivos, Indicação e Importância

A ortoprotesia tem raízes históricas que remontam às civilizações antigas. Os egípcios já utilizavam dispositivos auxiliares rudimentares. Com o avanço da medicina e tecnologia, as órteses e próteses evoluíram significativamente em materiais, design e funcionalidade.

As órteses são dispositivos externos aplicados ao corpo para suportar, alinhar, prevenir ou corrigir deformidades, proteger estruturas lesionadas e melhorar a função. Os objectivos incluem imobilização, estabilização articular, descarga de peso, correcção de deformidades e assistência ao movimento.

As indicações incluem fracturas em tratamento conservador, pós-operatório ortopédico, deformidades congénitas ou adquiridas, lesões nervosas periféricas, doenças neuromusculares e insuficiência articular.

## Órtese para Coluna Vertebral

Os coletes cervico-toraco-lombares são órteses que estabilizam e limitam o movimento de segmentos da coluna vertebral. Os coletes cervicais (colar de Philadelphia, colar cervical macio) limitam a mobilidade cervical. Os coletes toraco-lombares (colete de Jewett, colete de Boston, TLSO) estabilizam a coluna torácica e lombar, sendo indicados em fracturas vertebrais estáveis, pós-operatório de cirurgia da coluna e escoliose.

## Aplicação de Prótese

A prótese precoce é aplicada nas primeiras semanas após a amputação, mesmo antes da cicatrização completa do coto, visando suporte psicológico e treino de marcha precoce. A prótese pós-operatória é aplicada imediatamente após a cirurgia, com gesso ou dispositivo rígido removível. A prótese temporária é utilizada na fase de protetização intermediária, permitindo adaptação progressiva antes da prótese definitiva.

A selecção da prótese depende do nível de amputação, condição do coto, idade, nível de actividade, motivação do paciente e disponibilidade de recursos.
            """.trimIndent()
        ),

        // 18. Recurso em Fisioterapia
        Topic(
            id = 18,
            title = "Recursos em Fisioterapia",
            icon = "🔌",
            summary = "Diatermia por ondas curtas, radiofrequência, calor nos tecidos e electrodos.",
            markdownContent = """
# Recursos em Fisioterapia

## Diatermia por Ondas Curtas

A diatermia por ondas curtas é um recurso electroterapêutico que utiliza correntes de alta frequência (27,12 MHz) para produzir aquecimento profundo nos tecidos. O calor é gerado pela conversão de energia electromagnética em energia térmica nos tecidos biológicos.

Os efeitos terapêuticos incluem aumento do fluxo sanguíneo local, aumento da extensibilidade do colagénio, alívio da dor, redução do espasmo muscular, aceleração dos processos de reparação tecidual e aumento do metabolismo celular. É indicada para contraturas musculares, rigidez articular, tendinites crónicas, bursites, artrose e dor crónica.

As contra-indicações incluem implantes metálicos na área de tratamento, marca-passo cardíaco, gestação, neoplasias, tromboflebite aguda, hemorragias, áreas com sensibilidade alterada e febre.

## Absorção de Energia de Radiofrequência

A absorção de energia de radiofrequência pelos tecidos depende das propriedades eléctricas dos mesmos. Tecidos com alto teor de água e electrólitos como músculo e sangue absorvem mais energia e aquecem mais rapidamente. Tecidos com baixo teor de água como gordura e osso absorvem menos energia.

## Produção de Calor nos Tecidos

O aquecimento dos tecidos pela diatermia ocorre por dois mecanismos: campo condensador (método capacitivo) que aquece predominantemente tecidos superficiais ricos em água, e campo de indução (método indutivo) que aquece tecidos mais profundos como músculos. A elevação da temperatura terapêutica situa-se entre 40°C e 45°C.

## Tipos de Electrodos

Os electrodos utilizados na diatermia incluem electrodos de placa (capacitivos), que são discos metálicos colocados em ambos os lados da área de tratamento, e electrodos de bobina (indutivos) como o monode e o cabo, que geram campo magnético. A selecção e posicionamento dos electrodos determinam a profundidade e distribuição do aquecimento nos tecidos.
            """.trimIndent()
        )
    )
}
