import { useState } from "react";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { ExamQuiz } from "@/components/ExamQuiz";
import { CORRECT_ACCESS_CODE } from "@/data/questions";
import { Lock, CreditCard, CheckCircle2 } from "lucide-react";
import { useToast } from "@/hooks/use-toast";
import heroImage from "@/assets/hero-exam.jpg";

const Index = () => {
  const [accessCode, setAccessCode] = useState("");
  const [hasAccess, setHasAccess] = useState(false);
  const { toast } = useToast();

  const handleAccessSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    
    if (accessCode === CORRECT_ACCESS_CODE) {
      setHasAccess(true);
      toast({
        title: "Acesso concedido!",
        description: "Você pode iniciar o teste agora.",
      });
    } else {
      toast({
        title: "Código inválido",
        description: "Por favor, verifique o código e tente novamente.",
        variant: "destructive",
      });
    }
  };


  if (hasAccess) {
    return <ExamQuiz />;
  }

  return (
    <div className="min-h-screen relative overflow-hidden">
      {/* Hero Background */}
      <div className="absolute inset-0 z-0 overflow-hidden">
        <img
          src={heroImage}
          alt="Plataforma de testes online"
          className="w-full h-full object-cover object-center"
        />
        <div className="absolute inset-0 bg-gradient-to-br from-background/95 via-background/90 to-background/95" />
      </div>

      {/* Content */}
      <div className="relative z-10 flex min-h-screen items-center justify-center px-4 py-12">
        <div className="w-full max-w-md space-y-8">
          {/* Logo/Title */}
          <div className="text-center space-y-2">
            <h1 className="text-5xl font-bold bg-gradient-primary bg-clip-text text-transparent">
              Teste Online
            </h1>
            <p className="text-lg text-muted-foreground">
              Plataforma Profissional de Avaliação
            </p>
          </div>

          {/* Access Card */}
          <Card className="shadow-elegant border-2">
            <CardHeader className="space-y-1">
              <CardTitle className="text-2xl flex items-center gap-2">
                <Lock className="w-6 h-6" />
                Acesso ao Teste
              </CardTitle>
              <CardDescription>
                Digite seu código de acesso para iniciar a prova
              </CardDescription>
            </CardHeader>
            <CardContent className="space-y-6">
              <form onSubmit={handleAccessSubmit} className="space-y-4">
                <div className="space-y-2">
                  <Label htmlFor="access-code">Código de Acesso</Label>
                  <Input
                    id="access-code"
                    type="text"
                    placeholder="Digite o código"
                    value={accessCode}
                    onChange={(e) => setAccessCode(e.target.value)}
                    className="text-center text-lg font-mono tracking-wider"
                    maxLength={8}
                  />
                </div>
                <Button type="submit" className="w-full bg-gradient-primary" size="lg">
                  <CheckCircle2 className="w-5 h-5 mr-2" />
                  Iniciar Teste
                </Button>
              </form>

              <div className="relative">
                <div className="absolute inset-0 flex items-center">
                  <span className="w-full border-t" />
                </div>
                <div className="relative flex justify-center text-xs uppercase">
                  <span className="bg-card px-2 text-muted-foreground">
                    Ainda não tem acesso?
                  </span>
                </div>
              </div>

              <Button
                asChild
                variant="outline"
                className="w-full"
                size="lg"
              >
                <a href="#">
                  <CreditCard className="w-5 h-5 mr-2" />
                  Pagar Acesso
                </a>
              </Button>
            </CardContent>
          </Card>

          {/* Info */}
          <Card className="bg-muted/50 border-none">
            <CardContent className="pt-6">
              <ul className="space-y-2 text-sm text-muted-foreground">
                <li className="flex items-start gap-2">
                  <CheckCircle2 className="w-4 h-4 mt-0.5 text-primary" />
                  <span>95 questões de múltipla escolha</span>
                </li>
                <li className="flex items-start gap-2">
                  <CheckCircle2 className="w-4 h-4 mt-0.5 text-primary" />
                  <span>Tempo cronometrado de 2 horas</span>
                </li>
                <li className="flex items-start gap-2">
                  <CheckCircle2 className="w-4 h-4 mt-0.5 text-primary" />
                  <span>Gabarito detalhado ao final</span>
                </li>
              </ul>
            </CardContent>
          </Card>
        </div>
      </div>
    </div>
  );
};

export default Index;
