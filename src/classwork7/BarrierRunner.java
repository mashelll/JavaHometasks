package classwork7;

import classwork7.Barrier;

public class BarrierRunner implements Runnable{
    private final Barrier barrier;

    public BarrierRunner(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting");
        barrier.barrierRun();
        System.out.println(Thread.currentThread().getName() + " passed through");
    }
}
