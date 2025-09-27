package laba7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ArrayIntNumbs {
    public static void main(String[] args) {
        ArrayList<Integer> numbs = new ArrayList<>();
        insertNumbs(numbs);

        System.out.println("Полученный ArrayList: " + numbs);
        searchMax(numbs);
        searchLastIndexMax(numbs);
        sortedList(numbs);
        deleteNegative(numbs);

    }

    public static void searchMax(ArrayList<Integer> numbs) {
        if (numbs.isEmpty()) {
            System.out.println("Нет чисел для поиска максимума");
            return;
        }
        System.out.printf("Максимальный элемент: %d\n", Collections.max(numbs));
    }

    public static void searchLastIndexMax(ArrayList<Integer> numbs) {
        int max;
        if (numbs.isEmpty()) {
            System.out.println("Нет чисел для поиска последнего элемента, равного максимальному");
            return;
        }
        max = Collections.max(numbs);
        System.out.println("Номер последнего элемента, равного максимальному: " + (numbs.lastIndexOf(max) + 1));

    }

    public static void sortedList(ArrayList<Integer> numbs) {
        if (numbs.isEmpty()) {
            System.out.println("Нет чисел для сортировки");
            return;
        }
        Collections.sort(numbs);
        System.out.println("Отсортированный ArrayList: " + numbs);
    }

    public static void deleteNegative(ArrayList<Integer> numbs) {
        if (numbs.isEmpty()) {
            System.out.println("Не удалось удалить отрицательные числа из пустого списка");
            return;
        }
        for (int i = numbs.size() - 1; i >= 0; i--) {
            if (numbs.get(i) < 0)
                numbs.remove(numbs.get(i));
        }
        System.out.println("Полученный список после удаления отрицательных чисел: " + numbs);

    }

    public static void insertNumbs(ArrayList<Integer> numbs) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            numbs.add(rand.nextInt(-100, 100));
        }

    }
}
