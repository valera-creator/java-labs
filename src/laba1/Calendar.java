package laba1;

import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = get_calendar(scanner);
        determine_animal(year);
        scanner.close();
    }

    public static void determine_animal(int year) {
        int division = year % 12;
        System.out.print(year + " ");
        switch (division) {
            case 1: {
                System.out.println("год курицы");
                break;
            }
            case 2: {
                System.out.println("год собаки");
                break;
            }
            case 3: {
                System.out.println("год свиньи");
                break;
            }
            case 4: {
                System.out.println("год крысы");
                break;
            }
            case 5: {
                System.out.println("год коровы");
                break;
            }
            case 6: {
                System.out.println("год тигра");
                break;
            }
            case 7: {
                System.out.println("год зайца");
                break;
            }
            case 8: {
                System.out.println("год дракона");
                break;
            }
            case 9: {
                System.out.println("год змеи");
                break;
            }
            case 10: {
                System.out.println("год лошади");
                break;
            }
            case 11: {
                System.out.println("год овцы");
                break;
            }
            case 0: {
                System.out.println("год обезьяны");
                break;
            }
            default:
                System.out.println("такого быть не может");
        }

    }

    public static int get_calendar(Scanner scanner) {
        while (true) {
            System.out.print("Введите год: ");
            if (scanner.hasNextInt()) { // типо проверка, что тут число введено
                int year = scanner.nextInt();
                if (year < 1)
                    System.out.println("год не может быть меньше 1");
                else
                    return year;
            } else {
                System.out.println("Ошибка: не число. Попробуйте снова.");
                scanner.next();
            }
        }
    }
}
