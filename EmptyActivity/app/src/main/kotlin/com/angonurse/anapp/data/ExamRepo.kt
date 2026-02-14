package com.angonurse.anapp.data

/**
 * Repositório centralizado para as perguntas do exame.
 * Facilita a expansão futura — basta adicionar novas questões à lista.
 */
object ExamRepo {

    const val EXAM_DURATION_MINUTES = 60

    val questions: List<Question> by lazy {
        val base = listOf(
            Question(1, "Qual é a capital do Brasil?",
                listOf("a) São Paulo", "b) Rio de Janeiro", "c) Brasília", "d) Salvador", "e) Belo Horizonte", "f) Curitiba"), "c"),
            Question(2, "Quem escreveu 'Dom Casmurro'?",
                listOf("a) José de Alencar", "b) Machado de Assis", "c) Jorge Amado", "d) Clarice Lispector", "e) Carlos Drummond", "f) Cecília Meireles"), "b"),
            Question(3, "Quanto é 15 + 27?",
                listOf("a) 40", "b) 41", "c) 42", "d) 43", "e) 44", "f) 45"), "c"),
            Question(4, "Qual é o maior planeta do sistema solar?",
                listOf("a) Terra", "b) Marte", "c) Júpiter", "d) Saturno", "e) Netuno", "f) Urano"), "c"),
            Question(5, "Em que ano ocorreu a Proclamação da República no Brasil?",
                listOf("a) 1822", "b) 1888", "c) 1889", "d) 1891", "e) 1900", "f) 1808"), "c")
        )

        val letters = listOf("a", "b", "c", "d", "e", "f")
        val generated = (6..95).map { i ->
            val correctIdx = (i * 7 + 3) % 6
            Question(
                id = i,
                question = "Questão $i: Escolha a alternativa correta para esta pergunta de múltipla escolha.",
                options = listOf(
                    "a) Opção A da questão $i",
                    "b) Opção B da questão $i",
                    "c) Opção C da questão $i",
                    "d) Opção D da questão $i",
                    "e) Opção E da questão $i",
                    "f) Opção F da questão $i"
                ),
                correctAnswer = letters[correctIdx]
            )
        }
        base + generated
    }
}
