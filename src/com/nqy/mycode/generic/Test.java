package com.nqy.mycode.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by abner on 6/1/15.
 */
public class Test {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//        GenericFactory<String> factory = new GenericFactory(String.class);
//        String s = factory.createInstance();
//
//        String s2 = "s";
//        ArrayList<String> list = new ArrayList<String>();
//        System.out.println(addAndReturn(s2, list));
//
        String s3 = getInstance(String.class);
        double i3 = getInstance(double.class);

        processMethod(new ArrayList<A>());
    }

    static void processMethod(List<? super A> list){

    }

    class A{}
    class B extends A{}
    class C extends A{}

    private static <T> T addAndReturn(T element,Collection<T> collection){
        collection.add(element);
        return element;
    }

    private static <T> T getInstance(Class<T> aClass) throws IllegalAccessException, InstantiationException {
        return aClass.newInstance();
    }

    public void processElements(List<? super A> elements){
        for(Object a : elements){
            //do something
        }
    }
}
