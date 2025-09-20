package laba8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class SearchWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;

        if (Objects.equals(chooseInput(scanner), "1"))
            text = inputText(scanner);
        else
            text = getText(scanner);

        String word = inputWord(scanner);

        System.out.println("Введенное ключевое слово: " + word);
        searchPhrases(text, word);
        scanner.close();
    }

    public static String getText(Scanner scanner) {
        System.out.println("Введите путь к файлу: "); // src/laba8/text6.txt
        String path = scanner.nextLine();
        StringBuilder text = new StringBuilder();


        try (FileReader reader = new FileReader(path)) {
            int c;
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return text.toString();
    }


    public static String chooseInput(Scanner scanner) {
        while (true) {
            System.out.println("Введите способ подачи текста: (1 - ручной ввод, 2 - текстовый файл)");
            String var = scanner.nextLine();
            if (!Objects.equals(var, "1") && (!Objects.equals(var, "2")))
                System.out.println("Неизвестный способ ввода!");
            else
                return var;
        }
    }

    public static boolean checkSubstring(String string, String searchWord) {
        String[] words = string.split("\\s+");
        for (String word : words) {
            if (word.equals(searchWord))
                return true;
        }
        return false;
    }

    public static void searchPhrases(String text, String word) {
        System.out.println("Вывод: ");
        String[] phrases = text.split("[!?.]+");
        for (String s : phrases) {
            if (checkSubstring(s, word))
                System.out.println(s.strip());
        }
    }

    public static String inputWord(Scanner scanner) {
        System.out.println("Введите ключевое слово: ");
        return scanner.nextLine().strip();
    }

    public static String inputText(Scanner scanner) {
        System.out.println("Введите текст: ");
        StringBuilder sb = new StringBuilder();
        System.out.println("Для окончания ввода предложений введите пустую строку");
        while (true) {
            String line = scanner.nextLine();
            if (line.trim().isEmpty()) {
                break;
            }
            sb.append(line);
        }
        return sb.toString().replaceAll("\\s+", " ").strip();

    }
}
