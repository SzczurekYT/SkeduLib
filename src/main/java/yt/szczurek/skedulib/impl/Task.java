package yt.szczurek.skedulib.impl;

import java.util.function.Consumer;

/**
 * Represents a task that's scheduled to run later
 * @param <T> The type of object that will be passed to the scheduled function
 */
public class Task<T> {
    private final Consumer<T> runnable;
    private final long tickstamp;
    private boolean cancelled = false;

    public Task(Consumer<T> runnable, long tickstamp) {
        this.runnable = runnable;
        this.tickstamp = tickstamp;
    }

    public Consumer<T> getRunnable() {
        return runnable;
    }

    public long getTickstamp() {
        return tickstamp;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Cancels the task. Cancelled task will not be executed.
     */
    public void cancel() {
        this.cancelled = true;
    }
}
