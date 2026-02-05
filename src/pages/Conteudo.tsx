import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { ArrowLeft, BookOpen } from "lucide-react";
import { useNavigate } from "react-router-dom";

const topics = [
  {
    title: "Geografia do Brasil",
    description:
      "Capitais dos estados, regiões, biomas, rios principais, clima e relevo do território brasileiro.",
  },
  {
    title: "Literatura Brasileira",
    description:
      "Obras clássicas da literatura nacional, autores renomados como Machado de Assis, José de Alencar, Jorge Amado e Clarice Lispector.",
  },
  {
    title: "Matemática Básica",
    description:
      "Operações fundamentais, porcentagem, regra de três, equações simples e raciocínio lógico.",
  },
  {
    title: "Ciências Naturais",
    description:
      "Sistema solar, planetas, leis da física, química básica, biologia celular e ecossistemas.",
  },
  {
    title: "História do Brasil",
    description:
      "Período colonial, Império, Proclamação da República, Era Vargas, ditadura militar e redemocratização.",
  },
  {
    title: "Atualidades",
    description:
      "Temas contemporâneos, política internacional, economia global, tecnologia e meio ambiente.",
  },
  {
    title: "Língua Portuguesa",
    description:
      "Gramática, interpretação de texto, ortografia, concordância verbal e nominal, regência e pontuação.",
  },
  {
    title: "Conhecimentos Gerais",
    description:
      "Cultura geral, curiosidades, fatos históricos, inventos e personalidades que marcaram a humanidade.",
  },
];

const Conteudo = () => {
  const navigate = useNavigate();

  return (
    <div className="min-h-screen bg-background">
      <header className="sticky top-0 z-10 bg-card shadow-md border-b">
        <div className="max-w-4xl mx-auto px-4 py-4 flex items-center gap-4">
          <Button variant="ghost" size="icon" onClick={() => navigate("/")}>
            <ArrowLeft className="w-5 h-5" />
          </Button>
          <div className="flex items-center gap-2">
            <BookOpen className="w-5 h-5 text-primary" />
            <h1 className="text-xl font-bold">Conteúdo Programático</h1>
          </div>
        </div>
      </header>

      <main className="max-w-4xl mx-auto px-4 py-8">
        <p className="text-muted-foreground mb-8 text-lg animate-fade-in">
          Confira abaixo os principais temas abordados nas questões do teste. Use este guia para direcionar seus estudos.
        </p>

        <div className="grid gap-4 md:grid-cols-2">
          {topics.map((topic, index) => (
            <Card
              key={index}
              className="shadow-elegant hover-scale animate-fade-in opacity-0 fill-mode-forwards"
              style={{ animationDelay: `${index * 0.1}s` }}
            >
              <CardHeader className="pb-2">
                <CardTitle className="text-lg flex items-center gap-2">
                  <span className="w-8 h-8 rounded-full bg-primary text-primary-foreground flex items-center justify-center text-sm font-bold">
                    {index + 1}
                  </span>
                  {topic.title}
                </CardTitle>
              </CardHeader>
              <CardContent>
                <p className="text-muted-foreground text-sm leading-relaxed">
                  {topic.description}
                </p>
              </CardContent>
            </Card>
          ))}
        </div>
      </main>
    </div>
  );
};

export default Conteudo;
