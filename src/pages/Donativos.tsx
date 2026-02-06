import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { ArrowLeft, Heart, Copy, Check, Smartphone, CreditCard, Mail, Building } from "lucide-react";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { useToast } from "@/hooks/use-toast";

const paymentMethods = [
  {
    name: "PayPay",
    icon: Smartphone,
    reference: "923 456 789",
    description: "Envie o seu donativo via carteira PayPay",
    extraInfo: {
      title: "Também pode doar via Multicaixa Express para a carteira PayPay:",
      steps: [
        "Abrir o Multicaixa Express",
        "Ir em Transferências/Pagamentos",
        "Escolher Pagamentos por Referência",
        "Preencher os campos:",
      ],
      fields: [
        { label: "Valor", value: "Valor pretendido" },
        { label: "Entidade", value: "10116", copyable: true },
        { label: "Referência", value: "943693959", copyable: true },
      ],
    },
  },
  {
    name: "KWiK",
    icon: CreditCard,
    reference: "AO06042000000000061156412",
    description: "Transfira usando o IBAN da conta KWiK",
  },
];

const Donativos = () => {
  const navigate = useNavigate();
  const { toast } = useToast();
  const [copiedKey, setCopiedKey] = useState<string | null>(null);
  const [emailCopied, setEmailCopied] = useState(false);

  const email = "angonurse@gmail.com";

  const handleCopyEmail = async () => {
    try {
      await navigator.clipboard.writeText(email);
      setEmailCopied(true);
      toast({
        title: "Copiado!",
        description: "E-mail copiado para a área de transferência.",
      });
      setTimeout(() => setEmailCopied(false), 2000);
    } catch {
      toast({
        title: "Erro",
        description: "Não foi possível copiar o e-mail.",
        variant: "destructive",
      });
    }
  };

  const handleCopy = async (text: string, key: string) => {
    try {
      await navigator.clipboard.writeText(text);
      setCopiedKey(key);
      toast({
        title: "Copiado!",
        description: "Valor copiado para a área de transferência.",
      });
      setTimeout(() => setCopiedKey(null), 2000);
    } catch {
      toast({
        title: "Erro",
        description: "Não foi possível copiar.",
        variant: "destructive",
      });
    }
  };

  return (
    <div className="min-h-screen bg-background">
      <header className="sticky top-0 z-10 bg-card shadow-md border-b">
        <div className="max-w-4xl mx-auto px-4 py-4 flex items-center gap-4">
          <Button variant="ghost" size="icon" onClick={() => navigate("/")}>
            <ArrowLeft className="w-5 h-5" />
          </Button>
          <div className="flex items-center gap-2">
            <Heart className="w-5 h-5 text-destructive" />
            <h1 className="text-xl font-bold">Apoio & Donativos</h1>
          </div>
        </div>
      </header>

      <main className="max-w-4xl mx-auto px-4 py-8 space-y-6">
        {/* Mensagem de incentivo */}
        <Card className="shadow-elegant animate-fade-in border-primary/20">
          <CardHeader className="text-center pb-2">
            <div className="mx-auto w-16 h-16 rounded-full bg-destructive/10 flex items-center justify-center mb-3">
              <Heart className="w-8 h-8 text-destructive" />
            </div>
            <CardTitle className="text-2xl">Apoie o Teste Online</CardTitle>
          </CardHeader>
          <CardContent className="text-center space-y-4 text-muted-foreground leading-relaxed">
            <p>
              O <strong className="text-foreground">Teste Online</strong> é uma plataforma gratuita
              dedicada a ajudar estudantes e profissionais a prepararem-se para provas e concursos.
            </p>
            <p>
              A sua contribuição ajuda-nos a manter a plataforma activa, criar novas questões
              e melhorar continuamente a experiência de aprendizagem para todos.
            </p>
            <div className="inline-block bg-primary/10 rounded-lg px-6 py-3">
              <p className="text-sm text-muted-foreground">Valor mínimo de donativo</p>
              <p className="text-3xl font-bold text-primary">100 Kz</p>
            </div>
            <p className="text-sm">
              Qualquer valor acima de 100 Kz é bem-vindo e faz a diferença! 🙏
            </p>
          </CardContent>
        </Card>

        {/* Métodos de pagamento */}
        <div className="space-y-4">
          <h2 className="text-xl font-bold animate-fade-in stagger-1 opacity-0 fill-mode-forwards">
            Como contribuir
          </h2>

          {paymentMethods.map((method, index) => (
            <Card
              key={index}
              className="shadow-elegant animate-fade-in opacity-0 fill-mode-forwards"
              style={{ animationDelay: `${(index + 2) * 0.1}s` }}
            >
              <CardContent className="p-6">
                <div className="flex flex-col sm:flex-row items-start gap-4">
                  <div className="w-14 h-14 rounded-xl bg-primary/10 flex items-center justify-center shrink-0">
                    <method.icon className="w-7 h-7 text-primary" />
                  </div>
                  <div className="flex-1 space-y-3">
                    <h3 className="text-lg font-bold">{method.name}</h3>
                    <p className="text-sm text-muted-foreground">{method.description}</p>
                    <div className="flex items-center gap-2">
                      <code className="bg-muted px-3 py-1.5 rounded-md text-base font-mono font-semibold break-all">
                        {method.reference}
                      </code>
                      <Button
                        variant="ghost"
                        size="icon"
                        onClick={() => handleCopy(method.reference, `method-${index}`)}
                        className="shrink-0"
                      >
                        {copiedKey === `method-${index}` ? (
                          <Check className="w-4 h-4 text-success" />
                        ) : (
                          <Copy className="w-4 h-4" />
                        )}
                      </Button>
                    </div>

                    {/* Extra info for PayPay - Multicaixa Express instructions */}
                    {"extraInfo" in method && method.extraInfo && (
                      <div className="mt-4 p-4 bg-muted/50 rounded-lg border space-y-3">
                        <p className="text-sm font-semibold text-foreground">
                          {method.extraInfo.title}
                        </p>
                        <ol className="text-sm text-muted-foreground space-y-1.5 list-decimal list-inside">
                          {method.extraInfo.steps.map((step: string, i: number) => (
                            <li key={i}>{step}</li>
                          ))}
                        </ol>
                        <div className="space-y-2 pl-4">
                          {method.extraInfo.fields.map((field: { label: string; value: string; copyable?: boolean }, i: number) => (
                            <div key={i} className="flex items-center gap-2 flex-wrap">
                              <span className="text-sm font-medium text-foreground">{field.label}:</span>
                              <code className="bg-muted px-2 py-1 rounded text-sm font-mono font-semibold">
                                {field.value}
                              </code>
                              {field.copyable && (
                                <Button
                                  variant="ghost"
                                  size="icon"
                                  className="h-7 w-7 shrink-0"
                                  onClick={() => handleCopy(field.value, `field-${index}-${i}`)}
                                >
                                  {copiedKey === `field-${index}-${i}` ? (
                                    <Check className="w-3.5 h-3.5 text-success" />
                                  ) : (
                                    <Copy className="w-3.5 h-3.5" />
                                  )}
                                </Button>
                              )}
                            </div>
                          ))}
                        </div>
                      </div>
                    )}
                  </div>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>

        {/* Enviar comprovativo */}
        <Card className="shadow-elegant animate-fade-in opacity-0 fill-mode-forwards" style={{ animationDelay: "0.4s" }}>
          <CardContent className="p-6">
            <div className="flex flex-col sm:flex-row items-start sm:items-center gap-4">
              <div className="w-14 h-14 rounded-xl bg-secondary/10 flex items-center justify-center shrink-0">
                <Mail className="w-7 h-7 text-secondary" />
              </div>
              <div className="flex-1 space-y-2">
                <h3 className="text-lg font-bold">Enviar Comprovativo</h3>
                <p className="text-sm text-muted-foreground">
                  Após efectuar o donativo, envie o comprovativo de pagamento para o nosso e-mail para confirmarmos a sua contribuição.
                </p>
                <div className="flex items-center gap-2 mt-2">
                  <code className="bg-muted px-3 py-1.5 rounded-md text-base font-mono font-semibold break-all">
                    {email}
                  </code>
                  <Button
                    variant="ghost"
                    size="icon"
                    onClick={handleCopyEmail}
                    className="shrink-0"
                  >
                    {emailCopied ? (
                      <Check className="w-4 h-4 text-success" />
                    ) : (
                      <Copy className="w-4 h-4" />
                    )}
                  </Button>
                </div>
                <Button
                  asChild
                  variant="outline"
                  className="mt-3 w-full sm:w-auto"
                >
                  <a href={`mailto:${email}?subject=Comprovativo de Donativo - Teste Online`}>
                    <Mail className="w-4 h-4 mr-2" />
                    Abrir E-mail
                  </a>
                </Button>
              </div>
            </div>
          </CardContent>
        </Card>

        {/* Agradecimento */}
        <Card className="shadow-elegant animate-fade-in opacity-0 fill-mode-forwards" style={{ animationDelay: "0.5s" }}>
          <CardContent className="p-6 text-center text-muted-foreground">
            <p className="text-lg">
              💛 <strong className="text-foreground">Obrigado pelo seu apoio!</strong>
            </p>
            <p className="text-sm mt-2">
              Cada donativo nos motiva a continuar a desenvolver ferramentas educativas de qualidade.
            </p>
          </CardContent>
        </Card>
      </main>
    </div>
  );
};

export default Donativos;
