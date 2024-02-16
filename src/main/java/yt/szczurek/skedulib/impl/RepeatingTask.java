package yt.szczurek.skedulib.impl;

import yt.szczurek.skedulib.api.Task;

import java.util.function.Consumer;

public class RepeatingTask<T> implements Task<T> {

    private final Consumer<T> runnable;
    private long tickstamp;
    private final long delay;
    private boolean cancelled = false;

    public RepeatingTask(Consumer<T> runnable, long tickstamp, long delay) {
        this.runnable = runnable;
        this.tickstamp = tickstamp;
        this.delay = delay;
    }

    @Override
    public Consumer<T> getRunnable() {
        return runnable;
    }

    @Override
    public long getTickstamp() {
        return tickstamp;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void cancel() {
        this.cancelled = true;
    }

    public void updateTickstamp(long currentTickstamp) {
        tickstamp = currentTickstamp + delay;
    }
}
