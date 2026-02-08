export interface Question {
  id: number;
  question: string;
  options: string[];
  correctAnswer: string;
}

export const questions: Question[] = [
  {
    id: 1,
    question: "Qual é a capital do Brasil?",
    options: ["a) São Paulo", "b) Rio de Janeiro", "c) Brasília", "d) Salvador", "e) Belo Horizonte", "f) Curitiba"],
    correctAnswer: "c"
  },
  {
    id: 2,
    question: "Quem escreveu 'Dom Casmurro'?",
    options: ["a) José de Alencar", "b) Machado de Assis", "c) Jorge Amado", "d) Clarice Lispector", "e) Carlos Drummond", "f) Cecília Meireles"],
    correctAnswer: "b"
  },
  {
    id: 3,
    question: "Quanto é 15 + 27?",
    options: ["a) 40", "b) 41", "c) 42", "d) 43", "e) 44", "f) 45"],
    correctAnswer: "c"
  },
  {
    id: 4,
    question: "Qual é o maior planeta do sistema solar?",
    options: ["a) Terra", "b) Marte", "c) Júpiter", "d) Saturno", "e) Netuno", "f) Urano"],
    correctAnswer: "c"
  },
  {
    id: 5,
    question: "Em que ano ocorreu a Proclamação da República no Brasil?",
    options: ["a) 1822", "b) 1888", "c) 1889", "d) 1891", "e) 1900", "f) 1808"],
    correctAnswer: "c"
  },
  // Continue with more questions to reach 95 total
  ...Array.from({ length: 90 }, (_, i) => ({
    id: i + 6,
    question: `Questão ${i + 6}: Escolha a alternativa correta para esta pergunta de múltipla escolha.`,
    options: [
      `a) Opção A da questão ${i + 6}`,
      `b) Opção B da questão ${i + 6}`,
      `c) Opção C da questão ${i + 6}`,
      `d) Opção D da questão ${i + 6}`,
      `e) Opção E da questão ${i + 6}`,
      `f) Opção F da questão ${i + 6}`
    ],
    correctAnswer: ["a", "b", "c", "d", "e", "f"][Math.floor(Math.random() * 6)]
  }))
];

export const CORRECT_ACCESS_CODE = "17202116";
export const EXAM_DURATION_MINUTES = 60;
