package laba6;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public class SchoolChild extends Learn {
    private int schoolNum;
    private boolean regionalOlympiad;
    private boolean schoolFirstPlace;
    private boolean prizeCity;
    private Map<String, Integer> marks;

    public SchoolChild(String name, String lastname, String gender, int age, int schoolNum, boolean regionalOlympiad,
                       boolean schoolFirstPlace, boolean prizeCity, Map<String, Integer> marks) {
        super(name, lastname, gender, age);
        this.setSchoolNum(schoolNum);
        this.regionalOlympiad = regionalOlympiad;
        this.schoolFirstPlace = schoolFirstPlace;
        this.prizeCity = prizeCity;
        this.setMarks(marks);
    }

    public static final Comparator<SchoolChild> BY_MARK_NUM_SCHOOL = Comparator.comparing(SchoolChild::getAvgScore).
            reversed().thenComparing(SchoolChild::getSchoolNum);

    @Override
    public boolean checkScholarship() {
        return this.checkMarks() && this.checkOlympiad();
    }

    @Override
    public double getAvgScore() {
        double mark = 0;
        int val, cntMarks = 0;

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            val = entry.getValue();
            mark += val;
            cntMarks++;
        }
        if (mark == 0)
            return mark;
        else
            return mark / cntMarks;
    }

    public int getSchoolNum() {
        return this.schoolNum;
    }

    private void setSchoolNum(int schoolNum) {
        if (schoolNum < 1)
            throw new IllegalArgumentException("Ошибка: номер школы не может быть меньше 1");
        else
            this.schoolNum = schoolNum;
    }

    @Override
    public String getAllInfo() {
        StringBuilder info = new StringBuilder(); // исправил String на это по подсказке
        info.append("Имя: ").append(this.name).append(", Фамилия: ").append(this.lastname).append(
                ", Пол: ").append(this.gender).append(", Возраст: ").append(this.age).append(", Школа "
        ).append(this.schoolNum).append(" ");

        if (this.regionalOlympiad)
            info.append("участие в областной олимпиаде: да\n");
        else
            info.append("участие в областной олимпиаде: нет\n");
        if (this.schoolFirstPlace)
            info.append("первое место в школьной олимпиаде: да\n");
        else
            info.append("первое место в школьной олимпиаде: нет\n");
        if (this.prizeCity)
            info.append("призовое в городской в городской олимпиаде: да\n");
        else
            info.append("призовое в городской в городской олимпиаде: нет\n");

        if (this.marks.isEmpty())
            info.append("оценки: нет оценок");
        else {
            info.append("оценки: ");
            for (Map.Entry<String, Integer> entry : marks.entrySet()) {
                info.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
        }
        info.append("\n");
        return info.toString();
    }

    private boolean checkMarks() {
        String key;
        int val;

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            key = entry.getKey();
            val = entry.getValue();
            if (val < 4)
                return false;
            if ((Objects.equals(key, Subjects.MATHEMATICS) || Objects.equals(key, Subjects.RUSSIAN) ||
                    Objects.equals(key, Subjects.HISTORY) || Objects.equals(key, Subjects.ENGLISH)) && val != 5)
                return false;
        }
        return true;
    }

    protected boolean checkOlympiad() {
        return regionalOlympiad || schoolFirstPlace || prizeCity;
    }

    boolean getRegionalOlympiad() {
        return this.regionalOlympiad;
    }

    public boolean getSchoolFirstPlace() {
        return this.schoolFirstPlace;
    }

    public boolean getPrizeCity() {
        return this.prizeCity;
    }

    public void setRegionalOlympiad(boolean regionalOlympiad) {
        this.regionalOlympiad = regionalOlympiad;
    }

    public void setSchoolFirstPlace(boolean schoolFirstPlace) {
        this.schoolFirstPlace = schoolFirstPlace;
    }

    private void setPrizeCity(boolean prizeCity) {
        this.prizeCity = prizeCity;
    }

    public void setMarks(Map<String, Integer> marks) {
        int val;

        if ((!marks.containsKey(Subjects.ENGLISH)) || (!marks.containsKey(Subjects.RUSSIAN)) ||
                (!marks.containsKey(Subjects.MATHEMATICS)) || (!marks.containsKey(Subjects.HISTORY)))
            throw new IllegalArgumentException(Subjects.ENGLISH + ", " + Subjects.RUSSIAN + ", " + Subjects.MATHEMATICS
                    + ", " + Subjects.HISTORY + " должны быть переданы обязательно");
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            val = entry.getValue();
            if (val < 2 || val > 5)
                throw new IllegalArgumentException("оценки должны быть в диапазоне от 2 до 5, нашлось: " + val);
        }
        this.marks = marks;
    }
}
