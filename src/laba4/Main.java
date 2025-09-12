package laba4;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Java 8. Полное руководство", "Г. Шилдт");
        Book book2 = new Book("Крейцерова соната", "Л. Толстой");

        Reader reader1 = new Reader("Петров", book1, 25, 3);
        Reader reader2 = new Reader("Васечкин", book2, 1, 4);

        printInfo(reader1, 29, 3);
        printInfo(reader2, 29, 3);
    }

    private static void printInfo(Reader reader, int dayOut, int numMonth) {
        if (reader.checkOnTime(dayOut, numMonth))
            System.out.println(reader.getLastNameReader() + " сдал вовремя! ✅");
        else
            System.out.println(reader.getLastNameReader() + " сдал не вовремя! ❌");
    }
}
