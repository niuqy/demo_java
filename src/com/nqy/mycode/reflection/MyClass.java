package com.nqy.mycode.reflection;

/**
 * Created by abner on 7/22/15.
 */
public class MyClass {
    private String who = "";

    public MyClass(){

    }

    public MyClass(String who){
        this.who = who;
    }
    public void sayHi(){
        System.out.println("hi,greeting from " + who +" in MyClass");
    }
}
