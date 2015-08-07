package com.nqy.mycode.jni;

/**
 * Created by abner on 8/6/15.
 */
public class Person {
    static {
        System.out.println("-----" + System.getProperty("java.library.path"));
        System.loadLibrary("hello");
    }

    public native String getName();

    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.getName());
    }
}
