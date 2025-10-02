import { Question } from "@/data/questions";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Label } from "@/components/ui/label";
import { RadioGroup, RadioGroupItem } from "@/components/ui/radio-group";

interface QuestionCardProps {
  question: Question;
  selectedAnswer: string;
  onAnswerChange: (value: string) => void;
  questionNumber: number;
  totalQuestions: number;
}

export const QuestionCard = ({
  question,
  selectedAnswer,
  onAnswerChange,
  questionNumber,
  totalQuestions
}: QuestionCardProps) => {
  return (
    <Card className="w-full shadow-elegant">
      <CardHeader>
        <CardTitle className="flex justify-between items-center">
          <span>Questão {questionNumber}</span>
          <span className="text-sm font-normal text-muted-foreground">
            {questionNumber} de {totalQuestions}
          </span>
        </CardTitle>
      </CardHeader>
      <CardContent className="space-y-6">
        <p className="text-lg font-medium">{question.question}</p>
        
        {question.imageUrl && (
          <div className="flex justify-center">
            <img
              src={question.imageUrl}
              alt={`Imagem da questão ${questionNumber}`}
              className="max-w-full h-auto rounded-lg shadow-md"
            />
          </div>
        )}

        <RadioGroup value={selectedAnswer} onValueChange={onAnswerChange}>
          <div className="space-y-3">
            {question.options.map((option, index) => {
              const optionLetter = option.charAt(0);
              return (
                <div
                  key={index}
                  className="flex items-center space-x-3 p-3 rounded-lg border hover:bg-muted/50 transition-colors cursor-pointer"
                  onClick={() => onAnswerChange(optionLetter)}
                >
                  <RadioGroupItem value={optionLetter} id={`q${question.id}-${optionLetter}`} />
                  <Label
                    htmlFor={`q${question.id}-${optionLetter}`}
                    className="flex-1 cursor-pointer"
                  >
                    {option}
                  </Label>
                </div>
              );
            })}
          </div>
        </RadioGroup>
      </CardContent>
    </Card>
  );
};
