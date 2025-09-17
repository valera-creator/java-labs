package laba6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final String girl = "Ж";
        final String boy = "М";

        Student studentValera = addStudent("Валера", "Ларионов", boy, 19,
                new ArrayList<>(List.of(5, 5, 5, 5)), new ArrayList<>(List.of(5, 5, 5, 5)));

        Student studentRayana = addStudent("Раяна", "Мачукаева", girl, 17,
                new ArrayList<>(List.of(5, 5, 5, 4)), new ArrayList<>(List.of(5, 5, 5, 5)));

        Student studentBear = addStudent("миШа", "Урываев", boy, 19,
                new ArrayList<>(List.of(5, 5, 5, 4)), new ArrayList<>());

        Student studentAlina = addStudent("Алина", "Скворцова", girl, 19,
                new ArrayList<>(List.of(5, 5, 5, 5)), new ArrayList<>(List.of(5, 5, 5, 5)));

        SchoolChild schoolSahar = addSchoolChild("Илья", "Сахаров", boy, 16, 76,
                true, false, false,
                Map.of(Subjects.MATHEMATICS, 5, Subjects.RUSSIAN, 5, Subjects.HISTORY, 5,
                        Subjects.ENGLISH, 5, Subjects.PHYSICS, 4, Subjects.CHEMISTRY, 4));

        SchoolChild schoolAnna = addSchoolChild("Анна", "Аннина", girl, 15, 1,
                true, false, false,
                Map.of(Subjects.MATHEMATICS, 5, Subjects.RUSSIAN, 5, Subjects.HISTORY, 5,
                        Subjects.ENGLISH, 5, Subjects.PHYSICS, 4, Subjects.CHEMISTRY, 4));

        SchoolChild schoolMilena = addSchoolChild("Милена", "Миленина", girl, 17, 1,
                true, true, true,
                Map.of(Subjects.MATHEMATICS, 5, Subjects.RUSSIAN, 5, Subjects.HISTORY, 4,
                        Subjects.ENGLISH, 5, Subjects.PHYSICS, 4, Subjects.CHEMISTRY, 4));

        ArrayList<SchoolChild> pupils = new ArrayList<>(List.of(schoolSahar, schoolAnna, schoolMilena));
        ArrayList<Student> students = new ArrayList<>(List.of(studentValera, studentAlina, studentRayana, studentBear));
        ArrayList<Learn> learns = new ArrayList<>(List.of(studentValera, studentAlina, studentRayana, studentBear,
                schoolSahar, schoolAnna, schoolMilena));


        SchoolChild.checkGirls(pupils, girl);
        Student.checkMarkStudents(students);
        Learn.checkAllScholarship(learns);

        SchoolChild.bestSchool(pupils);
        Student.bestStudent(students);

        Student.sortedStudents(students);
        SchoolChild.sortedSchoolChildren(pupils);
    }

    public static Student addStudent(String name, String lastname, String gender, int age, List<Integer> session,
                                     List<Integer> termPapers) {
        try {
            return new Student(name, lastname, gender, age, session, termPapers);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static SchoolChild addSchoolChild(String name, String lastname, String gender, int age, int schoolNum,
                                             boolean regionOlympiad, boolean firstPlace, boolean prizeCity,
                                             Map<String, Integer> marks) {
        try {
            return new SchoolChild(name, lastname, gender, age, schoolNum, regionOlympiad, firstPlace, prizeCity, marks);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return null;

    }
}
