package com.nqy.mycode.annotations;

/**
 * Created by abner on 7/22/15.
 */
public class AnnotationUseExample {
    @FieldInfo(value = 3)
    static String s = "i'm s";

    @MethodInfo(date = "7/22/2015",
    version = 2)
    @SuppressWarnings({"deprecation"})
    public void sayHi(){

        MyClass myClass = new MyClass();
        myClass.getMyName();
    }
}
