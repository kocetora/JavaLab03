package com.company.GradeBook;

import java.util.Objects;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
