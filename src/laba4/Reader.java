package laba4;

import java.util.Objects;
import java.time.LocalDate;

public class Reader {
    private String lastNameReader = "Фамилия <не назначено>";
    private Book book = new Book("Название <не назначено>", "Автор <не назначен>");
    private int dayOut = 1;
    private int numMonth = 1;

    // обычный конструктор
    public Reader() {
        System.out.println("для созданного объекта reader установлены значения по умолчанию");
    }

    // конструктор с параметрами
    public Reader(String lastNameReader, Book book, int dayOut, int numMonth) {
        this.setLastNameReader(lastNameReader);
        this.book = book;
        this.setNumMonth(numMonth);
        this.setDayOut(dayOut);
    }

    // конструктор копирования
    public Reader(Reader reader) {
        this.setLastNameReader(reader.lastNameReader);
        this.book = new Book(reader.book); // нет смысла юзать сеттер, т.к. нет проверок никаких на значение
        this.setNumMonth(reader.numMonth);
        this.setDayOut(reader.dayOut);
    }

    public String getLastNameReader() {
        return this.lastNameReader;
    }

    public String getAuthor() {
        return this.book.getAuthor();
    }

    public Book getBook() {
        return this.book;
    }

    public int getDayOut() {
        return this.dayOut;
    }

    public int getNumMonth() {
        return this.numMonth;
    }

    public void setLastNameReader(String lastNameReader) {
        if ((!Objects.equals(lastNameReader, "")) && (!Objects.equals(lastNameReader, " ")))
            this.lastNameReader = lastNameReader;
        else
            throw new IllegalArgumentException("\nОшибка: фамилия не может быть пустотой или пробелом!");
    }

    public void setBook(Book book) {
        this.book = book;
    }


    private void checkCorrectDay(int dayOut) {
        LocalDate check = LocalDate.of(2024, this.numMonth, dayOut);
    }

    private void checkCorrectNumMonth(int numMonth) {
        LocalDate check = LocalDate.of(2024, numMonth, this.dayOut);
    }

    public void setDayOut(int dayOut) {
        this.checkCorrectDay(dayOut);
        this.dayOut = dayOut;
    }

    public void setNumMonth(int numMonth) {
        checkCorrectNumMonth(numMonth);
        this.numMonth = numMonth;
    }

    private void checkTwoValDate(int dayOut, int numMonth) {
        LocalDate check = LocalDate.of(2024, numMonth, dayOut);
    }

    public boolean checkOnTime(int dayOut, int numMonth) {
        this.checkTwoValDate(dayOut, numMonth);

        if (numMonth < this.numMonth)
            return true;
        if (numMonth > this.numMonth)
            return false;
        return dayOut <= this.dayOut;
    }
}
