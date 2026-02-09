import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { getResultHistory, clearHistory, ResultRecord } from "@/lib/resultHistory";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { ArrowLeft, Trash2, Trophy, Clock, User, CheckCircle2, XCircle } from "lucide-react";
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

const Historico = () => {
  const navigate = useNavigate();
  const [history, setHistory] = useState<ResultRecord[]>(getResultHistory());
  const [showClearDialog, setShowClearDialog] = useState(false);

  const handleClear = () => {
    clearHistory();
    setHistory([]);
    setShowClearDialog(false);
  };

  const formatDate = (iso: string) => {
    const d = new Date(iso);
    return d.toLocaleDateString("pt-BR", {
      day: "2-digit",
      month: "2-digit",
      year: "numeric",
      hour: "2-digit",
      minute: "2-digit",
    });
  };

  const getScoreColor = (pct: string) => {
    const n = parseFloat(pct);
    if (n >= 80) return "text-success";
    if (n >= 50) return "text-warning";
    return "text-destructive";
  };

  const getScoreIcon = (pct: string) => {
    const n = parseFloat(pct);
    if (n >= 50) return <CheckCircle2 className="w-7 h-7 text-success" />;
    return <XCircle className="w-7 h-7 text-destructive" />;
  };

  return (
    <div className="min-h-screen bg-background py-8 px-4">
      <div className="max-w-3xl mx-auto space-y-6">
        {/* Header */}
        <div className="flex items-center justify-between">
          <Button variant="ghost" onClick={() => navigate("/")}>
            <ArrowLeft className="w-5 h-5 mr-2" />
            Voltar
          </Button>
          {history.length > 0 && (
            <Button
              variant="outline"
              size="sm"
              className="border-destructive text-destructive hover:bg-destructive hover:text-destructive-foreground"
              onClick={() => setShowClearDialog(true)}
            >
              <Trash2 className="w-4 h-4 mr-2" />
              Limpar Histórico
            </Button>
          )}
        </div>

        <div className="text-center space-y-2">
          <h1 className="text-3xl font-bold">Histórico de Resultados</h1>
          <p className="text-muted-foreground">
            {history.length === 0
              ? "Nenhum teste realizado ainda."
              : `${history.length} tentativa${history.length > 1 ? "s" : ""} registada${history.length > 1 ? "s" : ""}`}
          </p>
        </div>

        {/* Results List */}
        {history.length === 0 ? (
          <Card className="shadow-elegant">
            <CardContent className="py-12 text-center space-y-4">
              <Trophy className="w-16 h-16 mx-auto text-muted-foreground/40" />
              <p className="text-lg text-muted-foreground">
                Complete um teste para ver o seu histórico aqui.
              </p>
              <Button onClick={() => navigate("/")}>Ir para o Teste</Button>
            </CardContent>
          </Card>
        ) : (
          <div className="space-y-3">
            {history.map((record, index) => (
              <Card key={record.id} className="shadow-md hover:shadow-lg transition-shadow">
                <CardContent className="py-4 px-5">
                  <div className="flex items-center justify-between gap-4">
                    <div className="flex items-center gap-4 flex-1 min-w-0">
                      <div className="flex items-center justify-center w-10 h-10 rounded-full bg-muted text-sm font-bold shrink-0">
                        {history.length - index}
                      </div>
                      <div className="min-w-0 space-y-1">
                        <div className="flex items-center gap-2">
                          <User className="w-4 h-4 text-muted-foreground shrink-0" />
                          <span className="font-semibold truncate">{record.participantName}</span>
                        </div>
                        <div className="flex items-center gap-2 text-sm text-muted-foreground">
                          <Clock className="w-3.5 h-3.5 shrink-0" />
                          <span>{formatDate(record.date)}</span>
                        </div>
                      </div>
                    </div>
                    <div className="text-right shrink-0">
                      <span className="mr-1">{getScoreIcon(record.percentage)}</span>
                       <span className={`text-2xl font-bold ${getScoreColor(record.percentage)}`}>
                         {record.percentage}%
                      </span>
                      <p className="text-xs text-muted-foreground">
                        {record.correctCount}/{record.totalQuestions}
                      </p>
                    </div>
                  </div>
                </CardContent>
              </Card>
            ))}
          </div>
        )}
      </div>

      {/* Clear Confirmation */}
      <AlertDialog open={showClearDialog} onOpenChange={setShowClearDialog}>
        <AlertDialogContent>
          <AlertDialogHeader>
            <AlertDialogTitle>Limpar Histórico?</AlertDialogTitle>
            <AlertDialogDescription>
              Esta acção irá apagar todos os registos de resultados. Não é possível desfazer.
            </AlertDialogDescription>
          </AlertDialogHeader>
          <AlertDialogFooter>
            <AlertDialogCancel>Cancelar</AlertDialogCancel>
            <AlertDialogAction onClick={handleClear}>Apagar Tudo</AlertDialogAction>
          </AlertDialogFooter>
        </AlertDialogContent>
      </AlertDialog>
    </div>
  );
};

export default Historico;
