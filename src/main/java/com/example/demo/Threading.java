package com.example.demo;

public class Threading {
    public static void main(String[] args) {
        Threading threading = new Threading();
        int i = 0;
        while (i < 100) {
            threading.start();
            i++;
            System.out.println();
        }
    }

    private void start() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 calling");
                process();
                System.out.println("thread1 done");
            }
        });

        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 calling");
                process();
                System.out.println("thread2 done");
            }
        });

        thread2.start();

    }

    private synchronized void process() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
