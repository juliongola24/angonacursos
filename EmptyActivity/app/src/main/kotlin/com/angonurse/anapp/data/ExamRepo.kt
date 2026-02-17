package com.angonurse.anapp.data

/**
 * Repositório centralizado para as perguntas do exame de Farmácia.
 * Área: Técnicos Farmacêuticos.
 * 95 questões únicas sem repetições.
 */
object ExamRepo {

    const val EXAM_DURATION_MINUTES = 60

    val questions: List<Question> by lazy {
        listOf(
            // ── BOAS PRÁTICAS DE ARMAZENAMENTO E DISPENSAÇÃO (1-10) ──
            Question(1, "O sistema FEFO (First Expire, First Out) significa que:",
                listOf("a) O primeiro a entrar é o primeiro a sair", "b) O primeiro a vencer é o primeiro a sair", "c) O mais caro sai primeiro", "d) O mais barato sai primeiro", "e) O último a entrar sai primeiro", "f) O mais antigo é descartado"), "b"),
            Question(2, "As Boas Práticas de Dispensação incluem:",
                listOf("a) Apenas a entrega do medicamento", "b) Somente a conferência do stock", "c) Verificação da prescrição e orientação ao paciente", "d) Apenas o registo em livro", "e) A fabricação do medicamento", "f) O diagnóstico do paciente"), "c"),
            Question(3, "A temperatura ambiente controlada para armazenamento de medicamentos situa-se entre:",
                listOf("a) 0°C e 5°C", "b) 5°C e 10°C", "c) 15°C e 30°C", "d) 30°C e 40°C", "e) 2°C e 8°C", "f) 10°C e 15°C"), "c"),
            Question(4, "A humidade relativa do ar ideal para armazenamento de medicamentos deve estar entre:",
                listOf("a) 10% e 30%", "b) 40% e 70%", "c) 70% e 90%", "d) 80% e 100%", "e) 20% e 40%", "f) 50% e 80%"), "b"),
            Question(5, "O principal objectivo das Boas Práticas de Armazenamento é:",
                listOf("a) Manter a qualidade e eficácia dos medicamentos", "b) Reduzir o número de funcionários", "c) Aumentar o lucro da farmácia", "d) Simplificar a prescrição médica", "e) Eliminar a necessidade de refrigeração", "f) Reduzir o espaço de armazenamento"), "a"),
            Question(6, "Medicamentos fotossensíveis devem ser armazenados em:",
                listOf("a) Embalagens transparentes", "b) Temperatura de congelamento", "c) Qualquer local iluminado", "d) Embalagens opacas ou âmbar, protegidos da luz", "e) Apenas em câmaras frias", "f) Em contacto directo com a luz solar"), "d"),
            Question(7, "A escrituração de medicamentos controlados é obrigatória em:",
                listOf("a) Caderno de anotações simples", "b) Apenas no computador pessoal", "c) Livros de registo específicos conforme legislação", "d) Receitas de cozinha", "e) Não é obrigatória", "f) Folhas soltas"), "c"),
            Question(8, "Na dispensação, o farmacêutico deve verificar EXCEPTO:",
                listOf("a) A dose prescrita", "b) A posologia", "c) As interacções medicamentosas", "d) A validade do medicamento", "e) A via de administração", "f) O diagnóstico definitivo do paciente"), "f"),
            Question(9, "A segregação de produtos na farmácia separa medicamentos em categorias como:",
                listOf("a) Apenas medicamentos genéricos de referência", "b) Medicamentos por cor da embalagem", "c) Apenas injectáveis de orais", "d) Termolábeis, controlados, inflamáveis e de uso geral", "e) Apenas medicamentos vencidos dos válidos", "f) Medicamentos por fabricante"), "d"),
            Question(10, "A dispensação por dose unitária caracteriza-se por cada dose ser:",
                listOf("a) Enviada a granel para o sector", "b) Entregue mensalmente ao paciente", "c) Dispensada sem prescrição", "d) Apenas para medicamentos injectáveis", "e) Individualizada e identificada por paciente", "f) Distribuída sem controlo"), "e"),

            // ── FORMAS FARMACÊUTICAS E VIAS DE ADMINISTRAÇÃO (11-20) ──
            Question(11, "Forma farmacêutica é definida como:",
                listOf("a) A doença que o medicamento trata", "b) O nome comercial do medicamento", "c) A bula do medicamento", "d) O estado final do medicamento para administração ao paciente", "e) A prescrição médica", "f) O laboratório fabricante"), "d"),
            Question(12, "Cápsulas são invólucros geralmente de:",
                listOf("a) Metal", "b) Vidro", "c) Plástico rígido", "d) Papel", "e) Gelatina contendo pó ou líquido", "f) Borracha"), "e"),
            Question(13, "A via de administração intravenosa garante biodisponibilidade de:",
                listOf("a) 50%", "b) 75%", "c) 100%", "d) 25%", "e) 10%", "f) 90%"), "c"),
            Question(14, "Suspensões farmacêuticas são definidas como:",
                listOf("a) Misturas homogéneas de dois líquidos", "b) Soluções gasosas", "c) Preparações sólidas", "d) Emulsões de dois gases", "e) Dispersões de partículas sólidas em meio líquido", "f) Soluções cristalinas"), "e"),
            Question(15, "A via sublingual permite absorção rápida porque:",
                listOf("a) A absorção é mais lenta que oral", "b) A mucosa bucal é altamente vascularizada e evita o efeito de primeira passagem", "c) Evita qualquer absorção sistémica", "d) É a única via para antibióticos", "e) Não tem nenhuma vantagem específica", "f) É exclusiva para vacinas"), "b"),
            Question(16, "Drágeas são comprimidos revestidos com:",
                listOf("a) Metal", "b) Gelatina", "c) Camadas de açúcar ou polímeros", "d) Papel alumínio", "e) Parafina", "f) Silicone"), "c"),
            Question(17, "A via intramuscular apresenta absorção comparada à intravenosa:",
                listOf("a) Imediata e idêntica", "b) Nula", "c) Apenas tópica", "d) Moderada e mais lenta", "e) Exclusivamente renal", "f) Igual à via oral em todos os casos"), "d"),
            Question(18, "Emulsões farmacêuticas são definidas como:",
                listOf("a) Soluções de gases em líquidos", "b) Pós dissolvidos em água", "c) Dispersões de dois líquidos imiscíveis estabilizadas por emulsificante", "d) Preparações sólidas trituradas", "e) Gases comprimidos", "f) Cristais dissolvidos"), "c"),
            Question(19, "A principal vantagem da via oral de administração é:",
                listOf("a) Biodisponibilidade de 100%", "b) Acção imediata em emergências", "c) Não sofrer metabolismo hepático", "d) Ser a única via existente", "e) Não necessitar de água", "f) Ser não invasiva, segura e conveniente para o paciente"), "f"),
            Question(20, "Adesivos transdérmicos permitem:",
                listOf("a) Administração rápida em emergência", "b) Apenas acção local na pele", "c) Libertação controlada e sustentada do fármaco através da pele", "d) Administração de vacinas", "e) Substituição completa da via intravenosa", "f) Diagnóstico de doenças"), "c"),

            // ── PRAZO DE VALIDADE DOS MEDICAMENTOS (21-26) ──
            Question(21, "O prazo de validade de um medicamento é determinado por:",
                listOf("a) O farmacêutico da farmácia comunitária", "b) O paciente ao abrir a embalagem", "c) Estudos de estabilidade realizados pelo fabricante", "d) O médico prescritor", "e) A enfermagem do hospital", "f) O distribuidor grossista"), "c"),
            Question(22, "Após abertura, a insulina em uso tem validade aproximada de:",
                listOf("a) 6 meses", "b) 1 ano", "c) 90 dias", "d) 28 dias em temperatura ambiente controlada", "e) 7 dias", "f) Validade indefinida"), "d"),
            Question(23, "Medicamentos com prazo expirado podem apresentar:",
                listOf("a) Maior eficácia terapêutica", "b) Melhoria do sabor", "c) Aumento da biodisponibilidade", "d) Nenhuma alteração significativa", "e) Redução da potência e possíveis subprodutos tóxicos", "f) Maior estabilidade química"), "e"),
            Question(24, "Colírios multi-dose após abertura geralmente valem por:",
                listOf("a) 1 ano", "b) 6 meses", "c) 28 a 30 dias", "d) 90 dias", "e) Indefinidamente", "f) 7 dias"), "c"),
            Question(25, "A dispensação de medicamentos com prazo vencido constitui:",
                listOf("a) Prática aceitável em emergências", "b) Procedimento normal em hospitais", "c) Responsabilidade exclusiva do paciente", "d) Questão irrelevante para a saúde", "e) Apenas uma recomendação sem obrigação legal", "f) Infracção sanitária grave passível de penalização"), "f"),
            Question(26, "A estabilidade de um medicamento reconstituído depende principalmente de:",
                listOf("a) Apenas da marca comercial", "b) Da temperatura de armazenamento e condições indicadas pelo fabricante", "c) Do tamanho do frasco", "d) Da cor do rótulo", "e) Do preço do medicamento", "f) Do país de origem"), "b"),

            // ── SISTEMAS DE DISTRIBUIÇÃO DE MEDICAMENTOS (27-32) ──
            Question(27, "O sistema de distribuição colectivo distribui medicamentos por:",
                listOf("a) Paciente individual com prescrição", "b) Dose unitária individualizada", "c) Unidade de internamento, em grandes quantidades sem individualização", "d) Receita individual apenas", "e) Ambulatório exclusivamente", "f) Prescrição electrónica apenas"), "c"),
            Question(28, "A principal vantagem do sistema de dose unitária é:",
                listOf("a) Menor custo inicial de implementação", "b) Simplicidade operacional sem necessidade de farmacêuticos", "c) Dispensa a existência de prescrição médica", "d) Máxima segurança e significativa redução de erros de medicação", "e) Menor necessidade de recursos humanos", "f) Elimina a necessidade de qualquer controlo"), "d"),
            Question(29, "O sistema misto de distribuição na farmácia hospitalar combina:",
                listOf("a) Apenas dois medicamentos diferentes", "b) Farmácia e laboratório de análises", "c) Dois ou mais sistemas de distribuição conforme a necessidade", "d) Apenas medicamentos orais e injectáveis", "e) Prescrição manual e electrónica exclusivamente", "f) Somente venda e doação"), "c"),
            Question(30, "O sistema FIFO (First In, First Out) significa:",
                listOf("a) O primeiro a vencer sai primeiro", "b) O último a entrar sai primeiro", "c) O primeiro a entrar é o primeiro a sair", "d) O mais caro sai primeiro", "e) O mais leve sai primeiro", "f) Organização por cor da embalagem"), "c"),
            Question(31, "No fluxo da dose unitária, a primeira etapa é:",
                listOf("a) Administração pela enfermagem ao paciente", "b) Embalagem dos medicamentos", "c) Devolução de doses não utilizadas", "d) Compra de medicamentos ao fornecedor", "e) Recepção e análise da prescrição médica pela farmácia", "f) Diagnóstico do paciente"), "e"),
            Question(32, "A análise farmacêutica da prescrição verifica principalmente:",
                listOf("a) Apenas o nome do paciente", "b) O salário do médico prescritor", "c) Doses, possíveis interacções e duplicidades terapêuticas", "d) A cor do comprimido", "e) O fabricante preferido do hospital", "f) A marca comercial apenas"), "c"),

            // ── TIPOS DE INVENTÁRIOS (33-38) ──
            Question(33, "O inventário rotativo ou cíclico caracteriza-se por:",
                listOf("a) Contagem total de todos os itens uma vez por ano", "b) Ausência completa de contagens", "c) Contagens parciais programadas ao longo do ano", "d) Contagem apenas de medicamentos controlados", "e) Contagem semanal de todo o stock", "f) Contagem por estimativa visual"), "c"),
            Question(34, "O inventário permanente utiliza como principal ferramenta:",
                listOf("a) Contagem manual mensal de todos os itens", "b) Apenas fichas de papel preenchidas manualmente", "c) Contagem visual sem registo", "d) Estimativas de consumo baseadas na experiência", "e) Auditoria externa uma vez por ano", "f) Sistemas informatizados com actualização em tempo real"), "f"),
            Question(35, "A vantagem principal do inventário geral é proporcionar:",
                listOf("a) Não interromper as actividades diárias da farmácia", "b) Rapidez de execução com poucos recursos", "c) Visão completa do stock real com identificação de todas as discrepâncias", "d) Baixo custo operacional", "e) Não necessitar de pessoal dedicado", "f) Possibilidade de realização por telefone"), "c"),
            Question(36, "A principal desvantagem do inventário por amostragem é:",
                listOf("a) Custo muito elevado comparado ao geral", "b) Lentidão extrema do processo", "c) Não detectar problemas em itens que não foram incluídos na amostra", "d) Requerer paralisação total das actividades", "e) Ser impossível de realizar na prática", "f) Exigir equipamentos laboratoriais caros"), "c"),
            Question(37, "O inventário geral requer como principal condição:",
                listOf("a) Apenas um funcionário disponível", "b) Paralisação temporária das actividades para contagem completa", "c) Autorização do paciente", "d) Presença da polícia", "e) Equipamento electrónico avançado", "f) Contagem apenas dos itens mais caros"), "b"),
            Question(38, "A reconciliação de inventário consiste em:",
                listOf("a) Descartar todos os itens contados", "b) Ignorar as diferenças encontradas", "c) Comprar mais stock automaticamente", "d) Comparar o stock físico com o registo informático e justificar diferenças", "e) Transferir itens entre farmácias", "f) Vender os excedentes"), "d"),

            // ── CONCENTRAÇÃO DE FÁRMACOS E DILUIÇÃO (39-44) ──
            Question(39, "A fórmula C1 × V1 = C2 × V2 é utilizada para:",
                listOf("a) Calcular o preço de medicamentos", "b) Contagem de stock no inventário", "c) Diluição simples de soluções mantendo a quantidade de soluto", "d) Avaliação de fornecedores", "e) Cálculo de salários", "f) Prescrição médica"), "c"),
            Question(40, "O soro fisiológico a 0,9% contém:",
                listOf("a) 9 gramas de NaCl por litro de solução", "b) 0,9 gramas de NaCl por litro", "c) 90 gramas de NaCl por litro", "d) 0,09 gramas de NaCl por litro", "e) 0,9 gramas de NaCl por 100 mL de solução", "f) 9 miligramas de NaCl por litro"), "e"),
            Question(41, "A concentração percentual peso/volume (p/v) expressa:",
                listOf("a) Volume de soluto em 100g de solução", "b) Moles de soluto por litro de solução", "c) Mililitros de solvente por grama de soluto", "d) Peso total da embalagem", "e) Volume total a ser administrado", "f) Gramas de soluto em 100 mL de solução"), "f"),
            Question(42, "A reconstituição de medicamentos liofilizados consiste em:",
                listOf("a) Triturar o comprimido até virar pó fino", "b) Aquecer o medicamento em banho-maria", "c) Adicionar o diluente apropriado ao pó para obter solução ou suspensão", "d) Congelar a solução preparada", "e) Filtrar o líquido antes do uso", "f) Evaporar o solvente restante"), "c"),
            Question(43, "A diluição seriada realiza:",
                listOf("a) Uma única diluição directa com grande volume de solvente", "b) Concentração progressiva da solução original", "c) Evaporação controlada do solvente", "d) Diluições sucessivas a partir de uma solução-mãe", "e) Filtração do soluto em série", "f) Cristalização repetida"), "d"),
            Question(44, "A concentração em UI/mL (Unidades Internacionais) é utilizada para:",
                listOf("a) Medicamentos sólidos orais como comprimidos", "b) Água destilada e soluções simples", "c) Pomadas dermatológicas", "d) Comprimidos revestidos", "e) Fármacos biológicos como insulina, heparina e algumas vitaminas", "f) Soro fisiológico comum"), "e"),

            // ── CONDIÇÕES DE ARMAZENAMENTO (45-48) ──
            Question(45, "A câmara fria farmacêutica deve manter temperatura entre:",
                listOf("a) 15°C e 30°C", "b) -20°C e 0°C", "c) 30°C e 40°C", "d) 2°C e 8°C", "e) 8°C e 15°C", "f) 0°C e 2°C"), "d"),
            Question(46, "Medicamentos que devem ser armazenados em congelador requerem temperatura de:",
                listOf("a) 2°C a 8°C", "b) 15°C a 30°C", "c) -25°C a -10°C", "d) 0°C a 5°C", "e) 8°C a 15°C", "f) -5°C a 0°C"), "c"),
            Question(47, "Os medicamentos devem ficar afastados do chão pelo menos:",
                listOf("a) 50 centímetros", "b) 1 metro", "c) Não é necessário afastar", "d) 5 centímetros", "e) 10 centímetros acima do solo", "f) 2 metros"), "e"),
            Question(48, "A monitorização da temperatura no armazém farmacêutico deve ser feita:",
                listOf("a) Uma vez por ano", "b) Apenas quando há reclamação", "c) Nunca, não é necessário", "d) Diariamente com registo em mapa de temperatura", "e) Apenas durante o verão", "f) Somente em câmaras frias"), "d"),

            // ── FARMÁCIA HOSPITALAR E ACTIVIDADES (49-53) ──
            Question(49, "O objectivo principal da farmácia hospitalar é:",
                listOf("a) Vender medicamentos ao público em geral", "b) Fabricar todos os medicamentos do hospital", "c) Realizar cirurgias em pacientes internados", "d) Diagnosticar doenças dos pacientes", "e) Garantir o uso racional, seguro e eficaz dos medicamentos na instituição", "f) Substituir as funções do médico"), "e"),
            Question(50, "A manipulação de nutrição parenteral na farmácia deve ser feita em:",
                listOf("a) Ambiente comum sem precauções especiais", "b) Condições assépticas rigorosas em sala limpa com fluxo laminar", "c) Cozinha do hospital", "d) Enfermaria do paciente", "e) Qualquer bancada disponível", "f) Ao ar livre para ventilação"), "b"),
            Question(51, "A preparação de quimioterapia antineoplásica deve ser realizada:",
                listOf("a) Em bancada aberta comum", "b) Na enfermaria do paciente", "c) Sem protecção especial do manipulador", "d) Ao ar livre para diluir vapores", "e) Na cozinha do hospital", "f) Em câmara de fluxo laminar vertical com EPIs adequados"), "f"),
            Question(52, "A selecção de medicamentos para o formulário terapêutico baseia-se em:",
                listOf("a) Preferência pessoal do fabricante", "b) Cor e design da embalagem", "c) Publicidade nos meios de comunicação", "d) Eficácia comprovada, segurança, qualidade e custo-efectividade", "e) Opinião dos visitantes médicos apenas", "f) Nome comercial mais conhecido"), "d"),
            Question(53, "A conciliação medicamentosa hospitalar é realizada para:",
                listOf("a) Vender mais medicamentos ao paciente", "b) Substituir completamente a função do médico", "c) Eliminar toda a medicação do paciente", "d) Aumentar indiscriminadamente o número de prescrições", "e) Diagnosticar novas doenças", "f) Comparar e verificar os medicamentos do paciente em diferentes momentos da assistência"), "f"),

            // ── USO COMBINADO DE MEDICAMENTOS (54-57) ──
            Question(54, "O sinergismo terapêutico no uso combinado de medicamentos significa que:",
                listOf("a) Os fármacos anulam-se mutuamente", "b) Não há qualquer interacção entre eles", "c) O efeito combinado é superior à soma dos efeitos individuais", "d) Ambos perdem completamente a eficácia", "e) Apenas um fármaco funciona e o outro é inerte", "f) Surge toxicidade obrigatória em todos os casos"), "c"),
            Question(55, "Uma desvantagem importante do uso combinado de medicamentos é:",
                listOf("a) Maior eficácia garantida em todos os casos", "b) Menor custo do tratamento sempre", "c) Simplificação do esquema terapêutico", "d) Aumento significativo do risco de interacções medicamentosas adversas", "e) Eliminação de todos os efeitos adversos", "f) Cura imediata de qualquer doença"), "d"),
            Question(56, "A associação de antibióticos é clinicamente importante para:",
                listOf("a) Aumentar desnecessariamente o custo do tratamento", "b) Reduzir a eficácia antimicrobiana", "c) Eliminar a necessidade de diagnóstico laboratorial", "d) Substituir completamente as vacinas", "e) Prevenir o desenvolvimento de resistência microbiana em infecções graves", "f) Causar mais efeitos adversos intencionalmente"), "e"),
            Question(57, "A dose fixa combinada (DFC) visa principalmente:",
                listOf("a) Aumentar o número de comprimidos diários", "b) Dificultar a adesão ao tratamento", "c) Melhorar a adesão ao tratamento reduzindo o número de comprimidos diários", "d) Aumentar o custo para o paciente", "e) Eliminar a necessidade de acompanhamento médico", "f) Substituir completamente a consulta médica"), "c"),

            // ── GESTÃO DE STOCKS (58-65) ──
            Question(58, "O stock mínimo (stock de segurança) é calculado como:",
                listOf("a) Consumo anual dividido por 12 meses", "b) Stock máximo menos 10% do valor total", "c) CMM (Consumo Médio Mensal) multiplicado pelo tempo de ressuprimento", "d) Total de itens dividido pelo número de funcionários", "e) Valor financeiro total do stock", "f) Número de pacientes atendidos por dia"), "c"),
            Question(59, "Na classificação ABC, os itens da classe A representam tipicamente:",
                listOf("a) 50% dos itens e 5% do valor financeiro", "b) 80% dos itens e 20% do valor", "c) 30% dos itens e 15% do valor", "d) 10% dos itens e 10% do valor", "e) 100% dos itens do stock", "f) 20% dos itens e cerca de 80% do valor financeiro"), "f"),
            Question(60, "A rotura de stock na farmácia hospitalar pode resultar directamente em:",
                listOf("a) Melhoria do atendimento ao paciente", "b) Redução dos custos operacionais", "c) Interrupção de tratamentos essenciais e risco grave ao paciente", "d) Aumento da qualidade assistencial", "e) Maior satisfação dos profissionais de saúde", "f) Nenhuma consequência clínica relevante"), "c"),
            Question(61, "O índice de rotatividade do stock é calculado pela fórmula:",
                listOf("a) Stock máximo dividido pelo stock mínimo", "b) Valor total dividido pelo número de itens", "c) Número de funcionários por item em stock", "d) Validade média de todos os produtos", "e) Consumo total do período dividido pelo stock médio do mesmo período", "f) Custo unitário multiplicado pela quantidade"), "e"),
            Question(62, "Os itens da classe C na classificação ABC representam tipicamente:",
                listOf("a) 20% dos itens e 80% do valor financeiro", "b) 30% dos itens e 50% do valor", "c) 50% dos itens e apenas cerca de 5% do valor financeiro", "d) 10% dos itens e 90% do valor", "e) 100% de todos os itens", "f) 5% dos itens e 50% do valor"), "c"),
            Question(63, "Uma causa frequente de rotura de stock é:",
                listOf("a) Excesso de compras programadas", "b) Stock máximo demasiado elevado", "c) Planeamento inadequado e subestimação do consumo real", "d) Excesso de funcionários na farmácia", "e) Validade muito longa dos produtos", "f) Preço muito baixo dos medicamentos"), "c"),
            Question(64, "O ponto de pedido (ponto de encomenda) é o nível de stock que:",
                listOf("a) Indica que o stock está completamente cheio", "b) Significa que todos os medicamentos foram dispensados", "c) Indica que os medicamentos venceram", "d) Desencadeia um novo processo de aquisição antes de atingir o stock mínimo", "e) Representa o lucro máximo da farmácia", "f) Exige o descarte total dos produtos"), "d"),
            Question(65, "O stock máximo é calculado como:",
                listOf("a) CMM dividido por 2", "b) Validade multiplicada pelo preço unitário", "c) Número de pacientes por dia multiplicado pela dose", "d) Consumo semanal menos 10% de margem", "e) Total de fornecedores registados", "f) Stock mínimo acrescido do lote de compra (quantidade de reposição)"), "f"),

            // ── SISTEMA DE ESTOCAGEM (66-69) ──
            Question(66, "Na organização alfabética, os medicamentos são dispostos por:",
                listOf("a) Forma farmacêutica e via de administração", "b) Cor da embalagem e tamanho", "c) Preço de aquisição", "d) Data de compra ao fornecedor", "e) Fabricante ou distribuidor", "f) Ordem alfabética do nome genérico (DCI)"), "f"),
            Question(67, "O armário de segurança na farmácia é utilizado exclusivamente para:",
                listOf("a) Qualquer tipo de medicamento disponível", "b) Material de limpeza e higiene", "c) Equipamentos electrónicos do hospital", "d) Medicamentos controlados (psicotrópicos, entorpecentes) e de alto custo", "e) Alimentos e suplementos nutricionais", "f) Documentos administrativos apenas"), "d"),
            Question(68, "Medicamentos look-alike e sound-alike são perigosos porque:",
                listOf("a) Possuem exactamente o mesmo princípio activo", "b) São sempre medicamentos genéricos seguros", "c) Possuem nomes ou embalagens semelhantes, podendo causar erros de dispensação", "d) São idênticos em composição e dose", "e) Não representam qualquer risco", "f) São sempre mais eficazes"), "c"),
            Question(69, "A verificação de lotes na recepção de medicamentos inclui:",
                listOf("a) Apenas contar rapidamente as caixas recebidas", "b) Somente verificar o preço na factura", "c) Apenas observar a cor da embalagem exterior", "d) O peso total da encomenda apenas", "e) Quantidade, qualidade, validade, integridade e conformidade com o pedido", "f) A marca comercial e logótipo apenas"), "e"),

            // ── USO RACIONAL DE MEDICAMENTOS (70-73) ──
            Question(70, "Segundo a OMS, o uso racional ocorre quando o paciente recebe:",
                listOf("a) Qualquer medicamento que esteja disponível no momento", "b) O medicamento mais caro do mercado", "c) Vários medicamentos simultaneamente sem critério", "d) Apenas medicamentos naturais e fitoterápicos", "e) Medicamentos sem necessidade de prescrição", "f) Medicamentos apropriados, em doses adequadas, pelo período correcto e ao menor custo"), "f"),
            Question(71, "A automedicação inadequada pode causar:",
                listOf("a) Cura mais rápida de todas as doenças", "b) Melhoria constante da saúde pública", "c) Reacções adversas graves, resistência antimicrobiana e intoxicações", "d) Economia significativa para o sistema de saúde", "e) Eliminação completa de doenças crónicas", "f) Aumento da imunidade natural"), "c"),
            Question(72, "O papel do farmacêutico no uso racional de medicamentos inclui:",
                listOf("a) Apenas vender e entregar medicamentos ao público", "b) Diagnosticar doenças e prescrever tratamentos", "c) Análise crítica de prescrições, orientação ao paciente e identificação de problemas", "d) Realizar cirurgias quando necessário", "e) Fabricar equipamentos médicos", "f) Prescrever medicamentos de forma autónoma"), "c"),
            Question(73, "A polimedicação é especialmente preocupante em pacientes:",
                listOf("a) Jovens adultos saudáveis sem patologias", "b) Atletas profissionais em competição", "c) Idosos, pelo risco acrescido de interacções e efeitos adversos", "d) Apenas gestantes no primeiro trimestre", "e) Crianças saudáveis em idade escolar", "f) Nenhum grupo específico da população"), "c"),

            // ── FARMACOVIGILÂNCIA (74-79) ──
            Question(74, "A farmacovigilância é definida pela OMS como:",
                listOf("a) Vigilância e fiscalização de farmácias comunitárias", "b) Controlo exclusivo de preços de medicamentos", "c) Fiscalização de receitas médicas pelo governo", "d) Contagem e controlo de stock de medicamentos", "e) Ciência de detecção, avaliação, compreensão e prevenção de efeitos adversos", "f) Venda e comercialização de medicamentos"), "e"),
            Question(75, "As reacções adversas do tipo A são caracterizadas por serem:",
                listOf("a) Imprevisíveis, raras e sem relação com a dose", "b) Sempre fatais e irreversíveis", "c) Previsíveis, dose-dependentes e relacionadas à acção farmacológica conhecida", "d) Exclusivamente de natureza alérgica", "e) Inexistentes na prática clínica", "f) Observadas apenas em crianças"), "c"),
            Question(76, "A notificação de reacções adversas a medicamentos é responsabilidade de:",
                listOf("a) Apenas e exclusivamente do médico prescritor", "b) Apenas do paciente ou familiar", "c) Do fabricante do medicamento apenas", "d) Todos os profissionais de saúde que detectem a reacção", "e) Da polícia sanitária", "f) De ninguém em particular"), "d"),
            Question(77, "As reacções adversas do tipo B são:",
                listOf("a) Dose-dependentes, previsíveis e comuns", "b) Relacionadas apenas ao uso crónico prolongado", "c) Sempre de gravidade leve sem consequências", "d) Imprevisíveis, não dose-dependentes, frequentemente de natureza alérgica ou idiossincrásica", "e) Exclusivamente de manifestação hepática", "f) Observadas apenas em homens adultos"), "d"),
            Question(78, "As reacções adversas do tipo C estão relacionadas a:",
                listOf("a) Dose única acidental do medicamento", "b) Alergia imediata ao primeiro contacto", "c) Uso prolongado e contínuo do medicamento ao longo do tempo", "d) Contaminação do medicamento na fábrica", "e) Erro de prescrição por troca de nomes", "f) Overdose acidental aguda"), "c"),
            Question(79, "O farmacêutico na farmacovigilância institucional tem como função:",
                listOf("a) Apenas arquivar documentos no armário", "b) Vender medicamentos ao balcão", "c) Fazer diagnósticos clínicos", "d) Coordenar notificações de RAM e propor medidas preventivas na instituição", "e) Realizar cirurgias de emergência", "f) Prescrever medicamentos alternativos"), "d"),

            // ── INFECÇÕES HOSPITALARES (80-82) ──
            Question(80, "As infecções hospitalares (nosocomiais) são aquelas adquiridas:",
                listOf("a) Antes da admissão hospitalar, na comunidade", "b) Apenas em ambiente domiciliário", "c) Durante a permanência no hospital, não presentes ou em incubação na admissão", "d) Exclusivamente por via aérea no exterior", "e) Apenas por contacto sexual", "f) Somente durante a infância"), "c"),
            Question(81, "O controlo de germicidas na farmácia hospitalar inclui:",
                listOf("a) Apenas a compra de qualquer desinfectante disponível", "b) Selecção criteriosa, padronização e controlo de qualidade dos desinfectantes e anti-sépticos", "c) Venda de produtos de limpeza ao público", "d) Apenas o armazenamento sem verificação de qualidade", "e) Descarte imediato de todos os produtos químicos", "f) Uso doméstico livre sem padronização"), "b"),
            Question(82, "O programa de antimicrobial stewardship visa:",
                listOf("a) Aumentar indiscriminadamente o uso de antibióticos", "b) Eliminar completamente todos os antimicrobianos do hospital", "c) Optimizar o uso de antimicrobianos e minimizar o desenvolvimento de resistência", "d) Substituir todos os antibióticos por vitaminas", "e) Reduzir o número de médicos infectologistas", "f) Aumentar as infecções para justificar recursos"), "c"),

            // ── REQUISITOS PARA FARMÁCIA HOSPITALAR (83-85) ──
            Question(83, "A farmácia hospitalar deve possuir como documento legal essencial:",
                listOf("a) Apenas registo comercial (CNPJ/NIF)", "b) Licença de condução do responsável", "c) Registo desportivo da instituição", "d) Alvará de funcionamento emitido pela autoridade sanitária competente", "e) Passaporte do director técnico", "f) Cartão de crédito institucional"), "d"),
            Question(84, "Os Procedimentos Operacionais Padrão (POPs) na farmácia devem ser:",
                listOf("a) Escritos uma única vez e nunca mais revisados", "b) Guardados em local secreto sem acesso dos funcionários", "c) Apenas transmitidos verbalmente entre colegas", "d) Exclusivos e confidenciais do director técnico", "e) Elaborados, implementados, divulgados e periodicamente revisados", "f) Facultativos e sem obrigação legal"), "e"),
            Question(85, "O farmacêutico responsável técnico deve possuir:",
                listOf("a) Apenas experiência prática sem formação académica", "b) Diploma em qualquer área da saúde", "c) Inscrição activa no conselho profissional de farmácia e habilitação específica", "d) Apenas curso técnico de enfermagem", "e) Formação em administração empresarial", "f) Licença de comércio geral"), "c"),

            // ── INTERACÇÕES MEDICAMENTOSAS (86-91) ──
            Question(86, "As interacções farmacocinéticas alteram processos como:",
                listOf("a) Apenas o sabor e aspecto do medicamento", "b) A cor do comprimido e formato da cápsula", "c) A absorção, distribuição, metabolismo ou excreção do fármaco no organismo", "d) O nome comercial do medicamento", "e) A embalagem e rotulagem", "f) O preço no mercado farmacêutico"), "c"),
            Question(87, "As interacções farmacodinâmicas modificam:",
                listOf("a) A velocidade de dissolução do comprimido", "b) O efeito do fármaco no seu local ou mecanismo de acção", "c) O formato e tamanho do comprimido", "d) O preço do medicamento na farmácia", "e) A data de validade impressa", "f) A concentração plasmática por alteração do metabolismo"), "b"),
            Question(88, "Incompatibilidades farmacêuticas ocorrem:",
                listOf("a) Dentro do organismo do paciente após a absorção", "b) Apenas após 24 horas da administração ao paciente", "c) Exclusivamente em comprimidos orais de libertação imediata", "d) Antes da administração, durante a mistura ou preparação de medicamentos (especialmente IV)", "e) Apenas em crianças pequenas", "f) Nunca na prática farmacêutica"), "d"),
            Question(89, "A interacção entre varfarina e vitamina K é do tipo:",
                listOf("a) Sinérgica com potenciação do efeito anticoagulante", "b) Sem qualquer efeito clínico relevante", "c) Potencializadora da acção de ambos", "d) Alérgica de hipersensibilidade imediata", "e) Antagónica, pois a vitamina K reduz o efeito anticoagulante da varfarina", "f) Física por precipitação"), "e"),
            Question(90, "A indução enzimática do citocromo P450 resulta em:",
                listOf("a) Menor metabolismo e acumulação do fármaco", "b) Maior metabolismo hepático e possível redução da eficácia terapêutica", "c) Eliminação renal directamente aumentada", "d) Absorção intestinal dramaticamente aumentada", "e) Nenhum efeito mensurável no organismo", "f) Mudança da cor da urina apenas"), "b"),
            Question(91, "As interacções medicamentosas classificadas como graves devem ser:",
                listOf("a) Completamente ignoradas na prática clínica", "b) Incentivadas para potenciar o tratamento", "c) Mantidas sem qualquer alteração no esquema", "d) Repetidas sistematicamente em todos os pacientes", "e) Apenas registadas no prontuário sem acção", "f) Evitadas ou cuidadosamente monitorizadas, pois representam risco de vida"), "f"),

            // ── COMISSÃO DE FARMÁCIA E TERAPÊUTICA (92-95) ──
            Question(92, "A Comissão de Farmácia e Terapêutica (CFT) é um órgão:",
                listOf("a) Apenas administrativo sem função técnica", "b) Exclusivamente composto por médicos", "c) De fiscalização policial e judicial", "d) Consultivo e deliberativo, de carácter multidisciplinar", "e) De marketing e publicidade do hospital", "f) Apenas financeiro e orçamental"), "d"),
            Question(93, "A principal actividade da CFT é:",
                listOf("a) Contratação e gestão de pessoal administrativo", "b) Elaboração, actualização e supervisão do Formulário Terapêutico da instituição", "c) Construção e manutenção das instalações do hospital", "d) Gestão financeira geral da instituição", "e) Compra de equipamentos médicos e cirúrgicos", "f) Decoração e ambientação do hospital"), "b"),
            Question(94, "O farmacêutico na CFT contribui com conhecimento especializado em:",
                listOf("a) Arquitectura e engenharia hospitalar", "b) Direito penal e legislação criminal", "c) Gastronomia e nutrição culinária", "d) Design gráfico e comunicação visual", "e) Farmacologia, farmacoterapia, farmacovigilância e farmacoeconómica", "f) Engenharia civil e construção"), "e"),
            Question(95, "A análise de custo-efectividade na CFT é utilizada para:",
                listOf("a) Decorar as instalações do hospital", "b) Comparar alternativas terapêuticas quanto à eficácia clínica e custo associado", "c) Calcular salários dos funcionários", "d) Definir horários de trabalho dos profissionais", "e) Comprar mobiliário para a farmácia", "f) Planear férias da equipa de saúde"), "b")
        )
    }
}
