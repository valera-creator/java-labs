package laba2;

import java.util.Random;

public class LocalMin {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] matrix = new int[8][8];

        addNum(random, matrix);
        printMatrix(matrix);
        searchLocalMin(matrix);

    }

    public static void searchLocalMin(int[][] matrix) {
        int curNum, cntLocalMin = 0;
        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[0].length - 1; j++) {
                curNum = matrix[i][j];
                if (curNum < matrix[i - 1][j] && curNum < matrix[i][j - 1] && curNum < matrix[i + 1][j] &&
                        curNum < matrix[i][j + 1]) {
                    cntLocalMin++;
                    System.out.printf("[%d][%d]: %d\n", i, j, matrix[i][j]);
                }
            }
        }
        System.out.println("локальных минимумов: " + cntLocalMin);
    }

    public static void printMatrix(int[][] matrix) {
        System.out.print("матрица: \n");
        for (int[] i : matrix) {
            for (int j : i) {
                System.out.printf("%3d ", j);
            }
            System.out.println();
        }
    }

    public static void addNum(Random random, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(-10, 11);
            }
        }
    }
}