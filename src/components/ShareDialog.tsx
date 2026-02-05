import { useState } from "react";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
} from "@/components/ui/dialog";
import { Button } from "@/components/ui/button";
import { Copy, Check, Facebook, MessageCircle } from "lucide-react";
import { useToast } from "@/hooks/use-toast";

interface ShareDialogProps {
  open: boolean;
  onOpenChange: (open: boolean) => void;
}

export const ShareDialog = ({ open, onOpenChange }: ShareDialogProps) => {
  const [copied, setCopied] = useState(false);
  const { toast } = useToast();

  const shareText = "📚 Teste Online - Plataforma de Avaliação\n\nPrepare-se com 95 questões de múltipla escolha, cronômetro e gabarito detalhado!\n\n";
  const shareUrl = window.location.href;
  const fullShareText = shareText + shareUrl;

  const handleCopy = async () => {
    try {
      await navigator.clipboard.writeText(fullShareText);
      setCopied(true);
      toast({
        title: "Copiado!",
        description: "Link copiado para a área de transferência.",
      });
      setTimeout(() => setCopied(false), 2000);
    } catch {
      toast({
        title: "Erro",
        description: "Não foi possível copiar o link.",
        variant: "destructive",
      });
    }
  };

  const handleShareWhatsApp = () => {
    window.open(
      `https://wa.me/?text=${encodeURIComponent(fullShareText)}`,
      "_blank"
    );
  };

  const handleShareFacebook = () => {
    window.open(
      `https://www.facebook.com/sharer/sharer.php?u=${encodeURIComponent(shareUrl)}&quote=${encodeURIComponent(shareText)}`,
      "_blank"
    );
  };

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="sm:max-w-md">
        <DialogHeader>
          <DialogTitle className="text-xl">Compartilhar</DialogTitle>
        </DialogHeader>
        <div className="space-y-4">
          <div className="p-4 bg-muted rounded-lg text-sm text-muted-foreground break-words">
            {fullShareText}
          </div>

          <div className="grid grid-cols-1 gap-3">
            <Button onClick={handleCopy} variant="outline" size="lg" className="w-full">
              {copied ? (
                <Check className="w-5 h-5 mr-2 text-success" />
              ) : (
                <Copy className="w-5 h-5 mr-2" />
              )}
              {copied ? "Copiado!" : "Copiar Link"}
            </Button>

            <Button onClick={handleShareWhatsApp} size="lg" className="w-full bg-[hsl(142,70%,40%)] hover:bg-[hsl(142,70%,35%)] text-white">
              <MessageCircle className="w-5 h-5 mr-2" />
              WhatsApp
            </Button>

            <Button onClick={handleShareFacebook} size="lg" className="w-full bg-[hsl(220,60%,50%)] hover:bg-[hsl(220,60%,45%)] text-white">
              <Facebook className="w-5 h-5 mr-2" />
              Facebook
            </Button>
          </div>
        </div>
      </DialogContent>
    </Dialog>
  );
};
