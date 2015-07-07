package com.nqy.mycode.concurrent;

/**
 * Created by abner on 7/7/15.
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        new Thread(myRunnable,"t-0").start();
        new Thread(myRunnable,"t-1").start();
        myRunnable.run();
    }
}

class MyRunnable implements Runnable{
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();//threadLocal's value will not be overridden

    private Setter<Integer> setter = new Setter<Integer>();//setter's value will be overridden

    @Override
    public void run() {
        threadLocal.set( (int) (Math.random() * 100D) );
        setter.set((int) (Math.random() * 100D) );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(Thread.currentThread().getName()+" threadLocal:"+threadLocal.get());
        System.out.println(Thread.currentThread().getName()+" setter:"+setter.get());
    }
}

class Setter<T>{
    private T value;
    public void set(T obj){
        this.value = obj;
    }
    public T get(){
        return value;
    }
}
