package classwork7;

public class SemaphoreMain {
    private Semaphore semaphore = new Semaphore(3);

    public void run() {
        semaphore.lock();
        try {
            doRun();
        } finally {
            semaphore.unlock();
        }
    }

    private void doRun(){
        System.out.println("Thread " + Thread.currentThread().getName() + " started");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " finished");
    }

    public static void main(String[] args) {
        SemaphoreMain main = new SemaphoreMain();

        for (int i = 1; i < 8; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run(){
                    main.run();
                }
            });
            thread.setName("" + i);
            thread.start();
        }
    }
}
