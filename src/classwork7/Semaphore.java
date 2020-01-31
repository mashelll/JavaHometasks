package classwork7;

public class Semaphore {
    private final int maxThreadCount;
    private int currentThreadCount;

    public Semaphore (int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
    }

    public synchronized void lock() {
        while (currentThreadCount == maxThreadCount) {
            await();
        }
        ++currentThreadCount;
    }

    public synchronized void unlock() {
        this.notify();
        --currentThreadCount;
    }

    private void await() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
