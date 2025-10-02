import { useState } from "react";
import { questions, EXAM_DURATION_MINUTES } from "@/data/questions";
import { QuestionCard } from "./QuestionCard";
import { Timer } from "./Timer";
import { Results } from "./Results";
import { Button } from "@/components/ui/button";
import { ChevronLeft, ChevronRight, Send } from "lucide-react";
import { useToast } from "@/hooks/use-toast";
import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
} from "@/components/ui/alert-dialog";

export const ExamQuiz = () => {
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [userAnswers, setUserAnswers] = useState<Record<number, string>>({});
  const [showResults, setShowResults] = useState(false);
  const [showSubmitDialog, setShowSubmitDialog] = useState(false);
  const { toast } = useToast();

  const currentQuestion = questions[currentQuestionIndex];
  const isLastQuestion = currentQuestionIndex === questions.length - 1;
  const isFirstQuestion = currentQuestionIndex === 0;

  const handleAnswerChange = (answer: string) => {
    setUserAnswers((prev) => ({
      ...prev,
      [currentQuestion.id]: answer,
    }));
  };

  const handleNext = () => {
    if (currentQuestionIndex < questions.length - 1) {
      setCurrentQuestionIndex((prev) => prev + 1);
    }
  };

  const handlePrevious = () => {
    if (currentQuestionIndex > 0) {
      setCurrentQuestionIndex((prev) => prev - 1);
    }
  };

  const handleSubmit = () => {
    const unansweredCount = questions.length - Object.keys(userAnswers).length;
    if (unansweredCount > 0) {
      setShowSubmitDialog(true);
    } else {
      finishExam();
    }
  };

  const finishExam = () => {
    setShowResults(true);
    setShowSubmitDialog(false);
  };

  const handleTimeUp = () => {
    toast({
      title: "Tempo esgotado!",
      description: "O teste foi finalizado automaticamente.",
      variant: "destructive",
    });
    setShowResults(true);
  };

  const handleRestart = () => {
    setCurrentQuestionIndex(0);
    setUserAnswers({});
    setShowResults(false);
  };

  if (showResults) {
    return <Results questions={questions} userAnswers={userAnswers} onRestart={handleRestart} />;
  }

  const answeredCount = Object.keys(userAnswers).length;
  const progress = ((answeredCount / questions.length) * 100).toFixed(0);

  return (
    <div className="min-h-screen bg-background">
      {/* Header with Timer */}
      <div className="sticky top-0 z-10 bg-card shadow-md border-b">
        <div className="max-w-7xl mx-auto px-4 py-4 flex items-center justify-between">
          <div className="space-y-1">
            <h1 className="text-xl font-bold">Teste Online</h1>
            <p className="text-sm text-muted-foreground">
              {answeredCount} de {questions.length} respondidas ({progress}%)
            </p>
          </div>
          <Timer duration={EXAM_DURATION_MINUTES} onTimeUp={handleTimeUp} />
        </div>
        <div className="h-1 bg-muted">
          <div
            className="h-full bg-gradient-primary transition-all duration-300"
            style={{ width: `${progress}%` }}
          />
        </div>
      </div>

      {/* Question Content */}
      <div className="max-w-4xl mx-auto px-4 py-8">
        <QuestionCard
          question={currentQuestion}
          selectedAnswer={userAnswers[currentQuestion.id] || ""}
          onAnswerChange={handleAnswerChange}
          questionNumber={currentQuestionIndex + 1}
          totalQuestions={questions.length}
        />

        {/* Navigation */}
        <div className="mt-6 flex justify-between items-center gap-4">
          <Button
            onClick={handlePrevious}
            disabled={isFirstQuestion}
            variant="outline"
            size="lg"
          >
            <ChevronLeft className="w-4 h-4 mr-2" />
            Anterior
          </Button>

          {isLastQuestion ? (
            <Button onClick={handleSubmit} size="lg" className="bg-gradient-primary">
              <Send className="w-4 h-4 mr-2" />
              Finalizar Teste
            </Button>
          ) : (
            <Button onClick={handleNext} size="lg">
              Próxima
              <ChevronRight className="w-4 h-4 ml-2" />
            </Button>
          )}
        </div>

        {/* Question Navigation Grid */}
        <div className="mt-8 p-6 bg-card rounded-lg shadow-md">
          <h3 className="text-lg font-semibold mb-4">Navegação Rápida</h3>
          <div className="grid grid-cols-10 gap-2">
            {questions.map((q, index) => {
              const isAnswered = userAnswers[q.id];
              const isCurrent = index === currentQuestionIndex;
              return (
                <button
                  key={q.id}
                  onClick={() => setCurrentQuestionIndex(index)}
                  className={`
                    aspect-square rounded-md text-sm font-medium transition-all
                    ${isCurrent ? "ring-2 ring-primary scale-110" : ""}
                    ${
                      isAnswered
                        ? "bg-primary text-primary-foreground"
                        : "bg-muted text-muted-foreground hover:bg-muted/70"
                    }
                  `}
                >
                  {index + 1}
                </button>
              );
            })}
          </div>
        </div>
      </div>

      {/* Submit Confirmation Dialog */}
      <AlertDialog open={showSubmitDialog} onOpenChange={setShowSubmitDialog}>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>Finalizar Teste?</AlertDialogTitle>
            <AlertDialogDescription>
              Você ainda tem {questions.length - Object.keys(userAnswers).length} questões não
              respondidas. Deseja realmente finalizar o teste?
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>Continuar Respondendo</AlertDialogCancel>
            <AlertDialogAction onClick={finishExam}>Finalizar Mesmo Assim</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </div>
  );
};
