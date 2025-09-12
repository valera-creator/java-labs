package laba1;

import java.util.Scanner;

public class Happy {
    public static void main(String[] args) {

        int left_num, right_num;
        Scanner scanner = new Scanner(System.in);

        left_num = get_num(scanner);
        if (!check_num_value(left_num)) {
            System.out.printf("%d не шестизначное\n", left_num);
            return;
        }

        right_num = get_num(scanner);
        if (!check_num_value(right_num)) {
            System.out.printf("%d не шестизначное\n", right_num);
            return;
        }

        if (left_num > right_num) {
            System.out.println("левая граница больше правой");
            return;
        }

        search_happy(left_num, right_num);
        scanner.close();

    }

    public static void search_happy(int left, int right) {
        int cnt_happy = 0;
        for (int i = left; i < right + 1; i++) {
            if (check_happy(i)) {
                cnt_happy++;
                System.out.println(i);
            }

        }
        System.out.println("счастливых билетов: " + cnt_happy);
    }

    public static int get_num(Scanner scanner) {

        int number;
        while (true) {
            System.out.print("Введите границу билетов: ");
            if (scanner.hasNextInt()) { // типо проверка, что тут число введено
                number = scanner.nextInt();
                return number;
            } else {
                System.out.println("Ошибка: не число. Попробуйте снова.");
                scanner.next();
            }
        }
    }

    public static boolean check_num_value(int num) {
        return 100000 <= num && num <= 999999;
    }

    public static boolean check_happy(int num) {
        int one, two, three, four, five, six;

        six = num % 10;
        five = (num / 10) % 10;
        four = (num / 100) % 10;
        three = (num / 1000) % 10;
        two = (num / 10000) % 10;
        one = (num / 100000) % 10;

        return (one + two + three) == (four + five + six);
    }
}