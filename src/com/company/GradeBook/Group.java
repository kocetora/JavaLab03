package com.company.GradeBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Group {
    private HashMap<Student, List<Score>> studentsScore;

    public Group(int name, int studentsInGroup) {
        List<Student> students = new ArrayList<>();
        for (int n = 0; n < studentsInGroup; n++) {
            students.add(new Student("Student number " + n + " from group " + name));
        }
        studentsScore = new HashMap<>();
        students.forEach(el -> studentsScore.put(el, new ArrayList<Score>()));
    }

    public synchronized HashMap<Student, List<Score>> getStudentsScore() {
        return studentsScore;
    }

    public Set<Student> getStudents() {
        return studentsScore.keySet();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        studentsScore.keySet().forEach(st -> {
            builder.append(st + "   |   ");
            studentsScore.get(st).forEach(score -> {
                builder.append(score.getScoreAssistant() > 9 ? score.getScoreAssistant() : " " + score.getScoreAssistant());
                builder.append(" / ");
                builder.append(score.getScoreLecturer() > 9 ? score.getScoreLecturer() : " " + score.getScoreLecturer());
                builder.append(" | ");
            });
            builder.append("\n");
        });
        return builder.toString();
    }
}
