package classwork7;

public class BarrierMain {
    private Barrier barrier = new Barrier(5);

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting");
        barrier.barrierRun();
        System.out.println(Thread.currentThread().getName() + " passed through");
    }

    public static void main(String[] args) {
        BarrierMain main = new BarrierMain();

        for (int i = 0; i < 5; i++) {
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
