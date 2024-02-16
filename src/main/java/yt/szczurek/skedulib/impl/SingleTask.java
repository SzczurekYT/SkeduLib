package yt.szczurek.skedulib.impl;

import yt.szczurek.skedulib.api.Task;

import java.util.function.Consumer;

/**
 * Represents a task that's scheduled to run later
 * @param <T> The type of object that will be passed to the scheduled function
 */
public class SingleTask<T> implements Task<T> {
    private final Consumer<T> runnable;
    private final long tickstamp;
    private boolean cancelled = false;

    public SingleTask(Consumer<T> runnable, long tickstamp) {
        this.runnable = runnable;
        this.tickstamp = tickstamp;
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
}
