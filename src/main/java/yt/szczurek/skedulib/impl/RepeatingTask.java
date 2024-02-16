package yt.szczurek.skedulib.impl;

import java.util.function.Consumer;

public class RepeatingTask<T> extends Task<T> {
    private final long delay;

    public RepeatingTask(Consumer<T> runnable, long tickstamp, long delay) {
        super(runnable, tickstamp);
        this.delay = delay;
    }

    public long getDelay() {
        return delay;
    }

    public RepeatingTask<T> getNext(long currentTickstamp) {
        return new RepeatingTask<>(getRunnable(), currentTickstamp + delay, delay);
    }
}
