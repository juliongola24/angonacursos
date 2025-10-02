import { Question } from "@/data/questions";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { CheckCircle2, XCircle, Download } from "lucide-react";
import jsPDF from "jspdf";

interface ResultsProps {
  questions: Question[];
  userAnswers: Record<number, string>;
  onRestart: () => void;
  participantName: string;
}

export const Results = ({ questions, userAnswers, onRestart, participantName }: ResultsProps) => {
  const correctCount = questions.filter(
    (q) => userAnswers[q.id] === q.correctAnswer
  ).length;
  const percentage = ((correctCount / questions.length) * 100).toFixed(1);

  const downloadPDF = () => {
    const pdf = new jsPDF();
    const pageWidth = pdf.internal.pageSize.getWidth();
    const pageHeight = pdf.internal.pageSize.getHeight();
    let yPosition = 20;

    // Cabeçalho
    pdf.setFontSize(16);
    pdf.setFont("helvetica", "bold");
    pdf.text("TESTE ONLINE - GABARITO", pageWidth / 2, yPosition, { align: "center" });
    
    yPosition += 10;
    pdf.setFontSize(10);
    pdf.setFont("helvetica", "normal");
    pdf.text("www.testeonline.com.br", pageWidth / 2, yPosition, { align: "center" });
    
    yPosition += 10;
    pdf.setFontSize(12);
    pdf.setFont("helvetica", "bold");
    pdf.text(`Participante: ${participantName}`, 20, yPosition);
    
    yPosition += 15;
    
    // Resultado
    pdf.setFontSize(14);
    pdf.setFont("helvetica", "bold");
    pdf.text(`Resultado: ${percentage}% (${correctCount}/${questions.length})`, 20, yPosition);
    
    yPosition += 15;

    // Questões
    pdf.setFontSize(10);
    questions.forEach((question, index) => {
      if (yPosition > pageHeight - 30) {
        pdf.addPage();
        yPosition = 20;
      }

      const userAnswer = userAnswers[question.id];
      const isCorrect = userAnswer === question.correctAnswer;
      
      pdf.setFont("helvetica", "bold");
      pdf.text(`${index + 1}. `, 20, yPosition);
      
      pdf.setFont("helvetica", "normal");
      const questionText = pdf.splitTextToSize(question.question, pageWidth - 40);
      pdf.text(questionText, 30, yPosition);
      yPosition += questionText.length * 5;

      pdf.setFont("helvetica", "normal");
      pdf.text(`Sua resposta: ${userAnswer ? userAnswer.toUpperCase() : "Não respondida"}`, 30, yPosition);
      yPosition += 5;
      
      if (!isCorrect) {
        pdf.setFont("helvetica", "bold");
        pdf.text(`Resposta correta: ${question.correctAnswer.toUpperCase()}`, 30, yPosition);
        yPosition += 5;
      }
      
      yPosition += 5;
    });

    pdf.save(`gabarito_${participantName.replace(/\s+/g, '_')}.pdf`);
  };

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
            
            <div className="flex flex-col sm:flex-row gap-3">
              <Button onClick={downloadPDF} variant="outline" className="flex-1" size="lg">
                <Download className="w-5 h-5 mr-2" />
                Baixar Gabarito (PDF)
              </Button>
              <Button onClick={onRestart} className="flex-1" size="lg">
                Reiniciar Teste
              </Button>
            </div>
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
                    <div className="w-full overflow-hidden">
                      <img
                        src={question.imageUrl}
                        alt={`Questão ${index + 1}`}
                        className="w-full max-w-full h-auto object-contain rounded-lg"
                        style={{ maxHeight: '400px' }}
                      />
                    </div>
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
