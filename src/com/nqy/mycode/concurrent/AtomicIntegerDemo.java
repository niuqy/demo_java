package com.nqy.mycode.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by abner on 6/30/15.
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {

        //dedicate that the value of AtomicInteger is valid in one thread,doesn't conflict between different thread
        new Thread(new MyRunnable("m1")).start();
        new Thread(new MyRunnable("m2")).start();
    }
    static void v(Object obj)
    {
        System.out.println(obj);
    }

    static class MyRunnable implements Runnable{
        private String name;
        public MyRunnable(String name){
            this.name = name;
        }

        @Override
        public void run() {
            AtomicInteger ai=new AtomicInteger(1);
            for(int i=0;i<5;i++){
                v(name+":"+ai.incrementAndGet());
            }
        }
    }
}
