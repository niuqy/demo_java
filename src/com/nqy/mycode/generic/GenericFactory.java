package com.nqy.mycode.generic;

import java.util.List;

/**
 * Created by abner on 6/1/15.
 */
public class GenericFactory<E> {
    Class theClass = null;

    public GenericFactory(Class aClass){
        this.theClass = aClass;
    }

    public E createInstance() throws IllegalAccessException, InstantiationException {
        return (E)theClass.newInstance();
    }
}
