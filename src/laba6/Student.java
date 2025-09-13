package laba6;

import java.util.List;

public class Student extends Learn {
    private List<Integer> session;
    private List<Integer> termPapers;

    public Student(String name, String lastname, String gender, int age, List<Integer> session,
                   List<Integer> termPapers) {
        super(name, lastname, gender, age);
        this.setSession(session);
        this.setTermPapers(termPapers);
    }

    @Override
    public boolean checkScholarship() {
        return this.checkSession() && this.checkTermPapers();
    }

    @Override
    public double getAvgScore() {
        double markSession = 0;
        int cntMarks = 0;
        for (int mark : this.session) {
            markSession += mark;
            cntMarks++;
        }
        if (markSession == 0)
            return markSession;
        else
            return markSession / cntMarks;
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
        info.append("\nИмя: ").append(this.name).append(", Фамилия: ").append(this.lastname).append(", Пол: ").append(
                this.gender).append(", Возраст: ").append(this.age).append(", Студент;\n");
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

    private void checkCorrectMarks(List<Integer> marks) {
        for (int mark : marks) {
            if (mark < 2 || mark > 5)
                throw new IllegalArgumentException("оценки должны быть в диапазоне от 2 до 5, нашлось " + mark);
        }
    }

    public List<Integer> getSession() {
        return this.session;
    }

    public List<Integer> getTermPapers() {
        return this.termPapers;
    }

    public void setSession(List<Integer> marks) {
        checkCorrectMarks(marks);
        if (marks.isEmpty())
            throw new IllegalArgumentException("передан пустой список оценок");
        this.session = marks;
    }

    public void setTermPapers(List<Integer> marks) {
        checkCorrectMarks(marks);
        this.termPapers = marks;
    }
}
