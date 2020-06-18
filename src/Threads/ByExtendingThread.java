package Threads;


public class ByExtendingThread {


    static class Runner extends Thread {

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
        Runner firstRunner = new Runner();
        Runner secondRunner = new Runner();

        firstRunner.start();
        secondRunner.start();
    }

}
