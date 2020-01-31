package hometask7;

import java.util.concurrent.Callable;

public class TaskImpl<T> implements Task<T> {

    private final Callable<? extends T> callable;
    private volatile boolean done;
    private volatile boolean inProgress;
    private T result;
    private Exception caughtException;

    public TaskImpl(Callable<? extends T> callable) {
        this.callable = callable;
        done = false;
        inProgress = false;
    }

    @Override
    public T get() {
        while (!done) {
            synchronized (this) {
                if (!done && !inProgress) {
                    inProgress = true;
                    break;
                } else if (!done) doAwait();
            }
        }

        if (!done) calculateResult();
        return getResult();
    }

    private void doAwait() {
        try {
            this.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void calculateResult() {
        try {
            result = callable.call();
        } catch (Exception e) {
            caughtException = e;
            result = null;
        }
        done = true;
        synchronized (this) {
            this.notifyAll();
        }
    }

    private T getResult() {
        if (result == null) throw new RuntimeException(caughtException);
        return result;
    }
}
