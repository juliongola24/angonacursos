import { useState, useEffect } from "react";
import { Button } from "@/components/ui/button";
import { ExamQuiz } from "@/components/ExamQuiz";
import { ShareDialog } from "@/components/ShareDialog";
import { SideMenu } from "@/components/SideMenu";
import { Play, BookOpen, Info, Share2, Menu, Heart } from "lucide-react";
import { useNavigate } from "react-router-dom";
import heroImage from "@/assets/hero-exam.jpg";

const Index = () => {
  const [hasStarted, setHasStarted] = useState(false);
  const [shareOpen, setShareOpen] = useState(false);
  const [menuOpen, setMenuOpen] = useState(false);
  const [darkMode, setDarkMode] = useState(false);
  const [soundEffects, setSoundEffects] = useState(false);
  const [backgroundMusic, setBackgroundMusic] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    const savedDarkMode = localStorage.getItem("darkMode") === "true";
    setDarkMode(savedDarkMode);
    if (savedDarkMode) {
      document.documentElement.classList.add("dark");
    }
  }, []);

  const handleDarkModeChange = (value: boolean) => {
    setDarkMode(value);
    localStorage.setItem("darkMode", String(value));
    if (value) {
      document.documentElement.classList.add("dark");
    } else {
      document.documentElement.classList.remove("dark");
    }
  };

  if (hasStarted) {
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

      {/* Hamburger Menu Button */}
      <div className="absolute top-4 right-4 z-20">
        <Button
          variant="ghost"
          size="icon"
          onClick={() => setMenuOpen(true)}
          className="bg-card/80 backdrop-blur-sm hover:bg-card"
        >
          <Menu className="w-6 h-6" />
        </Button>
      </div>

      {/* Content */}
      <div className="relative z-10 flex min-h-screen items-center justify-center px-4 py-12">
        <div className="w-full max-w-md space-y-8">
          {/* Logo/Title */}
          <div className="text-center space-y-2 animate-fade-in">
            <h1 className="text-5xl font-bold bg-gradient-primary bg-clip-text text-transparent">
              Teste Online
            </h1>
            <p className="text-lg text-muted-foreground">
              Plataforma Profissional de Avaliação
            </p>
          </div>

          {/* Action Buttons */}
          <div className="space-y-3">
            <Button
              onClick={() => setHasStarted(true)}
              className="w-full bg-gradient-primary text-lg h-14 animate-fade-in stagger-1 opacity-0 fill-mode-forwards hover-scale"
              size="lg"
            >
              <Play className="w-6 h-6 mr-2" />
              Iniciar Teste
            </Button>

            <Button
              onClick={() => navigate("/conteudo")}
              variant="outline"
              className="w-full text-lg h-14 animate-fade-in stagger-2 opacity-0 fill-mode-forwards hover-scale"
              size="lg"
            >
              <BookOpen className="w-6 h-6 mr-2" />
              Conteúdo
            </Button>

            <Button
              onClick={() => navigate("/donativos")}
              variant="outline"
              className="w-full text-lg h-14 animate-fade-in stagger-3 opacity-0 fill-mode-forwards hover-scale"
              size="lg"
            >
              <Heart className="w-6 h-6 mr-2" />
              Apoio & Donativos
            </Button>

            <Button
              onClick={() => navigate("/sobre")}
              variant="outline"
              className="w-full text-lg h-14 animate-fade-in stagger-4 opacity-0 fill-mode-forwards hover-scale"
              size="lg"
            >
              <Info className="w-6 h-6 mr-2" />
              Saber Mais
            </Button>

            <Button
              onClick={() => setShareOpen(true)}
              variant="outline"
              className="w-full text-lg h-14 animate-fade-in stagger-4 opacity-0 fill-mode-forwards hover-scale"
              size="lg"
            >
              <Share2 className="w-6 h-6 mr-2" />
              Compartilhar
            </Button>
          </div>

          {/* Info */}
          <div className="text-center text-sm text-muted-foreground space-y-1 animate-fade-in stagger-5 opacity-0 fill-mode-forwards">
            <p>95 questões · 60 minutos · Gabarito detalhado</p>
          </div>
        </div>
      </div>

      {/* Share Dialog */}
      <ShareDialog open={shareOpen} onOpenChange={setShareOpen} />

      {/* Side Menu */}
      <SideMenu
        open={menuOpen}
        onOpenChange={setMenuOpen}
        darkMode={darkMode}
        onDarkModeChange={handleDarkModeChange}
        soundEffects={soundEffects}
        onSoundEffectsChange={setSoundEffects}
        backgroundMusic={backgroundMusic}
        onBackgroundMusicChange={setBackgroundMusic}
      />
    </div>
  );
};

export default Index;
