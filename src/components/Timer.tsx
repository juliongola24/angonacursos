import { useEffect, useState } from "react";
import { Clock } from "lucide-react";

interface TimerProps {
  duration: number; // in minutes
  onTimeUp: () => void;
}

export const Timer = ({ duration, onTimeUp }: TimerProps) => {
  const [timeLeft, setTimeLeft] = useState(duration * 60); // convert to seconds

  useEffect(() => {
    if (timeLeft <= 0) {
      onTimeUp();
      return;
    }

    const timer = setInterval(() => {
      setTimeLeft((prev) => prev - 1);
    }, 1000);

    return () => clearInterval(timer);
  }, [timeLeft, onTimeUp]);

  const minutes = Math.floor(timeLeft / 60);
  const seconds = timeLeft % 60;

  const isWarning = timeLeft <= 300; // last 5 minutes
  const isCritical = timeLeft <= 60; // last minute

  return (
    <div
      className={`flex items-center gap-2 px-4 py-2 rounded-lg font-mono text-lg font-semibold transition-colors ${
        isCritical
          ? "bg-destructive text-destructive-foreground"
          : isWarning
          ? "bg-accent text-accent-foreground"
          : "bg-card text-card-foreground"
      }`}
    >
      <Clock className="w-5 h-5" />
      <span>
        {String(minutes).padStart(2, "0")}:{String(seconds).padStart(2, "0")}
      </span>
    </div>
  );
};
