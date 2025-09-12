package laba1;

public class Table {
    public static void main(String[] args) {
        usual_print();
        table_print();
    }

    public static void usual_print() {
        System.out.println("обычный вывод");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i + " × " + j + " = " + i * j + "\t");
            }
            System.out.println();

        }
    }

    public static void table_print() {
        System.out.println("\nтабличный вывод");
        System.out.println("-------------------------------------------------------------");

        // заголовок цифр
        System.out.print("|     |");
        for (int j = 1; j <= 9; j++) {
            System.out.printf("  %d  |", j);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------");

        // Строки таблицы
        for (int i = 1; i <= 9; i++) {
            System.out.printf("|  %d  |", i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf(" %2d  |", i * j);
            }
            System.out.println();
            System.out.println("-------------------------------------------------------------");
        }
    }
}
