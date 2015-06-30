package com.nqy.mycode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by abner on 6/30/15.
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger ai=new AtomicInteger(0);
        v(ai.get());
        System.out.println(ai.compareAndSet(0,5));
        v(ai.get());

    }
    static void v(int i)
    {
        System.out.println("i : "+i);
    }
}
