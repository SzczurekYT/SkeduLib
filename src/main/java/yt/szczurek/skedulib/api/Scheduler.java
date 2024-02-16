package yt.szczurek.skedulib.api;

import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public interface Scheduler<T> {

    /**
     * Runs at the end of the tick it was scheduled on.
     * In case it's scheduled after the task processing was run it will run on the next tick.
     */
    public @NotNull Task<T> runNow(@NotNull Consumer<T> runnable);
    /**
     * Runs in the upcoming tick
     */
    public @NotNull Task<T> runNextTick(@NotNull Consumer<T> runnable);
    /**
     * Runs after the specified amount of ticks.
     */
    public @NotNull Task<T> runIn(long ticks, @NotNull Consumer<T> runnable);

    /**
     * Run every specified amount of ticks
     */
    public @NotNull Task<T> runEvery(long ticks, @NotNull Consumer<T> runnable);
    
}
