package ru.job4j.improvements;

public class Student implements Comparable<Student> {

    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.scope, o.scope);
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }
}
