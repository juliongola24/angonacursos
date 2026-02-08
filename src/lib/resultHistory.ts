export interface ResultRecord {
  id: string;
  participantName: string;
  percentage: string;
  correctCount: number;
  totalQuestions: number;
  date: string;
}

const STORAGE_KEY = "exam_result_history";

export const getResultHistory = (): ResultRecord[] => {
  try {
    const data = localStorage.getItem(STORAGE_KEY);
    return data ? JSON.parse(data) : [];
  } catch {
    return [];
  }
};

export const saveResult = (record: Omit<ResultRecord, "id" | "date">): void => {
  const history = getResultHistory();
  history.unshift({
    ...record,
    id: crypto.randomUUID(),
    date: new Date().toISOString(),
  });
  localStorage.setItem(STORAGE_KEY, JSON.stringify(history));
};

export const clearHistory = (): void => {
  localStorage.removeItem(STORAGE_KEY);
};
