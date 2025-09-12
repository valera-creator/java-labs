package laba5;

import java.util.Objects;

public abstract class Learn {
    protected String name;
    protected String gender;
    protected int age;

    public Learn(String name, String gender, int age) {
        this.setName(name);
        this.setGender(gender);
        this.setAge(age);
    }

    public String getInfo() {
        return "имя: " + this.name + ", пол: " + gender + ", возраст: " + age;
    }

    public abstract boolean checkScholarship();

    public abstract String getAllInfo();

    public String getName() {
        return this.name;
    }

    public String getGender() {
        return this.gender;
    }

    public int getAge() {
        return this.age;
    }

    // имя и пол смысла изменять нет
    private void setName(String name) {
        if ((!Objects.equals(name, "")) && (!Objects.equals(name, " ")))
            this.name = name;
        else
            throw new IllegalArgumentException("\nОшибка: имя не может быть пустотой или пробелом!");
    }

    private void setGender(String gender) {
        if ((!Objects.equals(gender.toUpperCase(), "Ж")) && (!Objects.equals(gender.toUpperCase(), "М")))
            throw new IllegalArgumentException("\nОшибка: Пол может быть или \"М\", или \"Ж\", нашлось: " + gender);
        else
            this.gender = gender.toUpperCase();
    }

    public void setAge(int age) {
        if (age < 0 || age > 135)
            throw new IllegalArgumentException("\nОшибка: возраст" + age + " некорректный");
        else
            this.age = age;
    }
}
