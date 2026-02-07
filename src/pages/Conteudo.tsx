import { ReactNode } from "react";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { ArrowLeft, BookOpen } from "lucide-react";
import { useNavigate } from "react-router-dom";

interface Topic {
  title: string;
  description?: string;
  content?: ReactNode;
  expanded?: boolean;
}

const topics: Topic[] = [
  {
    title: "Anatomia e Fisiologia Humana",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Estudo detalhado dos <strong className="text-foreground">sistemas do corpo humano</strong>, abrangendo a estrutura e o funcionamento de cada sistema orgânico essencial à prática clínica.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "O conhecimento profundo da anatomia é a base de toda a prática médica e de enfermagem."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Sistemas abordados:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li>
            <strong className="text-foreground">Sistema Nervoso</strong> — central e periférico, arco reflexo, neurotransmissores
          </li>
          <li>
            <strong className="text-foreground">Sistema Cardiovascular</strong> — coração, vasos sanguíneos, ciclo cardíaco, <em className="text-primary/80">débito cardíaco</em>
          </li>
          <li>
            <strong className="text-foreground">Sistema Respiratório</strong> — mecânica ventilatória, trocas gasosas, <em className="text-primary/80">volumes pulmonares</em>
          </li>
          <li>
            <strong className="text-foreground">Sistema Digestivo</strong> — digestão mecânica e química, absorção de nutrientes
          </li>
          <li>
            <strong className="text-foreground">Sistema Urinário</strong> — filtração glomerular, reabsorção tubular, <em className="text-primary/80">equilíbrio ácido-base</em>
          </li>
          <li>
            <strong className="text-foreground">Sistema Endócrino</strong> — eixos hormonais, feedback negativo e positivo
          </li>
          <li>
            <strong className="text-foreground">Sistema Musculoesquelético</strong> — tipos de articulações, contracção muscular
          </li>
          <li>
            <strong className="text-foreground">Sistema Linfático</strong> — imunidade inata e adaptativa
          </li>
        </ul>
      </>
    ),
  },
  {
    title: "Farmacologia e Terapêutica",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Estudo das <strong className="text-foreground">classes de medicamentos</strong>, os seus mecanismos de acção e os princípios da <strong className="text-foreground">farmacocinética</strong> aplicados à prática clínica de enfermagem.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "Administrar um fármaco sem compreender a sua farmacocinética é como navegar sem bússola."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Áreas fundamentais:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li><strong className="text-foreground">Farmacocinética</strong> — absorção, distribuição, metabolismo e <em className="text-primary/80">excreção (ADME)</em></li>
          <li><strong className="text-foreground">Farmacodinâmica</strong> — receptores, agonistas, antagonistas, <em className="text-primary/80">dose-resposta</em></li>
          <li><strong className="text-foreground">Anti-infecciosos</strong> — antibióticos, antifúngicos, antivirais e antiparasitários</li>
          <li><strong className="text-foreground">Analgésicos e Anti-inflamatórios</strong> — AINEs, opióides, escala analgésica da OMS</li>
          <li><strong className="text-foreground">Fármacos Cardiovasculares</strong> — anti-hipertensores, diuréticos, <em className="text-primary/80">anticoagulantes</em></li>
          <li><strong className="text-foreground">Interacções Medicamentosas</strong> — sinergismo, antagonismo e reacções adversas</li>
          <li><strong className="text-foreground">Cuidados de Enfermagem</strong> — os 9 certos da administração de medicamentos</li>
        </ul>
      </>
    ),
  },
  {
    title: "Enfermagem Clínica e Cirúrgica",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Abordagem dos <strong className="text-foreground">cuidados pré, intra e pós-operatórios</strong>, incluindo técnicas de monitorização, gestão da dor e <strong className="text-foreground">prevenção de infecções</strong> associadas aos cuidados de saúde.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "O enfermeiro é o primeiro e último contacto do paciente cirúrgico — a sua vigilância salva vidas."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Competências essenciais:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li><strong className="text-foreground">Avaliação Pré-operatória</strong> — anamnese, exames complementares, <em className="text-primary/80">checklist cirúrgico</em></li>
          <li><strong className="text-foreground">Sinais Vitais</strong> — PA, FC, FR, temperatura, <em className="text-primary/80">saturação de O₂</em></li>
          <li><strong className="text-foreground">Gestão da Dor</strong> — escalas de avaliação (EVA, Wong-Baker), intervenções farmacológicas e não farmacológicas</li>
          <li><strong className="text-foreground">Cuidados com Feridas</strong> — tipos de cicatrização, pensos, desbridamento</li>
          <li><strong className="text-foreground">Prevenção de IACS</strong> — técnica asséptica, higienização das mãos, <em className="text-primary/80">precauções padrão</em></li>
          <li><strong className="text-foreground">Drenos e Sondas</strong> — tipos, cuidados de manutenção e remoção</li>
          <li><strong className="text-foreground">Complicações Pós-operatórias</strong> — hemorragia, infecção, TVP, <em className="text-primary/80">embolia pulmonar</em></li>
        </ul>
      </>
    ),
  },
  {
    title: "Saúde Materno-Infantil",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Assistência integral à <strong className="text-foreground">mulher grávida</strong>, ao <strong className="text-foreground">recém-nascido</strong> e à criança, desde a concepção até ao desenvolvimento infantil, com foco na promoção da saúde e prevenção de complicações.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "Cada nascimento é uma oportunidade de garantir um futuro mais saudável para mãe e filho."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Tópicos principais:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li><strong className="text-foreground">Assistência Pré-natal</strong> — consultas, exames, <em className="text-primary/80">sinais de alarme</em></li>
          <li><strong className="text-foreground">Trabalho de Parto</strong> — fases, partograma, indicações de cesariana</li>
          <li><strong className="text-foreground">Cuidados ao Recém-nascido</strong> — índice de Apgar, <em className="text-primary/80">cuidados imediatos</em>, triagem neonatal</li>
          <li><strong className="text-foreground">Aleitamento Materno</strong> — técnicas de amamentação, vantagens, contraindicações</li>
          <li><strong className="text-foreground">Vacinação Infantil</strong> — calendário vacinal angolano, <em className="text-primary/80">cadeia de frio</em></li>
          <li><strong className="text-foreground">Crescimento e Desenvolvimento</strong> — marcos do desenvolvimento, curvas de crescimento</li>
          <li><strong className="text-foreground">Patologias Pediátricas</strong> — diarreia, pneumonia, malnutrição, malária infantil</li>
        </ul>
      </>
    ),
  },
  {
    title: "Saúde Pública e Epidemiologia",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Compreensão dos <strong className="text-foreground">determinantes de saúde</strong>, vigilância epidemiológica e <strong className="text-foreground">programas de saúde pública</strong> com enfoque no contexto angolano e africano.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "Prevenir é sempre mais eficaz e económico do que tratar — a saúde pública é o escudo da comunidade."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Domínios de estudo:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li><strong className="text-foreground">Epidemiologia</strong> — incidência, prevalência, <em className="text-primary/80">cadeia epidemiológica</em></li>
          <li><strong className="text-foreground">Indicadores de Saúde</strong> — mortalidade infantil, esperança de vida, taxa de fecundidade</li>
          <li><strong className="text-foreground">Doenças Transmissíveis</strong> — malária, tuberculose, VIH/SIDA, <em className="text-primary/80">cólera</em></li>
          <li><strong className="text-foreground">Doenças Não Transmissíveis</strong> — hipertensão, diabetes, cancro</li>
          <li><strong className="text-foreground">Promoção da Saúde</strong> — educação sanitária, saneamento básico, água potável</li>
          <li><strong className="text-foreground">Vigilância Epidemiológica</strong> — notificação obrigatória, investigação de surtos</li>
          <li><strong className="text-foreground">Programas Nacionais</strong> — PAV, PNCT, programa de luta contra a malária</li>
        </ul>
      </>
    ),
  },
  {
    title: "Microbiologia e Parasitologia",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Estudo dos <strong className="text-foreground">microrganismos patogénicos</strong> — bactérias, vírus, fungos e parasitas — com ênfase nas infecções de maior relevância clínica em <strong className="text-foreground">Angola e África Subsaariana</strong>.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "Conhecer o inimigo microscópico é o primeiro passo para vencê-lo — a microbiologia é a arma do profissional de saúde."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Conteúdos abordados:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li><strong className="text-foreground">Bacteriologia</strong> — Gram-positivas e Gram-negativas, <em className="text-primary/80">resistência antimicrobiana</em></li>
          <li><strong className="text-foreground">Virologia</strong> — VIH, hepatites B e C, vírus Ébola, <em className="text-primary/80">SARS-CoV-2</em></li>
          <li><strong className="text-foreground">Parasitologia</strong> — Plasmodium (malária), helmintas, protozoários intestinais</li>
          <li><strong className="text-foreground">Micologia</strong> — Candida, dermatófitos, micoses oportunistas</li>
          <li><strong className="text-foreground">Diagnóstico Laboratorial</strong> — coloração de Gram, culturas, <em className="text-primary/80">testes rápidos</em></li>
          <li><strong className="text-foreground">Controlo de Infecções</strong> — esterilização, desinfecção, biossegurança</li>
          <li><strong className="text-foreground">Ciclos de Transmissão</strong> — vectores, hospedeiros, medidas de prevenção</li>
        </ul>
      </>
    ),
  },
  {
    title: "Ética e Deontologia em Saúde",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Reflexão sobre os <strong className="text-foreground">princípios éticos fundamentais</strong> que guiam a prática profissional em saúde, incluindo os <strong className="text-foreground">direitos do paciente</strong> e as responsabilidades legais do profissional.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "A ética não é um acessório da profissão — é o alicerce sobre o qual se constrói a confiança do paciente."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Princípios e temas:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li><strong className="text-foreground">Bioética</strong> — autonomia, beneficência, não-maleficência, <em className="text-primary/80">justiça</em></li>
          <li><strong className="text-foreground">Consentimento Informado</strong> — requisitos legais, capacidade de decisão</li>
          <li><strong className="text-foreground">Sigilo Profissional</strong> — confidencialidade, limites da partilha de informação</li>
          <li><strong className="text-foreground">Direitos do Paciente</strong> — dignidade, privacidade, <em className="text-primary/80">acesso à informação</em></li>
          <li><strong className="text-foreground">Código Deontológico</strong> — deveres profissionais, responsabilidade civil e penal</li>
          <li><strong className="text-foreground">Dilemas Éticos</strong> — fim de vida, recusa de tratamento, alocação de recursos</li>
          <li><strong className="text-foreground">Relação Terapêutica</strong> — comunicação empática, limites profissionais</li>
        </ul>
      </>
    ),
  },
  {
    title: "Primeiros Socorros e Emergências",
    expanded: true,
    content: (
      <>
        <p className="text-muted-foreground text-sm leading-relaxed mb-4">
          Domínio das técnicas de <strong className="text-foreground">suporte básico de vida</strong> e abordagem sistemática a <strong className="text-foreground">situações de emergência</strong>, desde o reconhecimento até à estabilização da vítima.
        </p>
        <blockquote className="border-l-4 border-primary/40 pl-4 italic text-muted-foreground text-sm mb-4">
          "Os primeiros minutos de uma emergência determinam a diferença entre a vida e a morte — cada segundo conta."
        </blockquote>
        <h4 className="text-sm font-semibold text-foreground mb-2">Competências de emergência:</h4>
        <ul className="space-y-2 text-sm text-muted-foreground leading-relaxed">
          <li><strong className="text-foreground">Suporte Básico de Vida</strong> — cadeia de sobrevivência, <em className="text-primary/80">algoritmo SBV</em></li>
          <li><strong className="text-foreground">RCP</strong> — compressões torácicas, ventilações, uso do <em className="text-primary/80">DEA</em></li>
          <li><strong className="text-foreground">Abordagem ABCDE</strong> — via aérea, respiração, circulação, disfunção neurológica, exposição</li>
          <li><strong className="text-foreground">Hemorragias</strong> — classificação, técnicas de hemostase, torniquete</li>
          <li><strong className="text-foreground">Fracturas e Imobilização</strong> — tipos, talas, <em className="text-primary/80">técnica de remoção</em></li>
          <li><strong className="text-foreground">Queimaduras</strong> — classificação por grau e extensão (regra dos 9)</li>
          <li><strong className="text-foreground">Intoxicações</strong> — abordagem inicial, descontaminação, antídotos</li>
        </ul>
      </>
    ),
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

        <div className="grid gap-4">
          {topics.map((topic, index) => (
            <Card
              key={index}
              className="shadow-elegant hover-scale animate-fade-in opacity-0 fill-mode-forwards border-primary/30 bg-gradient-hero"
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
                {topic.content ? (
                  topic.content
                ) : (
                  <p className="text-muted-foreground text-sm leading-relaxed">
                    {topic.description}
                  </p>
                )}
              </CardContent>
            </Card>
          ))}
        </div>
      </main>
    </div>
  );
};

export default Conteudo;
