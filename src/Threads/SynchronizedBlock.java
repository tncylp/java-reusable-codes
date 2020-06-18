package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedBlock {

    private static Random random = new Random();

    private static List<Integer> firstList = new ArrayList<>();
    private static List<Integer> secondList = new ArrayList<>();

    private static Object firstLock = new Object();
    private static Object secondLock = new Object();

    public static void stageOne(){
        synchronized (firstLock){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            firstList.add(random.nextInt(100));
        }
    }

    public static void stageTwo(){
        synchronized (secondLock) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            secondList.add(random.nextInt(100));
        }
    }
    
    public static void process(){
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start));
        System.out.println("First List: " + firstList.size() + "  Second List: " + secondList.size());
    }



}
