package laba8;

import java.util.Scanner;

public class LenThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = inputText(scanner);

        System.out.println("Введенный текст: " + text);
        searchLenThree(text);

        scanner.close();
    }

    public static void searchLenThree(String text) {
        int cntLenThree = 0;
        String[] words = text.split("[ ,]+");
        System.out.println("трехбуквенные слова: ");
        for (String s : words) {
            if (s.length() == 3) {
                cntLenThree++;
                System.out.println(s);
            }
        }
        System.out.println("количество трехбуквенных слов: " + cntLenThree);
    }

    public static String inputText(Scanner scanner) {
        System.out.print("Введите текст: ");
        return scanner.nextLine();
    }
}
