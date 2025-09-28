package laba9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Words {
    public static void main(String[] args) {
        String fileName = "src/laba9/text.txt";
        String[] text = getText(fileName);
        System.out.println("Полученные слова: " + String.join(", ", text));
        checkEndEs(text);
        sortLen(text);
        checkSum(text);
    }

    public static boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void checkSum(String[] text) {
        String[] nums = Arrays.stream(text).filter(Words::isNum).toArray(String[]::new);
        int[] intNums = Arrays.stream(nums).mapToInt(Integer::parseInt).toArray();
        System.out.println("Числа в тексте: " + String.join(", ", nums));
        System.out.println("Сумма чисел: " + Arrays.stream(intNums).sum());
    }

    public static void sortLen(String[] text) {
        // примитив, поэтому надо в toArray ту фигню писать
        String[] sortWords = Arrays.stream(text).sorted(Comparator.comparing(String::length)).toArray(String[]::new);
        System.out.println("Слова, отсортированные по длине по возрастанию: " + String.join(", ", sortWords));
    }

    public static void checkEndEs(String[] text) {
        String[] newText = Arrays.stream(text).filter(elem -> elem.endsWith("es")).toArray(String[]::new);
        System.out.println("Слова, оканчивающиеся на \"es\"" + " (" + newText.length + " слов): " +
                String.join(", ", newText));
    }

    public static String[] getText(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            return String.join(" ", lines).replaceAll("[, ]+", " ").split("\\s+");
        } catch (IOException e) {
            System.err.println("Ошибка: не удалось обработать файл по пути " + fileName);
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return new String[0];
    }
}
