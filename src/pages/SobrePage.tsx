import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { ArrowLeft, Info, Code, Target, Users } from "lucide-react";
import { useNavigate } from "react-router-dom";

const SobrePage = () => {
  const navigate = useNavigate();

  return (
    <div className="min-h-screen bg-background">
      <header className="sticky top-0 z-10 bg-card shadow-md border-b">
        <div className="max-w-4xl mx-auto px-4 py-4 flex items-center gap-4">
          <Button variant="ghost" size="icon" onClick={() => navigate("/")}>
            <ArrowLeft className="w-5 h-5" />
          </Button>
          <div className="flex items-center gap-2">
            <Info className="w-5 h-5 text-primary" />
            <h1 className="text-xl font-bold">Saber Mais</h1>
          </div>
        </div>
      </header>

      <main className="max-w-4xl mx-auto px-4 py-8 space-y-6">
        {/* About the App */}
        <Card className="shadow-elegant">
          <CardHeader>
            <CardTitle className="flex items-center gap-2 text-2xl">
              <Target className="w-6 h-6 text-primary" />
              Sobre a Aplicação
            </CardTitle>
          </CardHeader>
          <CardContent className="space-y-4 text-muted-foreground leading-relaxed">
            <p>
              O <strong className="text-foreground">Teste Online</strong> é uma plataforma profissional de avaliação 
              desenvolvida para oferecer uma experiência completa de simulado online.
            </p>
            <p>
              Com 95 questões de múltipla escolha cuidadosamente elaboradas, a plataforma cobre 
              diversas áreas do conhecimento como Geografia, História, Literatura, Matemática, 
              Ciências e Conhecimentos Gerais.
            </p>
            <p>
              Recursos da plataforma:
            </p>
            <ul className="list-disc list-inside space-y-1 ml-2">
              <li>95 questões de múltipla escolha</li>
              <li>Cronômetro de 60 minutos</li>
              <li>Navegação rápida entre questões</li>
              <li>Gabarito detalhado ao final</li>
              <li>Download do resultado em PDF</li>
              <li>Interface responsiva para todos os dispositivos</li>
            </ul>
          </CardContent>
        </Card>

        {/* About the Developer */}
        <Card className="shadow-elegant">
          <CardHeader>
            <CardTitle className="flex items-center gap-2 text-2xl">
              <Code className="w-6 h-6 text-primary" />
              Sobre o Desenvolvedor
            </CardTitle>
          </CardHeader>
          <CardContent className="space-y-4 text-muted-foreground leading-relaxed">
            <p>
              Esta aplicação foi desenvolvida com as mais modernas tecnologias web, 
              priorizando performance, acessibilidade e uma experiência de utilizador excepcional.
            </p>
            <p>
              Tecnologias utilizadas: React, TypeScript, Tailwind CSS e componentes UI modernos.
            </p>
          </CardContent>
        </Card>

        {/* Mission */}
        <Card className="shadow-elegant">
          <CardHeader>
            <CardTitle className="flex items-center gap-2 text-2xl">
              <Users className="w-6 h-6 text-primary" />
              Nossa Missão
            </CardTitle>
          </CardHeader>
          <CardContent className="text-muted-foreground leading-relaxed">
            <p>
              Democratizar o acesso à educação e preparação para provas, oferecendo uma ferramenta 
              gratuita, acessível e de qualidade para estudantes e profissionais que desejam 
              testar e aprimorar seus conhecimentos.
            </p>
          </CardContent>
        </Card>
      </main>
    </div>
  );
};

export default SobrePage;
