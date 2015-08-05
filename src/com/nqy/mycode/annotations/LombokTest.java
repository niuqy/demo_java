package com.nqy.mycode.annotations;

/**
 * Created by abner on 7/23/15.
 */
public class LombokTest {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(30);
        p.setName("Abner");
        System.out.println(p.toString());

        Student s = new Student();
        s.setName("Mike");
        s.setScore(100);
        System.out.println(s.toString());

    }
}
