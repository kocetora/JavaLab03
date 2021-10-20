package com.company.GradeBook;

public class LecturerThread extends Thread {

    private GradeBook gradeBook;
    private int weeks;

    public LecturerThread(GradeBook gradeBook, int weeks) {
        this.gradeBook = gradeBook;
        this.weeks = weeks;
    }

    @Override
    public void run(){
        try {
            for (int w = 0; w < weeks; w++) {
                gradeBook.putScoreByLecturer(w);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e){}
    }
}

