package Threads;


public class ByImplementingRunnable {


    static class Runner implements Runnable {

        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + Thread.currentThread().getName() + "   i: " + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        Thread firstThread = new Thread(new Runner());
        Thread secondThread = new Thread(new Runner());

        firstThread.start();
        secondThread.start();
    }

}
