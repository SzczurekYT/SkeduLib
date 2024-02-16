package yt.szczurek.skedulib.api;

import java.util.function.Consumer;

public interface Task<T> {
    /**
     * Get the runnable to be run
     */
    public Consumer<T> getRunnable();

    /**
     * Get the tickstamp at which the task should run
     */
    public long getTickstamp();

    /**
     * Is the task cancelled?
     */
    public boolean isCancelled();

    /**
     * Cancels the task. Cancelled task will not be executed.
     */
    public void cancel();
}
