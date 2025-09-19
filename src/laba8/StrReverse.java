package laba8;

import java.util.Scanner;

public class StrReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = inputText(scanner);

        System.out.println("Введенный текст: " + word);
        decrypt(word);
        scanner.close();
    }

    public static void decrypt(String word) {
        String[] words = word.split("\\s+"); // типо несколько пробелов, табуляции и тд
        for (int i = 0; i < words.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(words[i]);
            stringBuilder.reverse();
            words[i] = stringBuilder.toString();
        }

        String result = String.join(" ", words);
        System.out.println("Расшифрованный текст: " + result);
    }

    public static String inputText(Scanner scanner) {
        System.out.print("Введи текст: ");
        return scanner.nextLine();
    }
}
