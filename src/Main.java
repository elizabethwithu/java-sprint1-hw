import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();

        while (command != 0) {
            if (command == 1) {
                System.out.println("Введите номер месяца от 1 до 12, где 1 - январь, а 12 - декабрь");
                int month = getValidMonth(scanner);

                System.out.println("Введите номер дня указанного месяца от 1 до 30");
                int day = getValidDay(scanner);

                System.out.println("Введите количество пройденных в указанный день шагов");
                int steps = getValidSteps(scanner);

                stepTracker.monthToData[month - 1].setStepInDay(day, steps);

            } else if (command == 2) {
                System.out.println("Введите номер месяца от 1 до 12, где 1 - январь, а 12 - декабрь");
                int month = getValidMonth(scanner);

                stepTracker.printMonthStats(month);

            } else if (command == 3) {
                System.out.println("Введите новое целевое количество шагов");
                stepTracker.targetStepInDay = getValidSteps(scanner);

            } else {
                System.out.println("Введенной команды не существует");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
    }

    private static void printMenu() {
        String menu = "Что вы хотите сделать?\n" +
                "1 - Ввести количество шагов за определённый день\n" +
                "2 - Получить статистику за определённый месяц\n" +
                "3 - Изменить цель по количеству шагов в день\n" +
                "0 - Выйти из приложения";
        System.out.println(menu);
    }

    private static int getValidMonth(Scanner scanner) {
        int month = scanner.nextInt();
        while (month < 1 || month > 12) {
            System.out.println("Ошибка! Введите корректный номер месяца от 1 до 12");
            month = scanner.nextInt();
        }
        return month;
    }

    private static int getValidDay(Scanner scanner) {
        int day = scanner.nextInt();
        while (day < 1 || day > 30) {
            System.out.println("Ошибка! Введите корректный номер дня указанного месяца от 1 до 30");
            day = scanner.nextInt();
        }
        return day;
    }

    private static int getValidSteps(Scanner scanner) {
        int steps = scanner.nextInt();
        while (steps < 0) {
            System.out.println("Ошибка! Введите неотрицательное количество шагов");
            steps = scanner.nextInt();
        }
        return steps;
    }
}
