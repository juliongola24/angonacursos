import { Question } from "@/data/questions";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { CheckCircle2, XCircle } from "lucide-react";

interface ResultsProps {
  questions: Question[];
  userAnswers: Record<number, string>;
  onRestart: () => void;
}

export const Results = ({ questions, userAnswers, onRestart }: ResultsProps) => {
  const correctCount = questions.filter(
    (q) => userAnswers[q.id] === q.correctAnswer
  ).length;
  const percentage = ((correctCount / questions.length) * 100).toFixed(1);

  return (
    <div className="min-h-screen bg-background py-8 px-4">
      <div className="max-w-4xl mx-auto space-y-6">
        <Card className="shadow-elegant">
          <CardHeader>
            <CardTitle className="text-3xl text-center">Resultado do Teste</CardTitle>
          </CardHeader>
          <CardContent className="space-y-6">
            <div className="text-center space-y-2">
              <p className="text-6xl font-bold bg-gradient-primary bg-clip-text text-transparent">
                {percentage}%
              </p>
              <p className="text-xl text-muted-foreground">
                {correctCount} de {questions.length} questões corretas
              </p>
            </div>
            
            <Button onClick={onRestart} className="w-full" size="lg">
              Reiniciar Teste
            </Button>
          </CardContent>
        </Card>

        <div className="space-y-4">
          <h2 className="text-2xl font-bold">Gabarito Detalhado</h2>
          
          {questions.map((question, index) => {
            const userAnswer = userAnswers[question.id];
            const isCorrect = userAnswer === question.correctAnswer;
            
            return (
              <Card key={question.id} className={isCorrect ? "border-success" : "border-destructive"}>
                <CardHeader>
                  <CardTitle className="flex items-center justify-between text-lg">
                    <span>Questão {index + 1}</span>
                    {isCorrect ? (
                      <CheckCircle2 className="w-6 h-6 text-success" />
                    ) : (
                      <XCircle className="w-6 h-6 text-destructive" />
                    )}
                  </CardTitle>
                </CardHeader>
                <CardContent className="space-y-3">
                  <p className="font-medium">{question.question}</p>
                  
                  {question.imageUrl && (
                    <img
                      src={question.imageUrl}
                      alt={`Questão ${index + 1}`}
                      className="max-w-md h-auto rounded-lg"
                    />
                  )}
                  
                  <div className="space-y-2">
                    <p className="text-sm">
                      <span className="font-semibold">Sua resposta: </span>
                      <span className={isCorrect ? "text-success" : "text-destructive"}>
                        {userAnswer ? userAnswer.toUpperCase() : "Não respondida"}
                      </span>
                    </p>
                    {!isCorrect && (
                      <p className="text-sm">
                        <span className="font-semibold">Resposta correta: </span>
                        <span className="text-success">{question.correctAnswer.toUpperCase()}</span>
                      </p>
                    )}
                  </div>
                  
                  <div className="text-sm text-muted-foreground">
                    {question.options.find(opt => opt.startsWith(question.correctAnswer))?.substring(3)}
                  </div>
                </CardContent>
              </Card>
            );
          })}
        </div>
      </div>
    </div>
  );
};
