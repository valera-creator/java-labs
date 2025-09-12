package laba2;

import java.util.Random;

public class Symmetrical {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[20];
        addNum(random, numbers);

        System.out.print("числа: ");
        for (int num : numbers)
            System.out.print(num + " ");
        System.out.println();

        searchThreeDigitSymmetrical(numbers);
    }

    public static boolean checkThreeDigit(int num) {
        return 100 <= num && num <= 999;
    }

    public static void searchThreeDigitSymmetrical(int[] numbers) {
        int oneDigit, threeDigit, cntGood = 0, summa = 0;
        for (int num : numbers) {
            if (checkThreeDigit(num)) {
                oneDigit = (num / 100) % 10;
                threeDigit = num % 10;

                if (oneDigit == threeDigit) {
                    cntGood++;
                    summa += num;
                    System.out.println("число " + num + " подошло");
                }
            }
        }
        System.out.println("всего чисел: " + cntGood + ", сумма подходящих чисел: " + summa);
    }

    public static void addNum(Random random, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1001); // от 0 до 1000 включительно
        }
    }

}
