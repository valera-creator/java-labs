package laba9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Temperature {
    public static void main(String[] args) {
        List<Integer> temperature = new ArrayList<>(List.of(-2, -5, -2, -4, 3, -6, -2, -1, 5, 1, 1, 0, -1, 0,
                3, -1, 2, 5, 2, 4, 4, 0, 6, 1, 4, 6, -1, 2, 4, 7, 11));
        System.out.println("Полученные данные: " + temperature);

        checkNegativeTemperature(temperature);
        isTemperatureAboveTen(temperature);
        checkMaxTemperature(temperature);
        checkAverageTemperature(temperature);
    }

    public static void checkAverageTemperature(List<Integer> temperature) {
        OptionalDouble average = temperature.stream().mapToInt(Integer::intValue).average();
        if (average.isPresent())
            System.out.println("Среднее значение температуры: " + average.getAsDouble());
        else
            System.out.println("Нет данных температуры");
    }

    public static void checkMaxTemperature(List<Integer> temperature) {
        // сначала получаем первые 7 элементов
        List<Integer> firstWeek = temperature.stream().limit(7).toList();
        long max;
        if (firstWeek.isEmpty()) {
            System.out.println("Данные о температуре за первую неделю отсутствуют");
            return;
        }
        max = firstWeek.stream().max(Comparator.naturalOrder()).get();
        System.out.println("Максимальная температура в первую неделю: " + max);

    }

    public static void isTemperatureAboveTen(List<Integer> temperature) {
        if (temperature.stream().anyMatch(elem -> elem > 10))
            System.out.println("Были дни, когда температура была больше 10 градусов");
        else
            System.out.println("Не было дней, когда температура была больше 10 градусов");
    }

    public static void checkNegativeTemperature(List<Integer> temperature) {
        long cntNegative = temperature.stream().filter(elem -> elem < 0).count();
        System.out.println("Количество дней с отрицательной температурой: " + cntNegative);
    }
}
