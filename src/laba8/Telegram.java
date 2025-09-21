package laba8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Telegram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;

        if (Objects.equals(chooseInput(scanner), "1"))
            text = inputText(scanner);
        else
            text = getText(scanner);

        replaceZpt(text);
    }

    public static String getDelimiter(char c) {
        if ((c >= 'а' && c <= 'я') || (c >= 'А' && c <= 'Я') || c == 'ё' || c == 'Ё')
            return " зпт ";
        else
            return " zpt ";
    }

    public static String makeTransformation(String s, String delimiter) {
        String[] newWords;
        int cntElems = 0, curIndex = 0, costWord = 10;

        String[] splitS = s.split(", ");

        for (String elem : splitS) {
            if (elem.length() > 2)
                cntElems++;
        }

        if (cntElems == 0) {
            System.out.println("стоимость телеграммы: 0");
            return s;
        }


        newWords = new String[cntElems];
        for (String elem : splitS) {
            if (elem.length() > 2) {
                newWords[curIndex] = elem;
                curIndex++;
            }
        }

        // словом считается именно разделение пробела и запятой
        System.out.println("Стоимость телеграммы: " + (cntElems + newWords.length - 1) * costWord);
        return String.join(delimiter, newWords);
    }

    public static void replaceZpt(String text) {
        char s;

        if (!text.isEmpty())
            s = text.charAt(0);
        else
            s = '|';

        String delimiter = getDelimiter(s);

        System.out.println("Полученный текст: ");
        System.out.println(text + "\n");

        text = makeTransformation(text, delimiter);
        System.out.println("Преобразованный текст: ");
        System.out.println(text);
    }

    public static String getText(Scanner scanner) {
        System.out.println("Введите путь к файлу: "); // src/laba8/text7.txt
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
        return text.toString().replaceAll(",+", ",").replaceAll("\\s+", " ").strip();
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

    public static String inputText(Scanner scanner) {
        System.out.println("Введите строку телеграмм: ");
        String line = scanner.nextLine();
        return line.replaceAll(",+", ",").replaceAll("\\s+", " ").strip();
    }
}
