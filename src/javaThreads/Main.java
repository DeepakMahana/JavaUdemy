package javaThreads;

import static javaThreads.ThreadColor.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello From Main Thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread() {
            public void run(){
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread");
            }
        }.start();

//        Thread runnable = new Thread(new MyRunnable());
//        runnable.start();

        Thread myRunnable = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from anonymous class thread");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timedout , so I'm running again");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I couldn't wait after all. I was interrupted");
                }
            }
        });

        myRunnable.start();


        System.out.println(ANSI_PURPLE + "Hello Again from Main Thread");

    }
}
