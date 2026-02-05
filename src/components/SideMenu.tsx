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
import { Moon, Sun, Volume2, Music, Facebook } from "lucide-react";

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

          {/* Follow on Facebook */}
          <Button
            asChild
            variant="outline"
            size="lg"
            className="w-full"
          >
            <a
              href="https://facebook.com"
              target="_blank"
              rel="noopener noreferrer"
            >
              <Facebook className="w-5 h-5 mr-2 text-[hsl(220,60%,50%)]" />
              Seguir no Facebook
            </a>
          </Button>
        </div>
      </SheetContent>
    </Sheet>
  );
};
