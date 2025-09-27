package laba7;

import java.util.Random;
import java.util.LinkedList;
import java.util.Collections;

public class ArrayDoubleNumbs {
    public static void main(String[] args) {
        LinkedList<Double> numbs = new LinkedList<>();
        insertNumbs(numbs);

        System.out.println("Полученный список: " + numbs);
        sortedList(numbs);
        checkZero(numbs);
        addMidElem(numbs);
    }

    public static void addMidElem(LinkedList<Double> numbs) {
        int mid;
        double arithmeticMean;
        if (numbs.isEmpty()) {
            System.out.println("Получен пустой список для сортировки");
            return;
        }

        mid = numbs.size() / 2;
        arithmeticMean = (numbs.getFirst() + numbs.getLast()) / 2;
        arithmeticMean = Math.round(arithmeticMean * 100.0) / 100.0;
        numbs.add(mid, arithmeticMean);

        System.out.println("Список после вставки в середину среднего арифметического " +
                "первого и ластового элемента: " + numbs);
    }

    public static void checkZero(LinkedList<Double> numbs) {
        if (numbs.isEmpty()) {
            System.out.println("Получен пустой список для сортировки");
            return;
        }

        if (!numbs.contains(0.0))
            System.out.println("В списке нет нулевых элементов");
        else
            System.out.println("В списке есть нулевые элементы");
    }

    public static void sortedList(LinkedList<Double> numbs) {
        if (numbs.isEmpty()) {
            System.out.println("Получен пустой список для сортировки");
            return;
        }
        numbs.sort(Collections.reverseOrder());
        System.out.println("Отсортированный лист по убыванию: " + numbs);
    }

    public static void insertNumbs(LinkedList<Double> numbs) {
        Random random = new Random();
        double num;
        for (int i = 0; i < 4; i++) {
            num = Math.round(random.nextDouble(-5, 5) * 100.0) / 100.0;
            numbs.add(num);
        }
    }
}
