package yt.szczurek.skedulib.impl;

import org.jetbrains.annotations.NotNull;
import yt.szczurek.skedulib.api.Scheduler;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;

public class SyncScheduler<T> implements Scheduler<T> {
    private final Queue<Task<T>> queue = new PriorityQueue<>(Comparator.comparingLong(Task::getTickstamp));
    private long tickstamp = 0;

    protected SyncScheduler() {}

    protected void tick(T ctx) {
        processQueue(ctx);
        tickstamp++;
    }


    private void processQueue(T ctx) {
        if (queue.isEmpty()) return;
        while (queue.peek() != null && queue.peek().getTickstamp() <= tickstamp) {
            Task<T> poll = queue.poll();
            if (!(poll != null && !poll.isCancelled())) continue;
            if (poll instanceof RepeatingTask<T> repeatingTask) {
                queue.add(repeatingTask.getNext(tickstamp));
            }
            poll.getRunnable().accept(ctx);
        }
    }

    @Override
    public @NotNull Task<T> runNow(@NotNull Consumer<T> runnable) {
        Task<T> task = new Task<>(runnable, -1);
        queue.add(task);
        return task;
    }

    @Override
    public @NotNull Task<T> runNextTick(@NotNull Consumer<T> runnable) {
        Task<T> task = new Task<>(runnable, tickstamp + 1);
        queue.add(task);
        return task;
    }

    @Override
    public @NotNull Task<T> runIn(long ticks, @NotNull Consumer<T> runnable) {
        Task<T> task = new Task<>(runnable, tickstamp + ticks);
        queue.add(task);
        return task;
    }

    @Override
    public @NotNull Task<T> runEvery(long ticks, @NotNull Consumer<T> runnable) {
        Task<T> task = new RepeatingTask<>(runnable, tickstamp, ticks);
        queue.add(task);
        return task;
    }
}
