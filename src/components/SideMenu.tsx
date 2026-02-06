import {
  Sheet,
  SheetContent,
  SheetHeader,
  SheetTitle,
} from "@/components/ui/sheet";
import { Switch } from "@/components/ui/switch";
import { Label } from "@/components/ui/label";
import { Separator } from "@/components/ui/separator";
import { Button } from "@/components/ui/button";
import { Moon, Sun, Volume2, Music, Facebook, MessageCircle } from "lucide-react";

interface SideMenuProps {
  open: boolean;
  onOpenChange: (open: boolean) => void;
  darkMode: boolean;
  onDarkModeChange: (value: boolean) => void;
  soundEffects: boolean;
  onSoundEffectsChange: (value: boolean) => void;
  backgroundMusic: boolean;
  onBackgroundMusicChange: (value: boolean) => void;
}

export const SideMenu = ({
  open,
  onOpenChange,
  darkMode,
  onDarkModeChange,
  soundEffects,
  onSoundEffectsChange,
  backgroundMusic,
  onBackgroundMusicChange,
}: SideMenuProps) => {
  return (
    <Sheet open={open} onOpenChange={onOpenChange}>
      <SheetContent side="right" className="w-[300px] sm:w-[350px]">
        <SheetHeader>
          <SheetTitle className="text-xl">Definições</SheetTitle>
        </SheetHeader>

        <div className="mt-6 space-y-6">
          {/* Dark Mode */}
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-3">
              {darkMode ? (
                <Moon className="w-5 h-5 text-primary" />
              ) : (
                <Sun className="w-5 h-5 text-primary" />
              )}
              <Label htmlFor="dark-mode" className="text-base cursor-pointer">
                Modo Escuro
              </Label>
            </div>
            <Switch
              id="dark-mode"
              checked={darkMode}
              onCheckedChange={onDarkModeChange}
            />
          </div>

          <Separator />

          {/* Sound Effects */}
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-3">
              <Volume2 className="w-5 h-5 text-primary" />
              <Label htmlFor="sound-effects" className="text-base cursor-pointer">
                Efeitos Sonoros
              </Label>
            </div>
            <Switch
              id="sound-effects"
              checked={soundEffects}
              onCheckedChange={onSoundEffectsChange}
            />
          </div>

          <Separator />

          {/* Background Music */}
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-3">
              <Music className="w-5 h-5 text-primary" />
              <Label htmlFor="bg-music" className="text-base cursor-pointer">
                Música de Fundo
              </Label>
            </div>
            <Switch
              id="bg-music"
              checked={backgroundMusic}
              onCheckedChange={onBackgroundMusicChange}
            />
          </div>

          <Separator />

          {/* Social Links */}
          <div className="space-y-3">
            <Button
              asChild
              variant="outline"
              size="lg"
              className="w-full"
            >
              <a
                href="https://facebook.com/angonurse"
                target="_blank"
                rel="noopener noreferrer"
              >
                <Facebook className="w-5 h-5 mr-2 text-[hsl(220,60%,50%)]" />
                Seguir no Facebook
              </a>
            </Button>

            <Button
              asChild
              variant="outline"
              size="lg"
              className="w-full"
            >
              <a
                href="https://whatsapp.com/channel/0029VbAkfjb0Qeamx7kuuR28"
                target="_blank"
                rel="noopener noreferrer"
              >
                <MessageCircle className="w-5 h-5 mr-2 text-[hsl(142,70%,40%)]" />
                Seguir no WhatsApp
              </a>
            </Button>

            <Button
              asChild
              variant="outline"
              size="lg"
              className="w-full"
            >
              <a
                href="https://tiktok.com/@angonurse"
                target="_blank"
                rel="noopener noreferrer"
              >
                <svg className="w-5 h-5 mr-2" viewBox="0 0 24 24" fill="currentColor" style={{ color: 'hsl(340, 80%, 50%)' }}>
                  <path d="M19.59 6.69a4.83 4.83 0 0 1-3.77-4.25V2h-3.45v13.67a2.89 2.89 0 0 1-2.88 2.5 2.89 2.89 0 0 1-2.89-2.89 2.89 2.89 0 0 1 2.89-2.89c.28 0 .54.04.79.1v-3.5a6.37 6.37 0 0 0-.79-.05A6.34 6.34 0 0 0 3.15 15a6.34 6.34 0 0 0 6.34 6.34 6.34 6.34 0 0 0 6.34-6.34V8.77a8.16 8.16 0 0 0 4.76 1.52v-3.4a4.85 4.85 0 0 1-1-.2z"/>
                </svg>
                Seguir no TikTok
              </a>
            </Button>
          </div>
        </div>
      </SheetContent>
    </Sheet>
  );
};
