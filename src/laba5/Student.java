package laba5;

import java.util.List;

public class Student extends Learn {
    private List<Integer> session;
    private List<Integer> termPapers;

    public Student(String name, String gender, int age, List<Integer> session, List<Integer> termPapers) {
        super(name, gender, age);
        this.session = session;
        this.termPapers = termPapers;
    }

    @Override
    public boolean checkScholarship() {
        return this.checkSession() && this.checkTermPapers();
    }

    protected boolean checkEmptyMarks() {
        return termPapers.isEmpty();
    }

    private boolean checkSession() {
        double markSession = 0, doorstep = 4.75;
        int cntMarks = 0;
        if (session.isEmpty())
            return false;
        for (int mark : this.session) {
            markSession += mark;
            cntMarks++;
        }
        return markSession / cntMarks >= doorstep;
    }

    private boolean checkTermPapers() {
        if (this.termPapers.isEmpty())
            return false;
        for (int mark : this.termPapers) {
            if (mark != 5)
                return false;
        }
        return true;
    }

    @Override
    public String getAllInfo() {
        StringBuilder info = new StringBuilder(); // исправил String на это по подсказке
        info.append("\nИмя: ").append(this.name).append(", Пол: ").append(this.gender).append(
                ", Возраст: ").append(this.age).append(", Студент;\n");
        info.append("Оценки за сессию: ");
        if (session.isEmpty())
            info.append("оценок за сессию нет;\n");
        else {
            for (int mark : this.session)
                info.append(mark).append(" ");
        }
        info.append("\nОценки за курсовые: ");
        if (termPapers.isEmpty())
            info.append("оценок за курсовые нет;\n");
        else {
            for (int mark : this.termPapers)
                info.append(mark).append(" ");
        }
        info.append("\n");
        return info.toString();
    }
}
