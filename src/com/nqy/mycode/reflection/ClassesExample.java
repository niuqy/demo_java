package com.nqy.mycode.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by abner on 7/22/15.
 */
public class ClassesExample {
    public static void main(String[] args) {
        /**
         * the ways to obtain Class
         */
        Class clazz = MyClass.class;
        try {
            clazz = Class.forName("com.nqy.mycode.reflection.MyClass"); //if you only know the name of the class,using the full identify name
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * get class name
         */
        String fullName = clazz.getName();
        String simpleName = clazz.getSimpleName();
        System.out.println(fullName);
        System.out.println(simpleName);

        /**
         * Modifier
         */
        int modifiers = clazz.getModifiers();
        Modifier.isPublic(modifiers);

        /**
         * Package
         */
        Package aPackage = clazz.getPackage();
        String packageName = aPackage.getName();
        System.out.println(packageName);

        /**
         * SupperClass
         */
        Class superClass = clazz.getSuperclass();

        /**
         * Implemented Interfaces
         */
        Class[] interfaces = clazz.getInterfaces();

        /**
         * Constructors
         */
        Constructor[] constructors = clazz.getConstructors();

        /**
         * Methods
         */
        Method[] method = clazz.getMethods();

        /**
         * Fields
         */
        Field[] fields = clazz.getFields();

        /**
         * Annotation
         */
        Annotation[] annotations = clazz.getAnnotations();
    }
}
