package com.company.GradeBook;

public class AssistantThread extends Thread {

    private GradeBook gradeBook;
    private int group;
    private int weeks;

    public AssistantThread(GradeBook gradeBook, int group, int weeks) {
        this.gradeBook = gradeBook;
        this.group = group;
        this.weeks = weeks;
    }

    @Override
    public void run() {
        try {
            for (int w = 0; w < weeks; w++) {
                gradeBook.putScoreByAssistant(group);
            }
        } catch (InterruptedException e) {
        }
    }
}

