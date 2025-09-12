package laba5;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final String girl = "Ж";
        final String boy = "М";

        Student studentValera = addStudent("Валера", boy, 19,
                new ArrayList<>(List.of(5, 5, 5, 5)), new ArrayList<>(List.of(5, 5, 5, 5)));

        Student studentRayana = addStudent("Раяна", girl, 17,
                new ArrayList<>(List.of(5, 5, 5, 4)), new ArrayList<>(List.of(5, 5, 5, 5)));

        Student studentBear = addStudent("Миша", boy, 19,
                new ArrayList<>(List.of(5, 5, 5, 4)), new ArrayList<>());

        Student studentAlina = addStudent("Алина", girl, 19,
                new ArrayList<>(List.of(5, 5, 5, 5)), new ArrayList<>(List.of(5, 5, 5, 5)));

        SchoolChild schoolSahar = addSchoolChild("Сахар", boy, 16,
                true, false, false,
                Map.of(Subjects.MATHEMATICS, 5, Subjects.RUSSIAN, 5, Subjects.HISTORY, 5,
                        Subjects.ENGLISH, 5, Subjects.PHYSICS, 4, Subjects.CHEMISTRY, 4));

        SchoolChild schoolAnna = addSchoolChild("Анна", girl, 15,
                true, false, false,
                Map.of(Subjects.MATHEMATICS, 5, Subjects.RUSSIAN, 5, Subjects.HISTORY, 5,
                        Subjects.ENGLISH, 5, Subjects.PHYSICS, 4, Subjects.CHEMISTRY, 4));

        SchoolChild schoolMilena = addSchoolChild("Милена", girl, 17,
                true, true, true,
                Map.of(Subjects.MATHEMATICS, 5, Subjects.RUSSIAN, 5, Subjects.HISTORY, 5,
                        Subjects.ENGLISH, 5, Subjects.PHYSICS, 4, Subjects.CHEMISTRY, 4));

        ArrayList<SchoolChild> pupils = new ArrayList<>(List.of(schoolSahar, schoolAnna, schoolMilena));
        ArrayList<Student> students = new ArrayList<>(List.of(studentValera, studentAlina, studentRayana, studentBear));
        ArrayList<Learn> learns = new ArrayList<>(List.of(studentValera, studentAlina, studentRayana, studentBear,
                schoolSahar, schoolAnna, schoolMilena));

        checkGirls(pupils, girl);
        checkMarkStudents(students);
        checkAllScholarship(learns);
    }

    public static Student addStudent(String name, String gender, int age, List<Integer> session,
                                     List<Integer> termPapers) {
        try {
            return new Student(name, gender, age, session, termPapers);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static SchoolChild addSchoolChild(String name, String gender, int age, boolean regionOlympiad,
                                             boolean firstPlace, boolean prizeCity, Map<String, Integer> marks) {
        try {
            return new SchoolChild(name, gender, age, regionOlympiad, firstPlace, prizeCity, marks);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return null;

    }

    public static void checkAllScholarship(ArrayList<Learn> learns) {
        System.out.println("\nшкольники и студенты, которые должны получать специальную стипендию:");
        for (Learn learn : learns) {
            if (learn.checkScholarship())
                System.out.println(learn.getAllInfo());
        }

    }

    public static void checkMarkStudents(ArrayList<Student> students) {
        System.out.println("\nстуденты с оценками за курсовые:");
        for (Student student : students) {
            if (!student.checkEmptyMarks())
                System.out.println(student.getAllInfo());
        }
    }

    public static void checkGirls(ArrayList<SchoolChild> pupils, String girl) {
        System.out.println("школьницы-олимпиадницы:");
        for (SchoolChild pupil : pupils) {
            if (girl.equals(pupil.gender) && pupil.checkOlympiad())
                System.out.println(pupil.getInfo());
        }
    }

}
