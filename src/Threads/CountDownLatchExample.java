package Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Process implements Runnable {

    private int id;
    private CountDownLatch latch;

    public Process(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished: " + id);

        latch.countDown();
    }

}

public class CountDownLatchExample {

    public static void main(String[] args) {

        int TOTAL_NUMBER_OF_TASKS = 6;
        int THREAD_POOL_SIZE = 3;

        CountDownLatch latch = new CountDownLatch(TOTAL_NUMBER_OF_TASKS);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < TOTAL_NUMBER_OF_TASKS; i++) {
            executor.submit(new Process(i, latch));
        }
        executor.shutdown();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks are completed.");
    }

}
