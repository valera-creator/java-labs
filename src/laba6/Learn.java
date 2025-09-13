package laba6;

import java.util.Objects;

public abstract class Learn {
    protected String name;
    protected String lastname;
    protected String gender;
    protected int age;

    public Learn(String name, String lastname, String gender, int age) {
//        типа проверка в конструкторе класса
//        if (age < 0 || age > 135)
//            throw new IllegalArgumentException("возраст некорректный");
//        else
//            this.age = age;

        this.setName(name);
        this.setLastname(lastname);
        this.setGender(gender);
        this.setAge(age);
    }

    public String toString() {
        return "имя: " + this.name + ", фамилия:" + this.lastname + ", пол: " + gender + ", возраст: " + age;
    }


    public abstract boolean checkScholarship();

    public abstract String getAllInfo();

    public String getName() {
        return this.name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    private void checkCorrectName(String s, String text) {
        if (!(this.capitalize(s)).equals(s))
            throw new IllegalArgumentException(text + " не соотвествует правильному формату");
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    private void setName(String name) {
        if ((!Objects.equals(name, "")) && (!Objects.equals(name, " ")))
            try {
                checkCorrectName(name, "Имя");
                this.name = name;
            } catch (IllegalArgumentException e) {
                this.name = capitalize(name);
                System.err.println("Исправлена ошибка формата имени " + "\"" + name + "\" на " + this.name);
            }
        else
            throw new IllegalArgumentException("\nОшибка: имя не может быть пустотой или пробелом!");
    }

    private void setLastname(String lastname) {
        if ((!Objects.equals(lastname, "")) && (!Objects.equals(lastname, " ")))
            try {
                checkCorrectName(lastname, "Фамилия");
                this.lastname = lastname;
            } catch (IllegalArgumentException e) {
                this.lastname = capitalize(lastname);
                System.err.println("Исправлена ошибка формата фамилии " + "\"" + lastname + "\" на " + this.lastname);
            }
        else
            throw new IllegalArgumentException("\nОшибка: фамилия не может быть пустотой или пробелом!");
    }

    private void setGender(String gender) {
        if ((!Objects.equals(gender.toUpperCase(), "Ж")) && (!Objects.equals(gender.toUpperCase(), "М")))
            throw new IllegalArgumentException("\nОшибка: Пол может быть или \"М\", или \"Ж\", нашлось: " + gender);
        else
            this.gender = gender.toUpperCase();
    }

    public void setAge(int age) {
        if (age < 0 || age > 135)
            throw new IllegalArgumentException("возраст некорректный");
        else
            this.age = age;
    }
}
