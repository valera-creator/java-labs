package laba2;

import java.util.Locale;
import java.util.Scanner;

public class TaskFunction {
    public static void main(String[] args) {
        double a, b, e;
        int cntElems;
        double[][] matrix;

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // для проблемы с вводом через точку типа 3.5
        a = getNum(scanner, 'A');
        b = getNum(scanner, 'B');
        e = getNum(scanner, 'E');

        if (a > b) {
            System.out.println("число A больше числа B");
            return;
        }

        if (a == b && b == 0) {
            System.out.println("пустая матрицы");
            return;
        } else
            cntElems = getCntElems(a, b, e);

        matrix = new double[4][cntElems];
        System.out.println(a + " " + b + " " + e + " " + cntElems + "\n");
        if (a != 0 && b != 0)
            addNums(a, e, cntElems, matrix);
        fillMatrix(matrix);
        printMatrix(matrix);

    }

    public static void fillMatrix(double[][] matrix) {
        double val;
        for (int i = 0; i < matrix[0].length; i++) {
            val = matrix[0][i];
            matrix[1][i] = val * val - 10 * val + 15;
            matrix[2][i] = 2 * Math.sin(val + Math.PI / 3);
            matrix[3][i] = Math.exp(Math.sqrt(val)); // возведение экспоненты в степени корня из val
        }

    }

    public static void addNums(double a, double e, int elems, double[][] matrix) {
        for (int i = 0; i < elems; i++) {
            matrix[0][i] = a;
            a += e;
        }
    }

    public static void printMatrix(double[][] matrix) {
        System.out.print("матрица: \n");
        for (double[] i : matrix) {
            for (double j : i) {
                System.out.printf("%5.2f ", j);
            }
            System.out.println();
        }
    }

    public static int getCntElems(double a, double b, double e) {
        int n = 0;
        while (a <= b) {
            a += e;
            n++;
        }
        return n;

    }

    public static double getNum(Scanner scanner, char s) {

        double num;
        while (true) {
            System.out.print("Введите число " + s + ": ");
            if (scanner.hasNextDouble()) { // типо проверка, что тут число введено
                num = scanner.nextDouble();
                if (num < 0)
                    System.out.println("для шага или извлечения корня при заполнение e^(-x) " +
                            "число должно быть не отрицательное");
                else if (num == 0 & s == 'E') {
                    System.out.println("шаг не может быть равен 0");
                } else
                    return num;
            } else {
                System.out.println("Ошибка: не число. Попробуйте снова.");
                scanner.next();
            }
        }
    }
}
