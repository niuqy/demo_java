package com.nqy.mycode.annotations;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by abner on 7/23/15.
 */
@Setter
@Getter
public class Person {
    private String name;
    private int age;

    @Override
    public String toString(){
        return "haha ,i fix the problem by updating the version of Idea,"+super.toString();
    }
}
