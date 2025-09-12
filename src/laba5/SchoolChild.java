package laba5;

import java.util.Map;
import java.util.Objects;

public class SchoolChild extends Learn {
    private boolean regionalOlympiad;
    private boolean schoolFirstPlace;
    private boolean prizeCity;
    private Map<String, Integer> marks;

    public SchoolChild(String name, String gender, int age, boolean regionalOlympiad,
                       boolean schoolFirstPlace, boolean prizeCity, Map<String, Integer> marks) {
        super(name, gender, age);
        this.regionalOlympiad = regionalOlympiad;
        this.schoolFirstPlace = schoolFirstPlace;
        this.prizeCity = prizeCity;
        this.setMarks(marks);
    }

    @Override
    public boolean checkScholarship() {
        return this.checkMarks() && this.checkOlympiad();
    }

    @Override
    public String getAllInfo() {
        StringBuilder info = new StringBuilder(); // исправил String на это по подсказке
        info.append("Имя: ").append(this.name).append(", Пол: ").append(this.gender).append(
                ", Возраст: ").append(this.age).append(", Школ;\n");
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
            info.append("оценки:\n");
            for (Map.Entry<String, Integer> entry : marks.entrySet()) {
                info.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
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

    public boolean getRegionalOlympiad() {
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

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            val = entry.getValue();
            if (val < 2 || val > 5)
                throw new IllegalArgumentException("оценки должны быть в диапазоне от 2 до 5");
        }
        this.marks = marks;
    }
}
