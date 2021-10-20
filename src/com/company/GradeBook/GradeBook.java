package com.company.GradeBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GradeBook {
    private List<Group> groups;
    private boolean[] flagsForAssistants;
    private boolean flagForLecturer;
    private int week;

    public GradeBook(int groups, int studentsInGroup) {
        this.groups = new ArrayList<>();
        for (int g = 1; g <= groups; g++) {
            this.groups.add(new Group(g, studentsInGroup));
        }
        flagsForAssistants = new boolean[groups];
        flagsForAssistants[0] = true;
    }

    public synchronized void putScoreByAssistant(int groupNumber) throws InterruptedException {
        while (!flagsForAssistants[groupNumber]){
            wait();
        }
        Random r = new Random();
        groups.get(groupNumber).getStudents()
                .forEach(st -> groups.get(groupNumber).getStudentsScore().get(st).add(new Score(
                        r.nextInt(5) > 2 ? r.nextInt(41) + 60 : 0)));
        changeFlag();
        notifyAll();
    }

    public synchronized void putScoreByLecturer(int week) throws InterruptedException{
        while (!flagForLecturer){
            wait();
        }
        this.week = week;
        Random r = new Random();
        for (int i = 0; i < groups.size(); i++) {
            int finalI = i;
            groups.get(i).getStudents()
                    .forEach(st -> groups.get(finalI).getStudentsScore().get(st).get(week).setScoreLecturer(
                            r.nextInt(5) > 2 ? r.nextInt(41) + 60 : 0));
        }
        changeFlag();
        System.out.println(this);
        notifyAll();
    }

    public void changeFlag() {
        for (int i = 0; i < flagsForAssistants.length; i++) {
            if (flagsForAssistants[i] && i < flagsForAssistants.length - 1) {
                flagsForAssistants[i] = false;
                flagsForAssistants[i + 1] = true;
                return;
            }
        }
        if (flagForLecturer) {
            flagsForAssistants[0] = true;
            flagForLecturer = false;
        } else {
            flagsForAssistants[flagsForAssistants.length - 1] = false;
            flagForLecturer = true;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Week:  ");
        builder.append(week + 1);
        builder.append("\n");
        for (int i = 0; i < groups.size(); i++) {
            builder.append("Group number ");
            builder.append(i + 1);
            builder.append("  (Score from  Assistant / Lecturer)\n");
            builder.append(groups.get(i).toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}

