package laba2;

import java.util.Random;

public class Decreasing {
    public static void main(String[] args) {
        Random random = new Random();
        int cntThree;
        int[] numbers = new int[20];
        int[] newNumbers;
        addNum(random, numbers);
        printNums(numbers);

        cntThree = getCntEndThree(numbers);
        newNumbers = new int[cntThree];

        makeFillEndThree(numbers, newNumbers);
        if (cntThree != 0)
            System.out.println("отсортированный массив с числами, оканчивающимися на 3");
        else {
            System.out.println("нет чисел, подходящих под условие");
            return;
        }

        sortArr(newNumbers);
        printNums(newNumbers);


    }

    public static void sortArr(int[] arr) {
        int save;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[i] > arr[j]) {
                    save = arr[i];
                    arr[i] = arr[j];
                    arr[j] = save;
                }
            }
        }
    }

    public static void makeFillEndThree(int[] numbers, int[] newNumbers) {
        int curIndex = 0;
        for (int num : numbers) {
            if (num % 10 == 3) {
                newNumbers[curIndex] = num;
                curIndex++;
            }
        }
    }

    public static int getCntEndThree(int[] numbers) {
        int cntThree = 0;
        for (int num : numbers) {
            if (num % 10 == 3)
                cntThree++;
        }
        return cntThree;
    }

    public static void printNums(int[] numbers) {
        System.out.print("числа: ");
        for (int num : numbers)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void addNum(Random random, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1, 1001); // от 0 до 1000 включительно
        }
    }

}
