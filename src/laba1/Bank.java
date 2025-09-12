package laba1;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int summa = get_num(scanner);
        System.out.println("введенная сумма " + summa);
        calculate_money(summa);
        scanner.close();
    }

    public static void calculate_money(int summa) {
        int div, cnt50 = 0, cnt100 = 0, cnt1000 = 0;
        if (summa == 0)
            System.out.println("для суммы 0 потребовалось 0 купюр");
        else if (summa % 50 != 0)
            System.out.println("сумму невозможно собрать");
        else {
            if (summa / 1000 != 0) {
                div = summa % 1000;
                cnt1000 = summa / 1000;
                summa = div;
            }

            if (summa / 100 != 0) {
                div = summa % 100;
                cnt100 = summa / 100;
                summa = div;
            }

            if (summa / 50 != 0)
                cnt50 = summa / 50;

        }
        System.out.println("\nбудет выдано:\n1000-ых купюр: " + cnt1000 + "\n100-ых купюр: " + cnt100 + "\n" +
                "50-ых купюр: " + cnt50);
        //System.out.println(cnt50 * 50 + cnt100 * 100 + cnt1000 * 1000);

    }

    public static int get_num(Scanner scanner) {

        int summa;
        while (true) {
            System.out.print("Введите нужную сумму: ");
            if (scanner.hasNextInt()) { // типо проверка, что тут число введено
                summa = scanner.nextInt();
                if (summa < 0)
                    System.out.println("сумма не может быть меньше 0");
                else
                    return summa;
            } else {
                System.out.println("Ошибка: не число. Попробуйте снова.");
                scanner.next();
            }
        }
    }
}
