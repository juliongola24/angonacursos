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

        // 1. Normas de Boas Práticas de Armazenamento e Dispensação
        Topic(
            id = 1,
            title = "Boas Práticas de Armazenamento e Dispensação",
            icon = "📦",
            summary = "Normas que garantem a qualidade dos medicamentos desde o armazenamento até a dispensação.",
            markdownContent = """
# Normas de Boas Práticas de Armazenamento e Dispensação de Medicamentos

## Conceitos

As Boas Práticas de Armazenamento (BPA) compreendem o conjunto de normas e procedimentos técnicos que asseguram a manutenção da qualidade, segurança e eficácia dos medicamentos durante todo o período de estocagem. Envolvem o controlo rigoroso de temperatura, humidade, luminosidade, ventilação e organização física do espaço.

As Boas Práticas de Dispensação (BPD) referem-se ao conjunto de acções e orientações que o profissional farmacêutico deve seguir no momento de entregar o medicamento ao paciente. Incluem a verificação da prescrição médica, conferência do medicamento, orientação sobre o uso correcto, possíveis efeitos adversos e interacções medicamentosas.

O objectivo principal destas normas é garantir que o medicamento chegue ao paciente em condições ideais de uso, preservando suas propriedades farmacológicas e minimizando riscos à saúde.

## Classificação

As Boas Práticas podem ser classificadas em diversas categorias conforme a etapa da cadeia farmacêutica.

As práticas de armazenamento incluem o controlo ambiental com monitorização contínua de temperatura e humidade, a organização física que envolve estantes, prateleiras e câmaras frias devidamente identificadas, o controlo de validade com sistema FEFO (First Expire, First Out) onde o primeiro a vencer é o primeiro a sair, e a segregação de produtos que separa medicamentos termolábeis, controlados, inflamáveis e de uso geral.

As práticas de dispensação englobam a dispensação ambulatorial destinada a pacientes externos com prescrição médica, a dispensação hospitalar voltada para pacientes internados conforme prescrição do corpo clínico, a dispensação de medicamentos controlados que segue legislação específica com escrituração em livros de registo, e a dispensação por dose unitária onde cada dose é individualizada e identificada por paciente.

## Diferenças

O armazenamento foca na conservação do produto, garantindo condições ambientais adequadas, rastreabilidade e organização do stock. A dispensação foca na entrega segura ao paciente, incluindo orientação farmacêutica, verificação de dose e posologia, e acompanhamento terapêutico.

Enquanto o armazenamento é um processo logístico e técnico que ocorre na retaguarda da farmácia, a dispensação é um acto clínico e assistencial que ocorre no contacto directo com o paciente. Ambos são complementares e indispensáveis para a qualidade do serviço farmacêutico.
            """.trimIndent()
        ),

        // 2. Formas Farmacêuticas e Vias de Administração
        Topic(
            id = 2,
            title = "Formas Farmacêuticas e Vias de Administração",
            icon = "💊",
            summary = "Classificação das formas farmacêuticas e vias de administração de medicamentos.",
            markdownContent = """
# Formas Farmacêuticas e Vias de Administração de Medicamentos

## Conceito

Forma farmacêutica é o estado final em que o medicamento se apresenta para ser administrado ao paciente. Resulta da combinação do princípio activo com excipientes, conferindo ao fármaco características adequadas de estabilidade, biodisponibilidade e aceitação pelo paciente.

A via de administração é o caminho pelo qual o medicamento é introduzido no organismo, determinando a velocidade de absorção, a distribuição e o início da acção terapêutica.

## Classificação

As formas farmacêuticas sólidas incluem comprimidos que são preparações obtidas por compressão de pós, cápsulas que são invólucros de gelatina contendo pó ou líquido, drágeas que são comprimidos revestidos com camadas de açúcar ou polímeros, pós para uso oral ou tópico, grânulos e pastilhas.

As formas farmacêuticas líquidas englobam soluções que são misturas homogéneas de soluto e solvente, xaropes que são soluções aquosas com alta concentração de açúcar, suspensões que são dispersões de partículas sólidas em meio líquido, emulsões que são dispersões de dois líquidos imiscíveis, elixires que são soluções hidroalcoólicas adoçadas, e gotas.

As formas farmacêuticas semi-sólidas compreendem pomadas que são preparações de consistência mole para aplicação cutânea, cremes que são emulsões semi-sólidas, géis que são preparações semi-sólidas transparentes, pastas que são pomadas com alta concentração de pós, e supositórios para administração rectal.

As formas farmacêuticas especiais incluem aerossóis e sprays para inalação, adesivos transdérmicos para libertação controlada através da pele, e injectáveis que são soluções estéreis para administração parenteral.

As vias de administração classificam-se em via oral que é a mais comum e conveniente, via sublingual com absorção rápida pela mucosa bucal, via rectal para pacientes com dificuldade de deglutição, via tópica ou cutânea para acção local na pele, via parenteral que inclui intravenosa com acção imediata, intramuscular com absorção moderada e subcutânea com absorção lenta, via inalatória para acção directa nos pulmões, e via oftálmica, nasal e auricular para acção localizada.

## Diferenças

As formas sólidas apresentam maior estabilidade e facilidade de transporte, enquanto as líquidas permitem ajuste preciso de dose e são mais adequadas para crianças e idosos. A via oral é não invasiva mas tem absorção variável, enquanto a via intravenosa garante biodisponibilidade de 100% mas requer técnica asséptica e profissional habilitado.
            """.trimIndent()
        ),

        // 3. Prazo de Validade dos Medicamentos
        Topic(
            id = 3,
            title = "Prazo de Validade dos Medicamentos",
            icon = "📅",
            summary = "Conceito, tempo de validade e importância do prazo de validade dos medicamentos.",
            markdownContent = """
# Prazo de Validade dos Medicamentos

## Conceito

O prazo de validade é o período durante o qual o medicamento mantém suas características de qualidade, segurança e eficácia, desde que armazenado nas condições especificadas pelo fabricante. Após este prazo, não há garantia de que o medicamento mantenha suas propriedades terapêuticas originais.

É determinado através de estudos de estabilidade realizados pelo fabricante, que avaliam a degradação do princípio activo, alterações físicas, químicas e microbiológicas ao longo do tempo. A data de validade é impressa na embalagem do medicamento e representa o último dia em que o produto pode ser utilizado com segurança.

## Tempo de Validade

O tempo de validade varia conforme a natureza do medicamento, a forma farmacêutica e as condições de armazenamento. Medicamentos sólidos como comprimidos e cápsulas geralmente possuem validade entre dois e cinco anos quando armazenados em temperatura ambiente controlada.

Medicamentos líquidos como xaropes e soluções tendem a ter validade mais curta, geralmente entre um e três anos, pois são mais susceptíveis a degradação química e contaminação microbiológica. Após a abertura do frasco, a validade pode ser significativamente reduzida.

Vacinas e medicamentos biológicos possuem prazos de validade específicos e frequentemente requerem refrigeração entre dois e oito graus Celsius. Insulinas, por exemplo, têm validade limitada após abertura do frasco, geralmente de 28 dias em temperatura ambiente.

Medicamentos manipulados têm validade definida pela farmácia de manipulação, geralmente mais curta que a dos industrializados, variando de 30 dias a seis meses conforme a formulação.

## Importância

A observância do prazo de validade é fundamental para a segurança do paciente. Medicamentos vencidos podem apresentar redução da potência terapêutica, tornando o tratamento ineficaz. Em alguns casos, a degradação química pode gerar subprodutos tóxicos prejudiciais à saúde.

O controlo do prazo de validade é uma responsabilidade directa do farmacêutico e constitui parte essencial das Boas Práticas de Armazenamento. A utilização do sistema FEFO garante que os medicamentos com validade mais próxima sejam dispensados primeiro, reduzindo perdas e garantindo a qualidade do tratamento.

A dispensação de medicamentos vencidos constitui infracção sanitária grave, sujeitando o estabelecimento a penalidades legais e comprometendo a confiança do paciente no serviço farmacêutico.
            """.trimIndent()
        ),

        // 4. Sistemas de Distribuição de Medicamentos
        Topic(
            id = 4,
            title = "Sistemas de Distribuição de Medicamentos",
            icon = "🏥",
            summary = "Classificação, vantagens, desvantagens e fluxograma dos sistemas de distribuição.",
            markdownContent = """
# Sistemas de Distribuição de Medicamentos

## Classificação

O sistema colectivo consiste na distribuição de medicamentos por unidade de internamento, onde a farmácia envia grandes quantidades de medicamentos para cada sector, que são armazenados em armários ou carros de medicação. A enfermagem é responsável pela preparação e administração individual.

O sistema individualizado distribui medicamentos por paciente, com base na prescrição médica. A farmácia prepara e identifica os medicamentos para cada paciente individualmente, geralmente para um período de 24 horas.

O sistema de dose unitária é o mais avançado e seguro. Cada dose é preparada, embalada e identificada individualmente pela farmácia, pronta para administração directa ao paciente. Os medicamentos são distribuídos para um período determinado, geralmente 24 horas.

O sistema misto combina dois ou mais sistemas, sendo comum a utilização do sistema individualizado para a maioria dos medicamentos e do sistema colectivo para medicamentos de urgência e de uso comum.

## Vantagens e Desvantagens

O sistema colectivo tem como vantagens a simplicidade operacional e menor necessidade de pessoal na farmácia. Suas desvantagens incluem maior risco de erros de medicação, desperdício elevado, dificuldade de controlo do stock e impossibilidade de rastreamento por paciente.

O sistema individualizado oferece melhor controlo do stock, redução de desperdício e maior segurança na administração. Contudo, exige mais recursos humanos na farmácia e maior tempo de preparação.

O sistema de dose unitária proporciona a máxima segurança para o paciente com redução significativa de erros de medicação, melhor controlo de custos, rastreabilidade completa e optimização do trabalho da enfermagem. Suas desvantagens são o custo inicial elevado de implantação, necessidade de equipamentos específicos e maior número de profissionais farmacêuticos.

## Fluxograma

O fluxo operacional do sistema de dose unitária segue as seguintes etapas: recepção da prescrição médica pela farmácia, análise farmacêutica da prescrição verificando doses, interacções e duplicidades, separação e embalagem individualizada dos medicamentos, identificação de cada dose com dados do paciente, dispensação ao sector de internamento, administração pela equipa de enfermagem, e por fim o registo e devolução de doses não administradas à farmácia.
            """.trimIndent()
        ),

        // 5. Tipos de Inventários
        Topic(
            id = 5,
            title = "Tipos de Inventários",
            icon = "📋",
            summary = "Classificação, vantagens e desvantagens dos diferentes tipos de inventários farmacêuticos.",
            markdownContent = """
# Tipos de Inventários

## Classificação

O inventário geral ou periódico consiste na contagem completa de todos os itens do stock em um momento específico, geralmente realizado anualmente ou semestralmente. Requer paralisação parcial ou total das actividades da farmácia durante sua execução.

O inventário rotativo ou cíclico realiza contagens parciais de forma contínua ao longo do ano, dividindo os itens em grupos que são contados em períodos diferentes. Permite manter as operações normais durante o processo.

O inventário permanente ou contínuo utiliza sistemas informatizados para manter o controlo do stock em tempo real, registando cada entrada e saída de medicamentos automaticamente. Exige infraestrutura tecnológica adequada.

O inventário por amostragem selecciona aleatoriamente uma parcela representativa dos itens para contagem, sendo utilizado para verificação pontual da exactidão dos registos.

## Vantagens e Desvantagens

O inventário geral oferece visão completa do stock e identifica todas as discrepâncias de uma só vez. Porém, exige interrupção das actividades, mobiliza grande número de funcionários e consome tempo considerável.

O inventário rotativo permite continuidade das operações, detecção precoce de problemas e distribuição do esforço ao longo do tempo. A desvantagem é que nunca se tem uma visão total simultânea do stock e requer planeamento cuidadoso.

O inventário permanente proporciona controlo em tempo real, tomada de decisão ágil e redução de perdas. Suas desvantagens incluem o custo de implementação tecnológica e a dependência de sistemas informáticos.

O inventário por amostragem é rápido e económico, ideal para verificações de rotina. Contudo, pode não detectar problemas em itens que não foram amostrados.
            """.trimIndent()
        ),

        // 6. Concentração de Fármacos e Diluição de Soluções
        Topic(
            id = 6,
            title = "Concentração de Fármacos e Diluição",
            icon = "🧪",
            summary = "Conceito, tipos de concentrações e métodos de diluição de soluções farmacêuticas.",
            markdownContent = """
# Concentração de Fármacos e Diluição de Soluções

## Conceito

A concentração de um fármaco expressa a quantidade de soluto (princípio activo) presente em determinada quantidade de solvente ou solução. É um parâmetro fundamental na preparação de medicamentos, pois determina directamente a dose terapêutica e a eficácia do tratamento.

A diluição é o processo de redução da concentração de uma solução através da adição de solvente, sem alterar a quantidade absoluta de soluto presente. É uma prática rotineira na farmácia hospitalar para adequação de doses e preparação de medicamentos intravenosos.

## Diferentes Tipos de Concentrações

A concentração percentual peso/volume (p/v) expressa a quantidade em gramas de soluto em 100 mililitros de solução. Por exemplo, soro fisiológico a 0,9% contém 0,9 gramas de cloreto de sódio em cada 100 mililitros.

A concentração percentual peso/peso (p/p) expressa a quantidade em gramas de soluto em 100 gramas de preparação. É utilizada principalmente em formas semi-sólidas como pomadas e cremes.

A concentração percentual volume/volume (v/v) expressa o volume de soluto em 100 mililitros de solução. Utilizada para líquidos miscíveis como o álcool etílico a 70%.

A concentração em miligramas por mililitro (mg/mL) é amplamente utilizada em medicamentos injectáveis. Expressa directamente a quantidade do fármaco por unidade de volume.

A concentração molar expressa o número de moles de soluto por litro de solução. É utilizada em análises laboratoriais e preparações de reagentes.

A concentração em unidades internacionais por mililitro (UI/mL) é utilizada para fármacos biológicos como insulina e heparina.

## Métodos de Diluição de Soluções

A diluição simples consiste na adição de solvente a uma solução concentrada. Utiliza-se a fórmula C1 x V1 = C2 x V2, onde C1 é a concentração inicial, V1 o volume inicial, C2 a concentração final desejada e V2 o volume final.

A diluição seriada realiza diluições sucessivas a partir de uma solução-mãe, obtendo concentrações progressivamente menores. É utilizada em testes de sensibilidade a antibióticos e preparações laboratoriais.

A reconstituição é o processo de adição de diluente a um medicamento liofilizado (em pó) para obtenção de uma solução ou suspensão pronta para uso. Deve-se respeitar o tipo e volume de diluente especificado pelo fabricante.
            """.trimIndent()
        ),

        // 7. Condições de Armazenamento
        Topic(
            id = 7,
            title = "Condições de Armazenamento de Medicamentos",
            icon = "🌡️",
            summary = "Condições e diferentes intervalos de temperatura para armazenamento de medicamentos.",
            markdownContent = """
# Condições de Armazenamento de Medicamentos

## Condições e Diferentes Intervalos de Temperatura

O armazenamento adequado de medicamentos é essencial para manter a qualidade, segurança e eficácia dos produtos farmacêuticos. As condições ambientais devem ser rigorosamente controladas e monitorizadas.

A temperatura ambiente controlada corresponde ao intervalo entre 15°C e 30°C. A maioria dos medicamentos sólidos como comprimidos, cápsulas e drágeas são armazenados nestas condições. É fundamental que o ambiente possua climatização adequada, especialmente em regiões tropicais.

A temperatura de refrigeração situa-se entre 2°C e 8°C. Medicamentos termolábeis como vacinas, insulinas, alguns antibióticos reconstituídos, colírios e determinados medicamentos biológicos requerem esta faixa de temperatura. A cadeia de frio deve ser mantida ininterruptamente.

O congelamento corresponde a temperaturas iguais ou inferiores a 0°C, sendo necessário para alguns produtos biológicos, plasmas e determinadas vacinas. Nem todos os medicamentos suportam congelamento, podendo haver perda de eficácia.

A temperatura fresca situa-se entre 8°C e 15°C. Alguns supositórios e determinadas formulações semi-sólidas podem requerer esta faixa de temperatura.

Além da temperatura, a humidade relativa do ar deve ser mantida entre 40% e 70% para evitar degradação dos medicamentos. Humidade excessiva pode causar amolecimento de cápsulas, dissolução prematura de comprimidos e crescimento microbiológico.

A protecção da luz é necessária para medicamentos fotossensíveis que devem ser armazenados em embalagens opacas ou âmbar e em locais protegidos da luz directa.

A ventilação adequada garante a circulação de ar no ambiente de armazenamento, prevenindo acumulação de calor e humidade. Os medicamentos devem ser mantidos afastados de paredes e do chão, sobre estrados ou prateleiras.

A monitorização contínua das condições de armazenamento deve ser realizada com termómetros e higrómetros calibrados, com registos periódicos documentados. Qualquer desvio das condições especificadas deve ser investigado e corrigido imediatamente.
            """.trimIndent()
        ),

        // 8. Objectivos e Principais Actividades da Farmácia Hospitalar
        Topic(
            id = 8,
            title = "Farmácia Hospitalar: Objectivos e Actividades",
            icon = "🏨",
            summary = "Objectivos e principais actividades da farmácia hospitalar.",
            markdownContent = """
# Objectivos e Principais Actividades da Farmácia Hospitalar

## Objectivos

A farmácia hospitalar tem como objectivo principal garantir o uso racional, seguro e eficaz dos medicamentos dentro do ambiente hospitalar. Visa promover a assistência farmacêutica integral ao paciente internado e ambulatorial, contribuindo para a melhoria da qualidade assistencial.

Os objectivos específicos incluem assegurar o abastecimento contínuo de medicamentos e produtos de saúde com qualidade e custo adequado, promover o uso racional de medicamentos através de informação e educação, participar activamente nas decisões terapêuticas junto à equipa multidisciplinar, desenvolver e implementar políticas de farmacovigilância, contribuir para o controlo de infecções hospitalares através da gestão de antimicrobianos, e garantir o cumprimento das normas regulatórias e legais relacionadas a medicamentos.

## Principais Actividades

A selecção de medicamentos envolve a participação na elaboração e actualização da lista de medicamentos essenciais do hospital, baseada em critérios de eficácia, segurança, custo e necessidade da população assistida.

A programação e aquisição compreende o planeamento das compras com base no consumo histórico, sazonalidade, perfil epidemiológico e disponibilidade orçamental, garantindo o abastecimento contínuo sem excessos.

O armazenamento e controlo de stock incluem a recepção, conferência, armazenamento adequado, controlo de validade e inventário periódico de todos os medicamentos e produtos de saúde.

A distribuição de medicamentos abrange todos os sistemas de distribuição, desde o colectivo até o de dose unitária, conforme a estrutura e recursos do hospital.

A dispensação inclui a análise da prescrição médica, orientação ao paciente e equipa de saúde, e acompanhamento farmacoterapêutico.

A farmácia clínica envolve a actuação directa do farmacêutico junto ao paciente e equipa de saúde, realizando conciliação medicamentosa, monitorização terapêutica e intervenções farmacêuticas.

A manipulação e preparação de medicamentos inclui a produção de formulações magistrais, preparo de nutrição parenteral, quimioterapia antineoplásica e reconstituição de medicamentos injectáveis em condições assépticas.

O ensino e pesquisa envolvem a formação de estudantes e residentes, desenvolvimento de protocolos clínicos e participação em ensaios clínicos.
            """.trimIndent()
        ),

        // 9. Uso Combinado de Medicamentos
        Topic(
            id = 9,
            title = "Uso Combinado de Medicamentos",
            icon = "💉",
            summary = "Vantagens e desvantagens do uso combinado de medicamentos.",
            markdownContent = """
# Uso Combinado de Medicamentos

## Conceito

O uso combinado de medicamentos, também denominado politerapia ou associação medicamentosa, consiste na utilização simultânea de dois ou mais fármacos para o tratamento de uma ou mais condições clínicas. Esta prática é comum na medicina moderna, especialmente no tratamento de doenças crónicas e complexas.

## Vantagens

O sinergismo terapêutico ocorre quando a combinação de fármacos produz efeito superior à soma dos efeitos individuais, permitindo o uso de doses menores de cada medicamento com consequente redução de efeitos adversos.

A ampliação do espectro de acção é particularmente importante no tratamento de infecções polimicrobianas, onde a associação de antibióticos permite cobrir diferentes agentes patogénicos simultaneamente.

A prevenção de resistência microbiana é uma vantagem crucial na terapia anti-infecciosa. A combinação de antimicrobianos dificulta o desenvolvimento de resistência bacteriana, como no esquema tríplice para tuberculose.

A redução de efeitos adversos pode ser alcançada quando doses menores de cada fármaco são utilizadas na combinação, mantendo a eficácia terapêutica com menor toxicidade individual.

O tratamento de comorbidades permite abordar simultaneamente múltiplas condições clínicas, como hipertensão arterial e diabetes mellitus, com esquemas terapêuticos optimizados.

A melhoria da adesão ao tratamento pode ser alcançada com formulações de dose fixa combinada, reduzindo o número de comprimidos diários.

## Desvantagens

O aumento do risco de interacções medicamentosas é proporcional ao número de fármacos utilizados. Interacções podem resultar em aumento da toxicidade, redução da eficácia ou efeitos imprevisíveis.

O aumento de efeitos adversos ocorre quando os fármacos partilham perfis de toxicidade semelhantes, podendo resultar em efeitos cumulativos prejudiciais ao paciente.

O maior custo do tratamento é uma consequência directa da utilização de múltiplos medicamentos, impactando tanto o paciente quanto o sistema de saúde.

A dificuldade de adesão ao tratamento pode ocorrer quando o esquema terapêutico é complexo, com múltiplos horários e condições de administração diferentes.

A dificuldade na identificação de reacções adversas aumenta com o número de medicamentos, tornando mais complexa a determinação do fármaco responsável por um efeito indesejado.
            """.trimIndent()
        ),

        // 10. Gestão de Stocks
        Topic(
            id = 10,
            title = "Gestão de Stocks",
            icon = "📊",
            summary = "Seguimentos, stock máximo e mínimo, roturas e rotatividade de itens.",
            markdownContent = """
# Gestão de Stocks

## Seguimentos de Gestão de Stock

A gestão de stocks farmacêuticos envolve um conjunto integrado de processos que visam garantir a disponibilidade contínua de medicamentos com qualidade e custos adequados. Os principais seguimentos incluem o planeamento da demanda, a programação de compras, o controlo de entradas e saídas, a monitorização de validades e o acompanhamento de indicadores de desempenho.

O planeamento da demanda baseia-se na análise do consumo histórico, perfil epidemiológico da população assistida, sazonalidade de doenças e introdução de novos protocolos terapêuticos.

A programação de compras define as quantidades a adquirir, os prazos de entrega e os fornecedores, considerando os níveis de stock definidos e a capacidade de armazenamento.

## Stock Máximo e Mínimo

O stock mínimo, também chamado ponto de ressuprimento, é a quantidade abaixo da qual se deve providenciar nova aquisição para evitar ruptura no abastecimento. É calculado considerando o consumo médio diário multiplicado pelo tempo de ressuprimento (prazo entre o pedido e a entrega).

O stock máximo é a quantidade máxima de produto que deve ser mantida em armazém, considerando a capacidade de armazenamento, o custo de manutenção do stock e o risco de perdas por validade. É calculado somando o stock mínimo ao lote de compra.

O ponto de pedido é o nível de stock que, ao ser atingido, desencadeia um novo processo de aquisição. Deve considerar o tempo de ressuprimento e uma margem de segurança.

## Consequências de Rotura de Stock

A rotura de stock de medicamentos tem consequências graves para a assistência ao paciente. Pode resultar na interrupção de tratamentos em curso, substituição por alternativas menos eficazes ou mais caras, aumento do tempo de internamento, agravamento do quadro clínico e, em casos extremos, risco de morte.

Para a instituição, a rotura gera custos adicionais com compras de emergência a preços superiores, desgaste da imagem institucional, insatisfação dos profissionais de saúde e possíveis implicações legais.

## Rotatividade de Itens

A rotatividade ou giro de stock mede a frequência com que o stock é renovado em determinado período. Itens de alta rotatividade são aqueles consumidos rapidamente e repostos com frequência, enquanto itens de baixa rotatividade permanecem mais tempo armazenados.

O índice de rotatividade é calculado dividindo o consumo total do período pelo stock médio. Um índice elevado indica boa gestão, com menor capital imobilizado e menor risco de perdas.

## Principais Seguimentos de Gestão de Stock

Os seguimentos essenciais incluem a recepção e conferência de medicamentos verificando quantidade, qualidade, validade e conformidade com o pedido. O registo de entradas e saídas deve ser realizado em sistema informatizado. O controlo de validades utiliza o sistema FEFO. A realização de inventários periódicos confronta os registos com o stock físico. A análise de indicadores como taxa de ruptura, giro de stock e custo de armazenamento orienta a tomada de decisão. E a avaliação de fornecedores considera prazo de entrega, qualidade e preço.
            """.trimIndent()
        ),

        // 11. Classificação ABC
        Topic(
            id = 11,
            title = "Classificação ABC dos Produtos Farmacêuticos",
            icon = "📈",
            summary = "Classificação ABC, cálculos de stock e causas de rotura.",
            markdownContent = """
# Classificação ABC dos Produtos Farmacêuticos e sua Importância na Redução de Custos

## Conceito

A classificação ABC, também conhecida como análise de Pareto aplicada à gestão farmacêutica, é uma ferramenta que categoriza os itens do stock conforme seu impacto financeiro. Baseia-se no princípio de que uma pequena parcela dos itens representa a maior parte do valor investido.

Os itens da classe A representam aproximadamente 20% dos itens do stock, mas correspondem a cerca de 80% do valor financeiro total. Requerem controlo rigoroso, negociações frequentes com fornecedores e monitorização contínua.

Os itens da classe B representam cerca de 30% dos itens e 15% do valor financeiro. Recebem controlo intermediário, com revisões periódicas.

Os itens da classe C representam aproximadamente 50% dos itens mas apenas 5% do valor financeiro. Podem ter controlo mais simplificado, com reposições menos frequentes.

## Cálculos de Stock Máximo e Mínimo

O stock mínimo é calculado pela fórmula: Stock Mínimo = Consumo Médio Mensal (CMM) multiplicado pelo Tempo de Ressuprimento (TR) em meses. Por exemplo, se o CMM de um antibiótico é de 500 unidades e o TR é de 1 mês, o stock mínimo será de 500 unidades.

O stock máximo é calculado pela fórmula: Stock Máximo = Stock Mínimo + Lote de Compra. O lote de compra pode ser definido como o CMM multiplicado pelo intervalo entre pedidos.

O ponto de pedido é calculado pela fórmula: Ponto de Pedido = Stock Mínimo + (CMM multiplicado pelo Tempo de Ressuprimento), adicionando uma margem de segurança para itens críticos.

## Causas de Rotura de Stock e suas Consequências

As causas de rotura incluem planeamento inadequado com subestimação do consumo, atrasos na entrega por parte dos fornecedores, falhas no registo de entradas e saídas, aumento inesperado da demanda por surtos epidémicos, problemas na qualidade de lotes recebidos que levam a devoluções, e restrições orçamentais que limitam as aquisições.

As consequências incluem comprometimento da assistência ao paciente, necessidade de substituições terapêuticas nem sempre equivalentes, custos elevados com aquisições de emergência, desgaste da relação com a equipa clínica e possíveis desfechos clínicos desfavoráveis.
            """.trimIndent()
        ),

        // 12. Sistema de Estocagem
        Topic(
            id = 12,
            title = "Sistema de Estocagem de Produtos Farmacêuticos",
            icon = "🗄️",
            summary = "Métodos e critérios de organização para estocagem de produtos farmacêuticos.",
            markdownContent = """
# Sistema de Estocagem de Produtos Farmacêuticos

## Conceito

O sistema de estocagem compreende o conjunto de métodos, equipamentos e procedimentos utilizados para organizar e manter os medicamentos e produtos farmacêuticos de forma ordenada, segura e acessível no ambiente de armazenamento.

## Métodos de Organização

A organização alfabética dispõe os medicamentos por ordem alfabética do nome genérico ou denominação comum internacional (DCI). Facilita a localização rápida dos produtos e é indicada para farmácias com grande variedade de itens.

A organização por forma farmacêutica agrupa os medicamentos conforme sua apresentação: sólidos orais, líquidos orais, injectáveis, tópicos, entre outros. Facilita o controlo de condições específicas de armazenamento.

A organização por grupo terapêutico ou farmacológico agrupa medicamentos com acção farmacológica semelhante, como anti-hipertensivos, antibióticos, anti-inflamatórios. Facilita a gestão clínica e a identificação de alternativas terapêuticas.

A organização por ordem de chegada (FIFO) ou por validade (FEFO) prioriza a dispensação dos itens que chegaram primeiro ou que vencem primeiro, respectivamente. O sistema FEFO é o mais recomendado para medicamentos.

## Equipamentos e Infraestrutura

As estantes e prateleiras devem ser de material resistente, lavável e que não acumule poeira. Os medicamentos devem ficar afastados pelo menos 10 centímetros do chão e 50 centímetros do tecto.

As câmaras frias e refrigeradores farmacêuticos mantêm temperatura entre 2°C e 8°C para medicamentos termolábeis. Devem possuir alarme de temperatura e registo contínuo.

Os armários de segurança são utilizados para medicamentos controlados e de alto custo, com acesso restrito e chave exclusiva.

Os estrados e paletes são utilizados para armazenamento de grandes volumes, mantendo os produtos afastados do chão e facilitando a limpeza e a ventilação.

## Boas Práticas de Estocagem

A sinalização adequada identifica cada área de armazenamento com etiquetas legíveis contendo nome do produto, concentração, forma farmacêutica e validade. A separação de medicamentos com nomes ou embalagens semelhantes (medicamentos look-alike e sound-alike) previne erros de dispensação. A manutenção de registos de temperatura e humidade permite rastrear condições de armazenamento. A limpeza regular do ambiente de estocagem previne contaminação e infestação por pragas.
            """.trimIndent()
        ),

        // 13. Uso Racional de Medicamentos
        Topic(
            id = 13,
            title = "Uso Racional de Medicamentos",
            icon = "⚖️",
            summary = "Conceito e importância do uso racional de medicamentos.",
            markdownContent = """
# Uso Racional de Medicamentos

## Conceito

Segundo a Organização Mundial da Saúde (OMS), o uso racional de medicamentos ocorre quando os pacientes recebem medicamentos apropriados para suas condições clínicas, em doses adequadas às suas necessidades individuais, por um período adequado e ao menor custo para si e para a comunidade.

O uso racional envolve a prescrição correcta pelo médico, a dispensação adequada pelo farmacêutico, a administração correcta pelo paciente ou profissional de saúde e o acompanhamento dos resultados terapêuticos.

Os critérios para o uso racional incluem a indicação correcta baseada em evidência científica, a escolha do medicamento mais adequado considerando eficácia, segurança, conveniência e custo, a dose e via de administração apropriadas para cada paciente, a duração adequada do tratamento, e a ausência de contra-indicações para o paciente em questão.

## Importância

O uso irracional de medicamentos é um problema global de saúde pública. A OMS estima que mais de metade de todos os medicamentos são prescritos, dispensados ou vendidos de forma inadequada, e que metade dos pacientes não os toma correctamente.

A automedicação inadequada pode mascarar sintomas de doenças graves, causar reacções adversas, promover resistência antimicrobiana e resultar em intoxicações medicamentosas.

O uso excessivo de antibióticos é uma das principais causas de resistência antimicrobiana, considerada pela OMS como uma das maiores ameaças à saúde global. A prescrição racional de antimicrobianos é essencial para preservar a eficácia destes medicamentos.

A polimedicação, especialmente em idosos, aumenta o risco de interacções medicamentosas, reacções adversas e erros de medicação. A revisão periódica da farmacoterapia pelo farmacêutico contribui para optimizar o tratamento.

O papel do farmacêutico no uso racional inclui a análise de prescrições, a orientação ao paciente sobre o uso correcto dos medicamentos, a identificação e resolução de problemas relacionados a medicamentos, e a promoção de educação em saúde na comunidade.

A implementação de protocolos clínicos, formulários terapêuticos e comissões de farmácia e terapêutica são estratégias institucionais fundamentais para promover o uso racional de medicamentos em hospitais e serviços de saúde.
            """.trimIndent()
        ),

        // 14. Farmacovigilância
        Topic(
            id = 14,
            title = "Farmacovigilância",
            icon = "🔍",
            summary = "Conceitos básicos, importância e reacções adversas a medicamentos.",
            markdownContent = """
# Farmacovigilância

## Conceitos Básicos

A farmacovigilância é a ciência e as actividades relacionadas com a detecção, avaliação, compreensão e prevenção de efeitos adversos ou quaisquer outros problemas relacionados com medicamentos. É definida pela OMS como o conjunto de processos destinados a monitorar a segurança dos medicamentos após sua comercialização.

A reacção adversa a medicamento (RAM) é qualquer resposta nociva e não intencional a um medicamento, que ocorre em doses normalmente utilizadas para profilaxia, diagnóstico ou tratamento. Difere de efeito colateral, que é um efeito previsível e relacionado à acção farmacológica do medicamento.

O evento adverso é qualquer ocorrência médica desfavorável que se apresenta durante o tratamento com um medicamento, sem necessariamente ter relação causal estabelecida com o mesmo.

## Importância

A farmacovigilância é fundamental porque os ensaios clínicos realizados antes da comercialização dos medicamentos envolvem um número limitado de pacientes, por período limitado e em condições controladas. Reacções adversas raras, de longo prazo ou que ocorrem em populações específicas podem só ser detectadas após o uso amplo do medicamento na prática clínica.

A notificação espontânea de reacções adversas pelos profissionais de saúde é a base do sistema de farmacovigilância. Cada profissional tem a responsabilidade de notificar suspeitas de reacções adversas às autoridades sanitárias competentes.

A farmacovigilância contribui para a tomada de decisões regulatórias como retirada de medicamentos do mercado, alteração de bulas, restrição de indicações e adição de advertências de segurança.

## Reacções Adversas

As reacções do tipo A (augmented) são previsíveis, dose-dependentes e relacionadas à acção farmacológica do medicamento. São as mais comuns e geralmente menos graves. Exemplos incluem hipoglicemia por insulina e sangramento por anticoagulantes.

As reacções do tipo B (bizarre) são imprevisíveis, não dose-dependentes e não relacionadas à acção farmacológica. São menos comuns mas potencialmente mais graves. Incluem reacções alérgicas, anafilaxia e reacções idiossincrásicas.

As reacções do tipo C (chronic) estão relacionadas ao uso prolongado do medicamento, como a nefropatia por analgésicos e a osteoporose por corticosteróides.

As reacções do tipo D (delayed) manifestam-se tardiamente, mesmo após a descontinuação do medicamento. Incluem teratogenicidade e carcinogenicidade.

O papel do farmacêutico na farmacovigilância inclui a identificação e documentação de reacções adversas, a notificação às autoridades competentes, a orientação ao paciente sobre sinais de alerta e a implementação de medidas preventivas.
            """.trimIndent()
        ),

        // 15. Papel da Farmácia no Controlo das Infecções Hospitalares
        Topic(
            id = 15,
            title = "Farmácia no Controlo das Infecções Hospitalares",
            icon = "🧫",
            summary = "Papel da farmácia hospitalar no controlo e prevenção de infecções hospitalares.",
            markdownContent = """
# Papel da Farmácia no Controlo das Infecções Hospitalares

## Conceito

As infecções hospitalares, também denominadas infecções associadas aos cuidados de saúde, são infecções adquiridas durante a permanência do paciente no ambiente hospitalar, que não estavam presentes ou em incubação no momento da admissão.

A farmácia hospitalar desempenha papel fundamental no controlo destas infecções através da gestão racional de antimicrobianos, participação na comissão de controlo de infecção hospitalar (CCIH) e implementação de programas de stewardship de antimicrobianos.

## Actividades da Farmácia no Controlo de Infecções

A gestão de antimicrobianos (antimicrobial stewardship) é a actividade central da farmácia no controlo de infecções. Consiste na implementação de estratégias para optimizar o uso de antibióticos, antifúngicos e antivirais, garantindo eficácia terapêutica e minimizando o desenvolvimento de resistência.

A análise de prescrições de antimicrobianos inclui a verificação da indicação, dose, via de administração, duração do tratamento e adequação ao perfil de sensibilidade microbiológica. O farmacêutico deve intervir quando identificar uso inadequado.

A elaboração e actualização de protocolos de profilaxia antimicrobiana cirúrgica define os antimicrobianos recomendados, o momento de administração e a duração da profilaxia para cada tipo de procedimento cirúrgico.

O controlo de germicidas e saneantes envolve a selecção, padronização e controlo de qualidade dos desinfectantes e anti-sépticos utilizados no hospital.

A preparação de soluções anti-sépticas e desinfectantes em condições adequadas garante a concentração e eficácia dos produtos utilizados na prevenção de infecções.

A monitorização do consumo de antimicrobianos através de indicadores como DDD (Dose Diária Definida) por 1000 pacientes-dia permite avaliar tendências de uso e identificar oportunidades de intervenção.

A participação na comissão de controlo de infecção hospitalar permite ao farmacêutico contribuir com conhecimento sobre farmacocinética, farmacodinâmica e padrões de resistência para a tomada de decisões institucionais.

A educação continuada dos profissionais de saúde sobre uso racional de antimicrobianos e medidas de prevenção de infecções é uma actividade permanente da farmácia hospitalar.
            """.trimIndent()
        ),

        // 16. Requisitos para Viabilizar uma Farmácia Hospitalar
        Topic(
            id = 16,
            title = "Requisitos para Farmácia Hospitalar",
            icon = "🏗️",
            summary = "Requisitos estruturais, humanos e organizacionais para uma farmácia hospitalar.",
            markdownContent = """
# Requisitos para Viabilizar uma Farmácia Hospitalar

## Requisitos Estruturais

A farmácia hospitalar deve dispor de área física adequada e suficiente para realizar todas as suas actividades. As áreas essenciais incluem a área de recepção e conferência de medicamentos, a área de armazenamento geral com condições ambientais controladas, a área de armazenamento refrigerado com câmaras frias ou refrigeradores farmacêuticos, a área de armazenamento de medicamentos controlados com segurança reforçada, a área de dispensação com balcão de atendimento e sistema informatizado, a sala de manipulação e preparo de medicamentos, a sala limpa para preparações estéreis quando aplicável, o escritório administrativo para gestão e documentação, e vestiários para funcionários.

As instalações devem possuir iluminação adequada, ventilação ou climatização, piso lavável e resistente, paredes lisas e de fácil limpeza, e protecção contra entrada de insectos e roedores.

## Requisitos de Recursos Humanos

A farmácia hospitalar deve contar com farmacêutico responsável técnico devidamente habilitado e inscrito no conselho profissional. O quadro de pessoal deve incluir farmacêuticos clínicos para actividades assistenciais, técnicos de farmácia para actividades operacionais, auxiliares para tarefas de apoio e pessoal administrativo.

A qualificação e formação contínua da equipa são essenciais para garantir a qualidade dos serviços prestados. Devem ser implementados programas de educação permanente abrangendo actualização técnica, biossegurança e humanização do atendimento.

## Requisitos Organizacionais

A farmácia hospitalar deve possuir um organograma definido com linhas de responsabilidade claras. Os procedimentos operacionais padrão (POPs) devem ser elaborados, implementados e periodicamente revisados para todas as actividades.

O sistema informatizado de gestão farmacêutica deve permitir o controlo de stock em tempo real, o rastreamento de lotes e validades, a emissão de relatórios de consumo e a integração com o sistema de prescrição electrónica do hospital.

A documentação completa de todas as actividades, incluindo registos de temperatura, registos de dispensação, notas de recepção e registos de não-conformidades, é obrigatória para fins de rastreabilidade e auditoria.

## Requisitos Legais

A farmácia hospitalar deve possuir alvará de funcionamento emitido pela autoridade sanitária competente, licença de funcionamento actualizada e cumprir toda a legislação vigente relativa a medicamentos, incluindo normas para medicamentos controlados, produtos termolábeis e medicamentos experimentais.
            """.trimIndent()
        ),

        // 17. Interacções Medicamentosas
        Topic(
            id = 17,
            title = "Interacções Medicamentosas",
            icon = "⚠️",
            summary = "Conceito, classificação, vantagens e desvantagens das interacções medicamentosas.",
            markdownContent = """
# Interacções Medicamentosas

## Conceito

Interacção medicamentosa é a modificação do efeito de um fármaco pela administração prévia ou concomitante de outro fármaco, alimento, bebida ou agente químico ambiental. Pode resultar em aumento ou diminuição da eficácia terapêutica, ou no aparecimento de efeitos adversos inesperados.

As interacções podem ocorrer entre medicamento e medicamento (as mais comuns e clinicamente relevantes), entre medicamento e alimento (como a interacção entre varfarina e vitamina K), entre medicamento e fitoterapêutico (como a interacção entre hipericão e contraceptivos orais), e entre medicamento e exames laboratoriais (interferência nos resultados analíticos).

## Classificação

As interacções farmacocinéticas alteram a absorção, distribuição, metabolismo ou excreção do fármaco. Na absorção, podem modificar o pH gástrico, a motilidade intestinal ou formar complexos insolúveis. Na distribuição, competem por ligação às proteínas plasmáticas. No metabolismo, podem inibir ou induzir as enzimas hepáticas do citocromo P450. Na excreção, podem alterar o pH urinário ou competir pela secreção tubular renal.

As interacções farmacodinâmicas alteram o efeito do fármaco no local de acção, sem modificar sua concentração plasmática. Podem ser sinérgicas quando potencializam o efeito, como a associação de dois anti-hipertensivos. Podem ser antagónicas quando reduzem ou anulam o efeito, como a administração de naloxona para reverter sobredosagem de opióides.

As interacções farmacêuticas, também chamadas incompatibilidades, ocorrem antes da administração ao paciente, geralmente durante a preparação ou mistura de medicamentos intravenosos. Podem resultar em precipitação, mudança de cor ou inactivação do fármaco.

Quanto à gravidade, as interacções classificam-se em graves quando representam risco de vida ou dano significativo e devem ser evitadas, moderadas quando podem causar deterioração clínica e requerem monitorização, e leves quando têm efeito clínico limitado e geralmente não requerem intervenção.

## Vantagens

As interacções benéficas podem ser utilizadas terapeuticamente. O sinergismo permite associar fármacos para obter melhor resposta clínica com doses menores. O antagonismo é utilizado terapeuticamente em situações de intoxicação ou sobredosagem. A redução de efeitos adversos pode ser alcançada pela associação de fármacos protectores.

## Desvantagens

As interacções prejudiciais podem resultar em perda de eficácia terapêutica, toxicidade aumentada, efeitos adversos graves, aumento do tempo de internamento e maior morbimortalidade. A complexidade da identificação de interacções aumenta com o número de medicamentos prescritos, exigindo vigilância farmacêutica constante.

O papel do farmacêutico é fundamental na identificação, prevenção e gestão de interacções medicamentosas, utilizando bases de dados actualizadas, análise crítica das prescrições e comunicação efectiva com a equipa médica.
            """.trimIndent()
        ),

        // 18. Papel do Farmacêutico na Comissão de Farmácia e Terapêutica
        Topic(
            id = 18,
            title = "Farmacêutico na Comissão de Farmácia e Terapêutica",
            icon = "👨‍⚕️",
            summary = "Papel e contribuições do farmacêutico na comissão de farmácia e terapêutica.",
            markdownContent = """
# Papel do Farmacêutico na Comissão de Farmácia e Terapêutica

## Conceito

A Comissão de Farmácia e Terapêutica (CFT) é um órgão consultivo e deliberativo do hospital, de carácter multidisciplinar, responsável por assessorar a direcção clínica e administrativa nas questões relacionadas à selecção, uso e política de medicamentos da instituição. É composta por médicos, farmacêuticos, enfermeiros e outros profissionais de saúde.

## Funções da CFT

A elaboração e actualização do Formulário Terapêutico institucional é a principal actividade da CFT. O formulário lista os medicamentos padronizados pela instituição, seleccionados com base em critérios de eficácia comprovada, segurança, qualidade e custo-efectividade.

A análise de solicitações de inclusão e exclusão de medicamentos do formulário envolve a avaliação crítica de evidências científicas, análise farmacoeconómica e consideração das necessidades clínicas da instituição.

A elaboração de protocolos clínicos e directrizes terapêuticas padroniza condutas para as condições clínicas mais prevalentes, promovendo o uso racional de medicamentos e a uniformidade no tratamento.

A análise de informações sobre reacções adversas e interacções medicamentosas permite a tomada de decisões sobre restrições de uso, alertas de segurança e actualizações de protocolos.

## Papel Específico do Farmacêutico

O farmacêutico actua como membro técnico fundamental da CFT, contribuindo com conhecimento especializado em farmacologia, farmacoterapia, farmacovigilância e farmacoeconómica.

Na selecção de medicamentos, o farmacêutico elabora pareceres técnicos comparando alternativas terapêuticas quanto à eficácia, segurança, farmacocinética e custo. Realiza análises de custo-efectividade e custo-minimização para fundamentar as decisões.

Na promoção do uso racional, o farmacêutico desenvolve e implementa programas de educação continuada sobre farmacoterapia baseada em evidências, promove a adesão aos protocolos institucionais e monitora indicadores de uso de medicamentos.

Na farmacovigilância institucional, o farmacêutico coordena a notificação de reacções adversas, analisa os dados colectados e propõe medidas preventivas e correctivas.

Na gestão de informações, o farmacêutico mantém actualizada a base de dados de medicamentos, elabora boletins informativos sobre novos medicamentos e alertas de segurança, e responde a consultas técnicas da equipa de saúde.

Na análise de consumo e custos, o farmacêutico apresenta dados sobre padrões de utilização de medicamentos, tendências de consumo e impacto financeiro, subsidiando decisões administrativas e clínicas.

A participação activa do farmacêutico na CFT é essencial para garantir que as decisões sobre medicamentos sejam baseadas em evidências científicas, contribuindo para a segurança do paciente e a sustentabilidade financeira da instituição.
            """.trimIndent()
        )
    )
}
