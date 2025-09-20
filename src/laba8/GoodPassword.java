package laba8;

import java.util.Scanner;

public class GoodPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String text = "MyP@ss,wOrd";
        String text = inputPassword(scanner);

        checkPassword(text);
        scanner.close();
    }

    public static String inputPassword(Scanner scanner) {
        System.out.print("Введите пароль: ");
        return scanner.nextLine();
    }

    public static void checkPassword(String password) {
        if (password.length() < 8 || password.length() > 12) {
            System.out.println("плохой пароль: длина не в диапазоне от 8 до 12");
            return;
        }
        // .* - любое кол-во любых символов, [...] - или какой-то из них
        if (!password.matches(".*[(#@$%^&*<>].*")) {
            System.out.println("плохой пароль: не содержится спецсимволов");
            return;
        }

        if (!password.matches(".*[.,:;?!\"'\\-].*")) {
            System.out.println("плохой пароль: нет знаков препинания");
            return;
        }

        if (!password.matches(".*[A-Z].*")) {
            System.out.println("плохой пароль: нет заглавных латинских букв");
            return;
        }

        if (!password.matches(".*[a-z].*")) {
            System.out.println("плохой пароль: нет прописных латинских букв");
            return;
        }

        // + для того чтобы 1 и более символов из набора, ^ - начало строки, $ - конец строки
        // цифры по условю тоже нельзя
        if (!password.matches("^[A-Za-z.,:;?!()\"'#@$%^&*<>\\-]+$")) {
            System.out.println("плохой пароль: пароль содержит запрещенные симолы, про которые не сказано в условии");
            return;
        }

        System.out.println("хороший пароль");
    }
}
