package laba8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // String text = "5,-1lox-2355terr+478";
        String text = inputText(scanner);

        checkSumm(text);
        scanner.close();
    }

    public static void checkSumm(String text) {
        // это шаблон типо, ? - 0 или 1 раз входит ли то что перед ним
        Pattern patternDig = Pattern.compile("-?[0-9]+");
        // объект matcher для поиска
        Matcher matcher = patternDig.matcher(text);
        int summa = 0;

        // ищет вхождение строки, начиная с текущей позиции
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            System.out.println("Найденное число в строке: " + num);
            summa += num;
        }

        System.out.println("Сумма чисел в строке: " + summa);
    }

    public static String inputText(Scanner scanner) {
        System.out.print("Введите текст: ");
        return scanner.nextLine();
    }
}
