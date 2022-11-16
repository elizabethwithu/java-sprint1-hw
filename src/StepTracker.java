import java.util.Arrays;

public class StepTracker {

    int targetStepInDay;
    MonthData[] monthToData;

    StepTracker() {
        targetStepInDay = 10000;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void printMonthStats(int month) {
        MonthData monthData = monthToData[month - 1];
        monthData.printMonthData();
        monthData.printStepsSum();
        monthData.printMaxSteps();
        monthData.printAvgSteps();
        monthData.printDistance(monthData.countStepsSum());
        monthData.printEnergyCosts(monthData.countStepsSum());
        monthData.printBestSequence(targetStepInDay);
    }

    static class MonthData {
        int[] dayToData;

        MonthData() {
            dayToData = new int[30];
            Arrays.fill(dayToData, 0);
        }

        void setStepInDay(int day, int stepInDay) {
            dayToData[day - 1] = stepInDay;
        }

        int countStepsSum() {
            int stepsSum = 0;
            for (int daySteps : dayToData) {
                stepsSum += daySteps;
            }
            return stepsSum;
        }

        void printMonthData() {
            for (int i = 0; i < dayToData.length; i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print((i + 1) + " день: " + dayToData[i]);
            }
            System.out.println();
        }

        void printStepsSum() {
            System.out.println("Общее количество шагов: " + countStepsSum());
        }

        void printMaxSteps() {
            int maxSteps = dayToData[0];
            for (int i = 1; i < dayToData.length; i++) {
                if (dayToData[i] > maxSteps) {
                    maxSteps = dayToData[i];
                }
            }
            System.out.println("Максимальное пройденное количество шагов за день: " + maxSteps);
        }

        void printAvgSteps() {
            System.out.println("Среднее количество шагов: " + (countStepsSum() / dayToData.length));
        }

        void printDistance(int steps) {
            System.out.println("Пройденная дистанция: " + Converter.stepsToDistance(steps) + " километров");
        }

        void printEnergyCosts(int steps) {
            System.out.println("Количество сожжённых килокалорий: " + Math.round(Converter.stepsToEnergyCosts(steps)));
        }

        void printBestSequence(int targetStepInDay) {
            int bestSequence = 0;
            int bestSequenceTemp = 0;

            for (int stepsInDay : dayToData) {
                if (stepsInDay > targetStepInDay) {
                    bestSequenceTemp++;
                    if (bestSequenceTemp > bestSequence) {
                        bestSequence = bestSequenceTemp;
                    }
                } else {
                    bestSequenceTemp = 0;
                }
            }
            System.out.println("Лучшая серия: " + bestSequence);
        }
    }
}
