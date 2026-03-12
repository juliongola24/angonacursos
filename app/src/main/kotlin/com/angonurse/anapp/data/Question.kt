package com.angonurse.anapp.data

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: String
)

/**
 * Repositório centralizado para as perguntas do exame de Fisioterapia / Reabilitação em Saúde.
 * 95 questões únicas sem repetições distribuídas em 17 temas.
 */
object QuestionBank {

    const val EXAM_DURATION_MINUTES = 60

    fun getQuestions(): List<Question> {
        return questions
    }

    val questions: List<Question> by lazy {
        listOf(
            // ── 1. CONCEITOS BÁSICOS DE FISIOTERAPIA (1-6) ──
            Question(1, "A Fisioterapia é a ciência da saúde que estuda, previne e trata:",
                listOf("a) Apenas doenças infecciosas", "b) Distúrbios cinético-funcionais do corpo humano", "c) Exclusivamente fracturas ósseas", "d) Somente doenças cardíacas", "e) Apenas doenças respiratórias", "f) Distúrbios psiquiátricos"), "b"),
            Question(2, "O diagnóstico cinético-funcional é competência de qual profissional?",
                listOf("a) Médico", "b) Enfermeiro", "c) Nutricionista", "d) Fisioterapeuta", "e) Psicólogo", "f) Farmacêutico"), "d"),
            Question(3, "A alta fisioterapêutica é dada quando:",
                listOf("a) O paciente pede para sair", "b) Acabam as sessões autorizadas pelo plano", "c) Os objectivos terapêuticos são alcançados ou não há mais ganho funcional", "d) O médico solicita", "e) O paciente completa 10 sessões", "f) O horário do fisioterapeuta termina"), "c"),
            Question(4, "A avaliação fisioterapêutica deve incluir EXCEPTO:",
                listOf("a) Anamnese detalhada", "b) Teste de amplitude de movimento", "c) Avaliação de força muscular", "d) Prescrição de medicamentos", "e) Avaliação da marcha", "f) Teste de sensibilidade"), "d"),
            Question(5, "A escala de força muscular graduada de 0 a 5 classifica o grau 3 como:",
                listOf("a) Ausência de contracção", "b) Contracção visível sem movimento", "c) Movimento com eliminação da gravidade", "d) Movimento contra a gravidade", "e) Movimento contra resistência moderada", "f) Força normal"), "d"),
            Question(6, "A cinesioterapia é definida como:",
                listOf("a) Tratamento por medicamentos", "b) Terapia através do movimento", "c) Tratamento por ondas electromagnéticas", "d) Terapia por calor profundo", "e) Tratamento por corrente eléctrica", "f) Terapia por ultrassom"), "b"),

            // ── 2. FISIOTERAPIA RESPIRATÓRIA E CARDÍACA (7-14) ──
            Question(7, "A Insuficiência Cardíaca é definida como:",
                listOf("a) Aumento da frequência cardíaca em repouso", "b) Incapacidade do coração de bombear sangue suficiente para as necessidades metabólicas", "c) Obstrução das artérias coronárias", "d) Arritmia cardíaca permanente", "e) Inflamação do pericárdio", "f) Hipertrofia ventricular isolada"), "b"),
            Question(8, "A reabilitação cardíaca fase I corresponde à:",
                listOf("a) Fase de manutenção domiciliar", "b) Fase ambulatorial tardia", "c) Fase hospitalar", "d) Fase ambulatorial precoce", "e) Fase desportiva", "f) Fase pré-operatória"), "c"),
            Question(9, "A DPOC é caracterizada por:",
                listOf("a) Obstrução reversível do fluxo aéreo", "b) Limitação persistente e progressiva do fluxo aéreo", "c) Infecção aguda das vias aéreas", "d) Alergia respiratória sazonal", "e) Pneumotórax espontâneo", "f) Embolia pulmonar"), "b"),
            Question(10, "A drenagem postural na fisioterapia respiratória utiliza:",
                listOf("a) Medicamentos broncodilatadores", "b) Posições específicas que favorecem a drenagem de secreções por gravidade", "c) Apenas aspiração traqueal", "d) Ventilação mecânica invasiva", "e) Oxigenoterapia hiperbárica", "f) Cirurgia torácica"), "b"),
            Question(11, "A Insuficiência Respiratória tipo II (hipercápnica) apresenta:",
                listOf("a) PaO2 acima de 100 mmHg", "b) PaCO2 inferior a 35 mmHg", "c) PaCO2 superior a 50 mmHg", "d) pH acima de 7,50", "e) SaO2 acima de 99%", "f) PaO2 acima de 80 mmHg"), "c"),
            Question(12, "A ventilação não invasiva (VNI) é aplicada através de:",
                listOf("a) Tubo endotraqueal", "b) Traqueostomia", "c) Máscara facial ou nasal sem via aérea artificial", "d) Cateter nasal simples", "e) Cânula orofaríngea", "f) Intubação nasotraqueal"), "c"),
            Question(13, "O treino de resistência muscular inspiratória é indicado em pacientes com:",
                listOf("a) Pneumotórax agudo", "b) Hemoptise activa", "c) Fraqueza da musculatura respiratória e DPOC", "d) Embolia pulmonar aguda", "e) Derrame pleural volumoso", "f) Tumores mediastinais"), "c"),
            Question(14, "A reeducação diafragmática visa:",
                listOf("a) Aumentar a frequência respiratória", "b) Diminuir o volume corrente", "c) Melhorar o padrão ventilatório com maior excursão do diafragma", "d) Eliminar a necessidade de oxigénio", "e) Substituir a ventilação mecânica", "f) Reduzir a capacidade pulmonar"), "c"),

            // ── 3. FISIOTERAPIA TRAUMATO-ORTOPÉDICA (15-22) ──
            Question(15, "Uma fractura patológica é causada por:",
                listOf("a) Trauma directo de alta energia", "b) Queda de grande altura", "c) Doença que enfraquece o osso como osteoporose ou tumor", "d) Acidente de trânsito", "e) Prática desportiva intensa", "f) Trauma indirecto por torção"), "c"),
            Question(16, "A fractura por stress ou fadiga resulta de:",
                listOf("a) Impacto violento único", "b) Doença metabólica do osso", "c) Sobrecarga mecânica repetitiva", "d) Infecção óssea", "e) Tumor ósseo maligno", "f) Deficiência de vitamina D isolada"), "c"),
            Question(17, "A entorse de grau II caracteriza-se por:",
                listOf("a) Estiramento ligamentar sem ruptura", "b) Ruptura parcial do ligamento", "c) Ruptura total do ligamento", "d) Fractura associada", "e) Luxação completa", "f) Ausência de edema"), "b"),
            Question(18, "A luxação articular é definida como:",
                listOf("a) Estiramento dos ligamentos", "b) Fractura intra-articular", "c) Deslocamento completo das superfícies articulares", "d) Inflamação da membrana sinovial", "e) Ruptura do menisco", "f) Contusão muscular"), "c"),
            Question(19, "A diferença entre luxação e sub-luxação é que na sub-luxação:",
                listOf("a) Não há dor", "b) Há ruptura completa dos ligamentos", "c) Mantém-se algum contacto entre as superfícies articulares", "d) Ocorre fractura associada obrigatoriamente", "e) O tratamento é sempre cirúrgico", "f) Não há edema"), "c"),
            Question(20, "Um factor de risco para doenças traumáticas é:",
                listOf("a) Prática regular de exercício com orientação", "b) Uso adequado de equipamento de protecção", "c) Sedentarismo e obesidade", "d) Alimentação equilibrada", "e) Sono adequado", "f) Bom condicionamento físico"), "c"),
            Question(21, "Na fase pós-imobilização de uma fractura, a fisioterapia prioriza:",
                listOf("a) Imobilização prolongada adicional", "b) Repouso absoluto sem exercícios", "c) Recuperação da amplitude de movimento e fortalecimento muscular", "d) Apenas crioterapia", "e) Exercícios de alto impacto imediato", "f) Uso exclusivo de medicação analgésica"), "c"),
            Question(22, "Os exercícios proprioceptivos após entorse visam:",
                listOf("a) Aumentar o edema articular", "b) Diminuir a força muscular", "c) Melhorar a consciência postural e estabilidade articular", "d) Provocar nova entorse controlada", "e) Reduzir a mobilidade articular", "f) Causar dor terapêutica"), "c"),

            // ── 4. FISIOTERAPIA ENDÓCRINA (23-27) ──
            Question(23, "A drenagem linfática manual consiste em:",
                listOf("a) Massagem profunda e vigorosa", "b) Manobras suaves e rítmicas que estimulam o sistema linfático", "c) Aplicação de corrente eléctrica nos vasos linfáticos", "d) Uso de medicamentos diuréticos", "e) Compressão pneumática exclusiva", "f) Aspiração mecânica do líquido"), "b"),
            Question(24, "A drenagem linfática é contra-indicada em:",
                listOf("a) Edema pós-operatório", "b) Linfedema crónico", "c) Trombose venosa profunda aguda", "d) Edema gestacional leve", "e) Lipedema", "f) Edema pós-traumático"), "c"),
            Question(25, "A direcção das manobras na drenagem linfática deve ser:",
                listOf("a) Centrífuga (do centro para as extremidades)", "b) Aleatória sem direcção definida", "c) Centrípeta (das extremidades para o centro)", "d) Circular sobre o edema", "e) Transversal ao membro", "f) Apenas proximal"), "c"),
            Question(26, "A técnica de massagem que utiliza movimentos de amassamento chama-se:",
                listOf("a) Effleurage", "b) Pétrissage", "c) Tapotement", "d) Fricção", "e) Vibração", "f) Deslizamento"), "b"),
            Question(27, "A massagem terapêutica está indicada para EXCEPTO:",
                listOf("a) Contracturas musculares", "b) Dor crónica", "c) Tromboflebite aguda", "d) Fibromialgia", "e) Stress e ansiedade", "f) Reabilitação desportiva"), "c"),

            // ── 5. FISIOTERAPIA NEUROLÓGICA (28-34) ──
            Question(28, "A paralisia infantil (poliomielite) afecta predominantemente:",
                listOf("a) Os neurónios sensitivos do cérebro", "b) Os neurónios motores do corno anterior da medula espinal", "c) Os neurónios do cerebelo exclusivamente", "d) Os nervos cranianos apenas", "e) O sistema nervoso autónomo", "f) A musculatura cardíaca"), "b"),
            Question(29, "A hidrocefalia é o acúmulo excessivo de:",
                listOf("a) Sangue no cérebro", "b) Pus no espaço subdural", "c) Líquido cefalorraquidiano nos ventrículos cerebrais", "d) Ar no espaço intracraniano", "e) Gordura nas meninges", "f) Cálcio nas artérias cerebrais"), "c"),
            Question(30, "O AVC isquémico é causado por:",
                listOf("a) Ruptura de um vaso cerebral", "b) Obstrução do fluxo sanguíneo cerebral", "c) Infecção das meninges", "d) Tumor cerebral", "e) Traumatismo craniano", "f) Hemorragia subaracnóidea"), "b"),
            Question(31, "A espasticidade após AVC é melhor controlada com:",
                listOf("a) Exercícios balísticos de alta velocidade", "b) Imobilização prolongada", "c) Alongamentos sustentados e posicionamento adequado", "d) Exercícios isométricos máximos", "e) Corrida em esteira", "f) Massagem vigorosa profunda"), "c"),
            Question(32, "A terapia de restrição e indução do movimento (TRIM) consiste em:",
                listOf("a) Imobilizar o membro afectado", "b) Restringir o uso do membro são para forçar o uso do membro afectado", "c) Restringir todo o movimento do paciente", "d) Utilizar apenas medicação", "e) Aplicar gesso nos dois membros", "f) Repouso absoluto por 6 semanas"), "b"),
            Question(33, "Na fisioterapia da hidrocefalia infantil, a prioridade é:",
                listOf("a) Treino de marcha imediato", "b) Estimulação do desenvolvimento motor e prevenção de deformidades", "c) Exercícios de musculação com carga", "d) Corrida adaptada", "e) Natação competitiva", "f) Drenagem linfática cerebral"), "b"),
            Question(34, "A hemiplegia é definida como:",
                listOf("a) Paralisia dos quatro membros", "b) Paralisia de ambos os membros inferiores", "c) Paralisia de um lado do corpo (dimídio)", "d) Paralisia de um único membro", "e) Fraqueza muscular generalizada", "f) Perda de sensibilidade bilateral"), "c"),

            // ── 6. FISIOTERAPIA EM DOENTES QUEIMADOS (35-39) ──
            Question(35, "A principal complicação limitante em pacientes queimados é:",
                listOf("a) Infecção urinária", "b) Contractura cicatricial", "c) Alergia ao curativo", "d) Desidratação crónica", "e) Queda de cabelo", "f) Insónia"), "b"),
            Question(36, "O posicionamento anti-contractura do ombro em paciente queimado é:",
                listOf("a) Adução e rotação interna", "b) Flexão máxima", "c) Abdução de 90 graus", "d) Extensão completa posterior", "e) Posição neutra junto ao corpo", "f) Rotação interna máxima"), "c"),
            Question(37, "As malhas compressivas em queimados servem para:",
                listOf("a) Aquecer o paciente", "b) Esconder as cicatrizes", "c) Controlar a cicatrização hipertrófica e prevenir quelóides", "d) Aumentar a mobilidade", "e) Substituir o curativo", "f) Melhorar a estética apenas"), "c"),
            Question(38, "As equimoses em pacientes queimados são tratadas inicialmente com:",
                listOf("a) Calor profundo imediato", "b) Massagem vigorosa", "c) Crioterapia nas primeiras 48 horas", "d) Exercício de impacto", "e) Imobilização gessada", "f) Nenhum tratamento é necessário"), "c"),
            Question(39, "A hidroterapia em queimados é indicada para:",
                listOf("a) Aumentar a dor do paciente", "b) Facilitar o movimento em ambiente aquático e debridamento", "c) Substituir a cirurgia plástica", "d) Apenas limpeza da pele", "e) Aumentar a contractura", "f) Reduzir a circulação local"), "b"),

            // ── 7. FISIOTERAPIA EM DOENTES AMPUTADOS (40-47) ──
            Question(40, "A amputação transtibial refere-se à amputação:",
                listOf("a) Acima do joelho", "b) Abaixo do joelho", "c) Ao nível do quadril", "d) Ao nível do tornozelo", "e) Dos dedos do pé", "f) Desarticulação do joelho"), "b"),
            Question(41, "O enfaixamento do coto em formato de oito tem como objectivo:",
                listOf("a) Aumentar o edema do coto", "b) Impedir qualquer circulação", "c) Modelar o coto em forma cónica para adaptação à prótese", "d) Causar compressão excessiva", "e) Substituir a prótese", "f) Proteger contra infecção"), "c"),
            Question(42, "A dor no membro fantasma refere-se a:",
                listOf("a) Dor no membro contralateral", "b) Dor imaginária sem base neurológica", "c) Experiência dolorosa referida ao membro ausente/amputado", "d) Dor no coto apenas", "e) Dor causada pela prótese", "f) Dor psicológica sem tratamento"), "c"),
            Question(43, "O TENS (estimulação eléctrica nervosa transcutânea) é utilizado no amputado para:",
                listOf("a) Regenerar o membro amputado", "b) Controlo da dor no coto e membro fantasma", "c) Aumentar a sensibilidade do coto", "d) Substituir a prótese", "e) Fortalecer o membro ausente", "f) Avaliar a condição vascular"), "b"),
            Question(44, "A terapia em espelho para amputados consiste em:",
                listOf("a) Olhar para o coto directamente", "b) Utilizar o reflexo do membro intacto para criar ilusão visual do membro amputado", "c) Aplicar gelo no coto", "d) Exercícios com os olhos fechados", "e) Massagem no membro intacto apenas", "f) Treino de marcha sem prótese"), "b"),
            Question(45, "A diferença entre prótese e órtese é que a prótese:",
                listOf("a) Corrige uma deformidade existente", "b) Suporta uma estrutura corporal existente", "c) Substitui total ou parcialmente um membro ausente", "d) Apenas alivia a dor", "e) É utilizada somente em crianças", "f) É um dispositivo temporário sempre"), "c"),
            Question(46, "A amputação transfemoral refere-se à amputação:",
                listOf("a) Abaixo do joelho", "b) Acima do joelho", "c) Ao nível do tornozelo", "d) Dos dedos da mão", "e) Ao nível do punho", "f) Desarticulação do ombro"), "b"),
            Question(47, "A dessensibilização do coto é realizada através de:",
                listOf("a) Imobilização completa do coto", "b) Aplicação de gelo contínuo", "c) Estímulos táteis progressivos como texturas diferentes e percussão", "d) Medicação analgésica exclusivamente", "e) Repouso absoluto", "f) Compressão máxima permanente"), "c"),

            // ── 8. DOENÇAS DEGENERATIVAS (48-54) ──
            Question(48, "A osteoporose é caracterizada por:",
                listOf("a) Aumento da densidade óssea", "b) Inflamação das articulações", "c) Diminuição da densidade mineral óssea e fragilidade", "d) Infecção do tecido ósseo", "e) Tumor ósseo benigno", "f) Excesso de cálcio nos ossos"), "c"),
            Question(49, "Na osteoporose, os exercícios de flexão da coluna devem ser evitados porque:",
                listOf("a) Causam dor muscular leve", "b) Aumentam o risco de fractura vertebral por compressão", "c) Reduzem a mobilidade do quadril", "d) São demasiado fáceis", "e) Não têm nenhum efeito", "f) Aumentam a pressão arterial"), "b"),
            Question(50, "A artrite reumatóide é uma doença:",
                listOf("a) Infecciosa aguda", "b) Traumática", "c) Auto-imune inflamatória crónica que afecta as articulações", "d) Degenerativa exclusiva do osso", "e) Congénita do tecido muscular", "f) Metabólica do fígado"), "c"),
            Question(51, "O ângulo de Cobb é utilizado para medir:",
                listOf("a) A amplitude de movimento do ombro", "b) A força muscular do quadricípite", "c) O grau de curvatura da escoliose", "d) A frequência cardíaca máxima", "e) A capacidade pulmonar", "f) O edema do membro inferior"), "c"),
            Question(52, "A escoliose estrutural diferencia-se da funcional porque na estrutural:",
                listOf("a) O desvio corrige com inclinação lateral", "b) Existe alteração anatómica com rotação vertebral", "c) Não há nenhuma curvatura visível", "d) Afecta apenas crianças menores de 2 anos", "e) A dor é sempre ausente", "f) Corrige espontaneamente sem tratamento"), "b"),
            Question(53, "A economia articular em reumatologia consiste em:",
                listOf("a) Gastar menos com medicamentos", "b) Evitar qualquer tipo de movimento", "c) Proteger as articulações usando técnicas que reduzem o stress articular", "d) Usar apenas próteses articulares", "e) Realizar exercícios de alto impacto", "f) Imobilizar todas as articulações"), "c"),
            Question(54, "O método Schroth é utilizado no tratamento da:",
                listOf("a) Insuficiência cardíaca", "b) DPOC", "c) Escoliose", "d) Osteoporose", "e) Artrite reumatóide", "f) Fibromialgia"), "c"),

            // ── 9. SÍNDROME DE IMOBILISMO (55-59) ──
            Question(55, "A atrofia muscular por imobilização pode atingir uma perda de massa de:",
                listOf("a) 0,1% por mês", "b) 1 a 3% por dia de repouso", "c) 10% por ano", "d) 0,5% por semana", "e) Apenas após 6 meses", "f) Não ocorre atrofia por imobilização"), "b"),
            Question(56, "A principal estratégia para prevenir o síndrome de imobilismo é:",
                listOf("a) Repouso absoluto prolongado", "b) Sedação contínua", "c) Mobilização precoce e mudanças de decúbito", "d) Imobilização gessada de todo o corpo", "e) Alimentação hipercalórica isolada", "f) Medicação antidepressiva"), "c"),
            Question(57, "As úlceras de pressão ocorrem predominantemente em:",
                listOf("a) Regiões com grande massa muscular", "b) Proeminências ósseas como sacro, calcâneos e trocânteres", "c) Palmas das mãos", "d) Plantas dos pés em pacientes que deambulam", "e) Couro cabeludo", "f) Região abdominal"), "b"),
            Question(58, "A hipotensão ortostática no síndrome de imobilismo ocorre por:",
                listOf("a) Excesso de exercício físico", "b) Hipertensão arterial prévia", "c) Perda da adaptação cardiovascular à posição vertical", "d) Ingestão excessiva de líquidos", "e) Uso de meias compressivas", "f) Elevação constante dos membros inferiores"), "c"),
            Question(59, "A mudança de decúbito deve ser realizada a cada:",
                listOf("a) 8 horas", "b) 12 horas", "c) 24 horas", "d) 2 horas", "e) 1 vez por semana", "f) Quando o paciente solicitar apenas"), "d"),

            // ── 10. INTERPRETAÇÃO DE EXAMES COMPLEMENTARES (60-64) ──
            Question(60, "Na gasometria arterial, o valor normal de pH sanguíneo é:",
                listOf("a) 6,80 a 7,00", "b) 7,00 a 7,20", "c) 7,35 a 7,45", "d) 7,50 a 7,60", "e) 8,00 a 8,20", "f) 6,50 a 6,80"), "c"),
            Question(61, "A PaO2 normal no sangue arterial situa-se entre:",
                listOf("a) 40 a 60 mmHg", "b) 60 a 70 mmHg", "c) 80 a 100 mmHg", "d) 100 a 120 mmHg", "e) 20 a 40 mmHg", "f) 120 a 150 mmHg"), "c"),
            Question(62, "A ressonância magnética é o exame de eleição para avaliação de:",
                listOf("a) Fracturas simples", "b) Cálculos renais", "c) Tecidos moles como músculos, ligamentos e discos intervertebrais", "d) Pedras na vesícula", "e) Densidade óssea", "f) Gases sanguíneos"), "c"),
            Question(63, "A leucocitose no hemograma sugere:",
                listOf("a) Anemia grave", "b) Desidratação", "c) Processo infeccioso ou inflamatório", "d) Insuficiência hepática", "e) Hipoglicemia", "f) Osteoporose"), "c"),
            Question(64, "A creatinoquinase (CK) elevada indica:",
                listOf("a) Infecção urinária", "b) Doença hepática", "c) Lesão muscular", "d) Anemia", "e) Desnutrição", "f) Hipertensão arterial"), "c"),

            // ── 11. CRITÉRIOS DE ADMISSÃO EM FISIOTERAPIA (65-68) ──
            Question(65, "A Escala Visual Analógica (EVA) é utilizada para avaliar:",
                listOf("a) Força muscular", "b) Amplitude de movimento", "c) Intensidade da dor", "d) Equilíbrio postural", "e) Capacidade respiratória", "f) Nível de consciência"), "c"),
            Question(66, "O Índice de Barthel avalia:",
                listOf("a) A dor do paciente", "b) A capacidade funcional nas actividades de vida diária", "c) A força de preensão manual", "d) A amplitude de movimento cervical", "e) A frequência cardíaca máxima", "f) O ângulo de Cobb"), "b"),
            Question(67, "A Escala de Ashworth modificada avalia:",
                listOf("a) A dor crónica", "b) O equilíbrio estático", "c) O grau de espasticidade muscular", "d) A força muscular máxima", "e) A capacidade vital pulmonar", "f) O nível de consciência"), "c"),
            Question(68, "A Medida de Independência Funcional (MIF) avalia domínios de:",
                listOf("a) Apenas locomoção", "b) Apenas comunicação", "c) Autocuidados, controlo esfincteriano, mobilidade, locomoção, comunicação e cognição social", "d) Apenas força muscular", "e) Apenas equilíbrio", "f) Apenas dor"), "c"),

            // ── 12. FISIOTERAPIA NA UTI (69-76) ──
            Question(69, "A ventilação mecânica invasiva é realizada através de:",
                listOf("a) Máscara facial", "b) Cateter nasal", "c) Tubo endotraqueal ou traqueostomia", "d) Máscara de Venturi", "e) Óculos nasais", "f) Máscara laríngea descartável"), "c"),
            Question(70, "O modo ventilatório CPAP fornece:",
                listOf("a) Ventilação controlada a volume", "b) Pressão negativa intermitente", "c) Pressão positiva contínua nas vias aéreas", "d) Ventilação oscilatória de alta frequência", "e) Aspiração contínua", "f) Ventilação por pressão negativa"), "c"),
            Question(71, "Um critério para desintubação (extubação) é:",
                listOf("a) Paciente inconsciente", "b) Ausência de reflexo de tosse", "c) Capacidade de manter ventilação espontânea com oxigenação satisfatória", "d) Instabilidade hemodinâmica grave", "e) Febre alta persistente", "f) Secreções abundantes e espessas"), "c"),
            Question(72, "Na gasometria, HCO3 normal situa-se entre:",
                listOf("a) 10 a 15 mEq/L", "b) 15 a 20 mEq/L", "c) 22 a 26 mEq/L", "d) 30 a 35 mEq/L", "e) 35 a 40 mEq/L", "f) 5 a 10 mEq/L"), "c"),
            Question(73, "O teste de respiração espontânea avalia a capacidade do paciente de:",
                listOf("a) Dormir sem roncar", "b) Falar normalmente", "c) Respirar adequadamente sem o suporte do ventilador", "d) Tossir com força máxima", "e) Correr em esteira", "f) Nadar sem pausas"), "c"),
            Question(74, "A intubação orotraqueal consiste na inserção de tubo pela:",
                listOf("a) Narina até a traqueia", "b) Boca até a traqueia", "c) Pele do pescoço até a traqueia", "d) Ouvido até a faringe", "e) Nariz até os brônquios", "f) Boca até o esófago"), "b"),
            Question(75, "A mobilização precoce na UTI reduz o risco de:",
                listOf("a) Aumento da força muscular", "b) Melhoria da ventilação", "c) Trombose venosa profunda, atelectasia e atrofia muscular", "d) Alta hospitalar antecipada", "e) Aumento do apetite", "f) Melhoria do sono"), "c"),
            Question(76, "A PaCO2 normal na gasometria situa-se entre:",
                listOf("a) 20 a 30 mmHg", "b) 35 a 45 mmHg", "c) 50 a 60 mmHg", "d) 60 a 70 mmHg", "e) 10 a 20 mmHg", "f) 70 a 80 mmHg"), "b"),

            // ── 13. ÉTICA E DEONTOLOGIA (77-80) ──
            Question(77, "O princípio ético da beneficência obriga o fisioterapeuta a:",
                listOf("a) Cobrar honorários elevados", "b) Agir sempre em benefício do paciente", "c) Tratar apenas pacientes com plano de saúde", "d) Divulgar informações do paciente", "e) Seguir apenas ordens médicas sem questionamento", "f) Priorizar o lucro sobre o cuidado"), "b"),
            Question(78, "O sigilo profissional em fisioterapia significa:",
                listOf("a) Não comunicar com a equipa multidisciplinar", "b) Ocultar informações importantes do paciente", "c) Manter confidenciais as informações do paciente", "d) Não documentar os atendimentos", "e) Recusar dar informações ao paciente sobre sua condição", "f) Esconder erros profissionais"), "c"),
            Question(79, "O princípio da autonomia do paciente reconhece o direito de:",
                listOf("a) O fisioterapeuta decidir sozinho o tratamento", "b) O médico impor o tratamento sem consulta", "c) O paciente tomar decisões informadas sobre seu tratamento", "d) A família decidir sem consultar o paciente", "e) O hospital determinar tudo sem consentimento", "f) O plano de saúde escolher o tratamento"), "c"),
            Question(80, "A documentação dos procedimentos fisioterapêuticos é:",
                listOf("a) Opcional e desnecessária", "b) Obrigatória apenas em hospitais privados", "c) Obrigatória como responsabilidade ética e legal do fisioterapeuta", "d) Responsabilidade exclusiva da enfermagem", "e) Necessária apenas para fins de cobrança", "f) Facultativa em serviços públicos"), "c"),

            // ── 14. FISIOTERAPIA MUSCULOESQUELÉTICA (81-84) ──
            Question(81, "O alongamento estático deve ser mantido por um tempo mínimo de:",
                listOf("a) 1 a 3 segundos", "b) 5 a 10 segundos", "c) 15 a 30 segundos", "d) 60 a 90 segundos", "e) 2 a 3 minutos", "f) Menos de 1 segundo"), "c"),
            Question(82, "A mobilização articular grau I segundo Maitland é:",
                listOf("a) Movimento de grande amplitude no final do arco", "b) Movimento oscilatório de pequena amplitude no início do arco", "c) Manipulação de alta velocidade", "d) Tracção contínua prolongada", "e) Movimento passivo forçado além do limite", "f) Exercício activo resistido"), "b"),
            Question(83, "A facilitação neuromuscular proprioceptiva (FNP) combina:",
                listOf("a) Calor e frio alternadamente", "b) Contracção isométrica seguida de alongamento", "c) Apenas exercícios aeróbicos", "d) Massagem com electroterapia", "e) Imobilização com mobilização", "f) Crioterapia com ultrassom"), "b"),
            Question(84, "O posicionamento em decúbito ventral (prono) é indicado para:",
                listOf("a) Pacientes com lesão facial grave", "b) Gestantes no terceiro trimestre", "c) Melhoria da oxigenação em pacientes com SDRA", "d) Pacientes com instabilidade cervical", "e) Apenas recém-nascidos saudáveis", "f) Pacientes com fracturas de esterno"), "c"),

            // ── 15. FISIOTERAPIA MATERNO-INFANTIL (85-88) ──
            Question(85, "O reflexo de Moro no recém-nascido é desencadeado por:",
                listOf("a) Estímulo luminoso intenso", "b) Som forte ou sensação de queda", "c) Toque suave no abdómen", "d) Pressão no calcâneo", "e) Rotação passiva da cabeça", "f) Compressão do tórax"), "b"),
            Question(86, "A marcha independente é esperada em crianças com desenvolvimento normal entre:",
                listOf("a) 6 a 8 meses", "b) 8 a 10 meses", "c) 12 a 18 meses", "d) 24 a 30 meses", "e) 3 a 4 meses", "f) 30 a 36 meses"), "c"),
            Question(87, "A Escala de Denver é utilizada para avaliar:",
                listOf("a) O peso do recém-nascido", "b) A altura da criança", "c) O desenvolvimento neuropsicomotor infantil", "d) A frequência cardíaca fetal", "e) A pressão arterial pediátrica", "f) A temperatura corporal"), "c"),
            Question(88, "A persistência de reflexos primitivos além do período esperado sugere:",
                listOf("a) Desenvolvimento motor acelerado", "b) Maturação neurológica precoce", "c) Disfunção neurológica", "d) Normalidade absoluta", "e) Inteligência superior", "f) Genialidade motora"), "c"),

            // ── 16. FISIOTERAPIA NEUROMUSCULAR (89-92) ──
            Question(89, "A unidade motora é composta por:",
                listOf("a) Um músculo e um osso", "b) Um tendão e um ligamento", "c) Um neurónio motor alfa e todas as fibras musculares que ele inerva", "d) Um nervo sensitivo e um receptor", "e) Uma articulação e seus ligamentos", "f) Um vaso sanguíneo e um nervo"), "c"),
            Question(90, "Os neurónios aferentes são responsáveis por:",
                listOf("a) Transmitir comandos motores aos músculos", "b) Transmitir informações sensoriais ao SNC", "c) Conectar neurónios dentro do SNC", "d) Produzir neurotransmissores", "e) Controlar a frequência cardíaca", "f) Regular a temperatura corporal"), "b"),
            Question(91, "O Sistema Nervoso Central é composto por:",
                listOf("a) Nervos cranianos e espinais", "b) Gânglios e plexos nervosos", "c) Encéfalo e medula espinal", "d) Receptores sensoriais e músculos", "e) Artérias e veias cerebrais", "f) Meninges e líquor apenas"), "c"),
            Question(92, "O princípio do recrutamento de unidades motoras por tamanho indica que:",
                listOf("a) Unidades grandes são sempre recrutadas primeiro", "b) Todas as unidades são recrutadas simultaneamente", "c) Unidades menores são recrutadas primeiro para movimentos finos", "d) O recrutamento é aleatório", "e) Apenas metade das unidades é recrutada", "f) O tamanho não influencia o recrutamento"), "c"),

            // ── 17. FISIOTERAPIA EM ORTOPROTESIA E RECURSOS (93-95) ──
            Question(93, "A diatermia por ondas curtas opera na frequência de:",
                listOf("a) 1 MHz", "b) 3 MHz", "c) 27,12 MHz", "d) 100 MHz", "e) 500 kHz", "f) 10 kHz"), "c"),
            Question(94, "O método capacitivo da diatermia aquece predominantemente:",
                listOf("a) Tecidos profundos como ossos", "b) Apenas a pele superficial", "c) Tecidos superficiais ricos em água", "d) Exclusivamente tecido adiposo", "e) Apenas cartilagem articular", "f) Tecido nervoso central"), "c"),
            Question(95, "A contra-indicação absoluta para diatermia por ondas curtas é:",
                listOf("a) Contractura muscular", "b) Artrose crónica", "c) Presença de implantes metálicos na área de tratamento", "d) Dor lombar crónica", "e) Tendinite do supraespinhoso", "f) Bursite trocantérica"), "c")
        )
    }
}
