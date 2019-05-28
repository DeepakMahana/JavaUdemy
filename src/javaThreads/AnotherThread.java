package javaThreads;

import static javaThreads.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {

    @Override
    public void run(){
        System.out.println(ANSI_BLUE + "Hello From " + currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another Thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE + "Five seconds have passed and I'm awake");
    }
}
