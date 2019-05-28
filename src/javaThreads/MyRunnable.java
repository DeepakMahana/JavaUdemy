package javaThreads;

import static javaThreads.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello From MyRunnable");
    }
}

