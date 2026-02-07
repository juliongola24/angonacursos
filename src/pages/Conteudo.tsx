import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { ArrowLeft, BookOpen } from "lucide-react";
import { useNavigate } from "react-router-dom";

const topics = [
  {
    title: "Anatomia e Fisiologia Humana",
    description:
      "Estudo detalhado dos sistemas do corpo humano: sistema nervoso (central e periférico), sistema cardiovascular (coração, vasos sanguíneos, ciclo cardíaco, débito cardíaco), sistema respiratório (mecânica ventilatória, trocas gasosas, volumes pulmonares), sistema digestivo (digestão mecânica e química, absorção de nutrientes), sistema urinário (filtração glomerular, reabsorção tubular, regulação do equilíbrio ácido-base), sistema endócrino (eixos hormonais, feedback negativo e positivo), sistema musculoesquelético (tipos de articulações, contracção muscular) e sistema linfático (imunidade inata e adaptativa).",
    expanded: true,
  },
  {
    title: "Farmacologia e Terapêutica",
    description:
      "Classes de medicamentos, mecanismos de acção, farmacocinética (absorção, distribuição, metabolismo e excreção), efeitos adversos, interacções medicamentosas e cuidados de enfermagem na administração de fármacos.",
  },
  {
    title: "Enfermagem Clínica e Cirúrgica",
    description:
      "Cuidados pré e pós-operatórios, monitorização de sinais vitais, gestão da dor, cuidados com feridas e pensos, prevenção de infecções hospitalares e técnicas assépticas.",
  },
  {
    title: "Saúde Materno-Infantil",
    description:
      "Assistência pré-natal, trabalho de parto, cuidados ao recém-nascido, aleitamento materno, vacinação infantil, crescimento e desenvolvimento da criança e principais patologias pediátricas.",
  },
  {
    title: "Saúde Pública e Epidemiologia",
    description:
      "Vigilância epidemiológica, indicadores de saúde, doenças transmissíveis e não transmissíveis, programas de saúde pública, promoção da saúde e prevenção de doenças em Angola.",
  },
  {
    title: "Microbiologia e Parasitologia",
    description:
      "Bactérias, vírus, fungos e parasitas de importância clínica, mecanismos de transmissão, diagnóstico laboratorial e medidas de controlo de infecções como malária, tuberculose e VIH/SIDA.",
  },
  {
    title: "Ética e Deontologia em Saúde",
    description:
      "Princípios éticos da prática em saúde, direitos do paciente, sigilo profissional, consentimento informado, responsabilidade legal e código deontológico dos profissionais de saúde.",
  },
  {
    title: "Primeiros Socorros e Emergências",
    description:
      "Suporte básico de vida (SBV), reanimação cardiopulmonar (RCP), abordagem ao politraumatizado, controlo de hemorragias, imobilização de fracturas, queimaduras e intoxicações.",
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
          Confira abaixo os principais temas de saúde abordados nas questões do teste. Use este guia para direcionar seus estudos.
        </p>

        <div className="grid gap-4 md:grid-cols-2">
          {topics.map((topic, index) => (
            <Card
              key={index}
              className={`shadow-elegant hover-scale animate-fade-in opacity-0 fill-mode-forwards ${
                topic.expanded ? "md:col-span-2 border-primary/30 bg-gradient-hero" : ""
              }`}
              style={{ animationDelay: `${index * 0.1}s` }}
            >
              <CardHeader className="pb-2">
                <CardTitle className="text-lg flex items-center gap-2">
                  <span className="w-8 h-8 rounded-full bg-primary text-primary-foreground flex items-center justify-center text-sm font-bold">
                    {index + 1}
                  </span>
                  {topic.title}
                  {topic.expanded && (
                    <span className="ml-auto text-xs font-normal bg-primary/10 text-primary px-2 py-1 rounded-full">
                      Conteúdo aprofundado
                    </span>
                  )}
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
