package laba5;

public abstract class Learn {
    protected String name;
    protected String gender;
    protected int age;

    public Learn(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getInfo() {
        return "имя: " + this.name + ", пол: " + gender + ", возраст: " + age;
    }

    public abstract boolean checkScholarship();

    public abstract String getAllInfo();
}
