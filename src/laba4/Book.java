package laba4;

import java.util.Objects;

public class Book {
    private String nameBook = "Название <не назначено>";
    private String author = "Автор <не назначен>";

    // обычный конструктор
    public Book() {
        System.out.println("для созданного объекта book установлены значения по умолчанию");
    }

    // конструктор с параметрами
    public Book(String nameBook, String author) {
        this.setNameBook(nameBook);
        this.setAuthor(author);
    }

    // конструктор копирования
    public Book(Book book) {
        this.setNameBook(book.nameBook);
        this.setAuthor(book.author);
    }

    public String getNameBook() {
        return this.nameBook;
    }

    public String getAuthor() {
        return this.author;
    }

    private void setNameBook(String newName) {
        if ((!Objects.equals(newName, "")) && (!Objects.equals(newName, " ")))
            this.nameBook = newName;
        else
            throw new IllegalArgumentException("\nОшибка: имя не может быть пустотой или пробелом!");
    }

    private void setAuthor(String newAuthor) {
        if ((!Objects.equals(newAuthor, "")) && (!Objects.equals(newAuthor, " ")))
            this.author = newAuthor;
        else
            throw new IllegalArgumentException("\nОшибка: автор не может быть пустотой или пробелом!");
    }
}
