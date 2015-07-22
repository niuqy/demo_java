package com.nqy.mycode.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by abner on 7/22/15.
 */
public class ConstructorslExample {
    public static void main(String[] args) {
        Class aClass = MyClass.class;

        /**
         * get all public constructors declared in the class
         */
        Constructor[] constructors = aClass.getConstructors();

        /**
         * get specified constructor
         */
        Constructor constructor = null;
        try {
            constructor = aClass.getConstructor(new Class[]{String.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        /**
         * Instantiating Objects using Constructor Object
         */
        try {
            MyClass myClass = (MyClass) constructor.newInstance("ConstructorslExample");
            myClass.sayHi();

            constructor = aClass.getConstructor();
            myClass = (MyClass) constructor.newInstance();
            myClass.sayHi();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
