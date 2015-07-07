package com.nqy.mycode.concurrent;

/**
 * Created by abner on 7/2/15.
 */
public class SynchronizedTest {
    static int tickets = 1000;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("--one bue ticket:" + buyTicket());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("two bue ticket:" + buyTicket());
                }
            }
        }).start();
    }

    static int buyTicket(){
        if(tickets > 0)
            return tickets--;
        else
            return -1;
    }
}
