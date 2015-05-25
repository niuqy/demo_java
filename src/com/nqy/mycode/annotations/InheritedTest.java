package com.nqy.mycode.annotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by abner on 5/25/15.
 */
public class InheritedTest {
    public static void main(String[] args) {
        System.out.println(Parent.class.isAnnotationPresent(CouldBeInherited.class));//output:true
        System.out.println(Child.class.isAnnotationPresent(CouldBeInherited.class));//output:true

        System.out.println(ParentInterface.class.isAnnotationPresent(CouldBeInherited.class));//output:true
        System.out.println(ChildInterface.class.isAnnotationPresent(CouldBeInherited.class));//output:false
    }
}

/**
 * Indicates that an annotation type is automatically inherited.only causes annotations to be inherited from superclass
 * annotations on implemented interfaces have no effect.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface CouldBeInherited {
    boolean isInherited() default true;
    String doSomething() default "Do what?";
}

@CouldBeInherited
class Parent{

}

class Child extends Parent{

}

@CouldBeInherited
interface ParentInterface {

}

class ChildInterface implements ParentInterface{

}
