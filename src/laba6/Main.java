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


        checkGirls(pupils, girl);
        checkMarkStudents(students);
        checkAllScholarship(learns);

        bestSchool(pupils);
        bestStudent(students);

        sortedStudents(students);
        sortedSchoolChildren(pupils);
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

    public static void bestSchool(ArrayList<SchoolChild> pupils) {
        double maxMark = -1;
        if (pupils.isEmpty()) {
            System.out.println("\nнет школьников");
            return;
        }

        pupils.sort(SchoolChild.BY_MARK.reversed());
        System.out.println("\nbest из школы: ");
        for (SchoolChild schoolChild : pupils) {
            if (maxMark == -1)
                maxMark = schoolChild.getAvgScore();
            else if (maxMark > schoolChild.getAvgScore()) {
                return;
            }
            System.out.println(schoolChild);
        }
    }

    public static void sortedStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("\nнет студентов");
            return;
        }
        students.sort(Student.BY_MARK.reversed());
        System.out.println("\nстуденты, отсортированные по рейтингу успеваемости");
        for (Student student : students)
            System.out.println(student);

    }

    public static void sortedSchoolChildren(ArrayList<SchoolChild> pupils) {
        if (pupils.isEmpty()) {
            System.out.println("\nнет школьников");
            return;
        }
        pupils.sort(SchoolChild.BY_MARK_NUM_SCHOOL);
        System.out.println("\nшкольники, отсортированные по успеваемости и номеру школы");
        for (SchoolChild schoolChild : pupils)
            System.out.println(schoolChild.getAllInfo());

    }

    public static void bestStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("\nнет студентов");
            return;
        }
        double maxMark = -1;
        students.sort(Student.BY_MARK.reversed());
        System.out.println("\nbest студенты: ");
        for (Student student : students) {
            if (maxMark == -1)
                maxMark = student.getAvgScore();
            else if (maxMark > student.getAvgScore()) {
                return;
            }
            System.out.println(student);
        }
    }

    public static void checkAllScholarship(ArrayList<Learn> learns) {
        ArrayList<Learn> listScholarShip = new ArrayList<>();
        System.out.println("\nшкольники и студенты, которые должны получать специальную стипендию:");
        for (Learn learn : learns) {
            if (learn.checkScholarship())
                listScholarShip.add(learn);
        }
        listScholarShip.sort(Learn.BY_LASTNAME);
        for (Learn learn : listScholarShip)
            System.out.println(learn);
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
                System.out.println(pupil);
        }
    }
}
