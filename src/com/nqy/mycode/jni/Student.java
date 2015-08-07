package com.nqy.mycode.jni;

/**
 * Created by abner on 8/6/15.
 */
public class Student {
    static {
        System.loadLibrary("hello");
    }

    public native String getName();

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getName());
    }
}
