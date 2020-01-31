package classwork7;

public class Barrier {
    private final int maxThreadCount;
    private int currentThreadCount;

    public Barrier (int maxThreadCount) {
        this.maxThreadCount = maxThreadCount;
        this.currentThreadCount = 0;
    }

    public synchronized void barrierRun() {
        currentThreadCount++;
        while (currentThreadCount < maxThreadCount) {
            await();
        }
        this.notifyAll();
    }


    private void await() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
