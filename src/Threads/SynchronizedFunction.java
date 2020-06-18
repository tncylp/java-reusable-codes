package Threads;

public class SynchronizedFunction {

    public static int count = 0;

    static class Runner implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        }
    }

    public synchronized static void increment(){
        count++;
    }

    public static void main(String[] args) {
        Thread firstThread = new Thread(new Runner());
        Thread secondThread = new Thread(new Runner());

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (Exception e) {

        }

        // 20000 is expected to be seen.
        System.out.println("Count: " + count);
    }

}
