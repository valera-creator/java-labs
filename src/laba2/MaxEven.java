package laba2;

import java.util.Random;

public class MaxEven {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[20];
        addNum(random, numbers);
        printNums(numbers);
        searchMaxEven(numbers);
    }

    public static void printNums(int[] numbers) {
        System.out.print("числа: ");
        for (int num : numbers)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void searchMaxEven(int[] numbers) {
        boolean isMax = false;
        int maxNum = -1;

        for (int num : numbers) {
            if (num % 2 == 0) {
                if (!isMax) {
                    isMax = true;
                    maxNum = num;
                } else {
                    if (num > maxNum)
                        maxNum = num;
                }
            }
        }

        if (isMax)
            System.out.println("максимальное четное число: " + maxNum);
        else
            System.out.println("максимальное четное число не найдено");
    }

    public static void addNum(Random random, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1001); // от 0 до 1000 включительно
        }
    }
}
