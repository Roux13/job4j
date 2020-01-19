package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {

        Student student = new Student();
        student.setFio("Ivanov Ilya Petrovich");
        student.setGroup(4);
        student.setAcceptance(new Date());

        System.out.println(student.getFio());
        System.out.println(student.getGroup());
        System.out.println(student.getAcceptance());
    }

}
