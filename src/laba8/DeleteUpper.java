package laba8;

import java.util.Scanner;

public class DeleteUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder();

        inputWord(scanner, word);
        System.out.println("Введенное слово: " + word);
        deleteUpper(word);

        System.out.println("Полученное слово после upper удаления: " + word);
        scanner.close();
    }

    public static void inputWord(Scanner scanner, StringBuilder word) {
        System.out.print("Введи текст: ");
        word.append(scanner.nextLine());
    }

    public static void deleteUpper(StringBuilder word) {
        for (int i = word.length() - 1; i != -1; i--) {
            if (Character.isUpperCase(word.charAt(i)))
                word.deleteCharAt(i);
        }
    }
}
