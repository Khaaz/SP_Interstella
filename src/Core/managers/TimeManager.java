package Core.managers;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeManager implements Runnable {
    private final ScheduledExecutorService scheduler;
    private final Runnable actualTask;
    private final TimeUnit unit;

    private long initialDelay;
    private long delay;

    private boolean pause;

    public TimeManager(Runnable actualTask, long initialDelay, long delay, TimeUnit unit, ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
        this.actualTask = actualTask;
        this.initialDelay = initialDelay;
        this.delay = delay;
        this.unit = unit;
    }

    protected void start() {
        this.pause = false;
        this.scheduler.scheduleWithFixedDelay(this, this.initialDelay, this.delay, this.unit);
    }

    protected void pause() {
        this.pause = true;
    }

    protected void restart() {
        this.pause = false;
    }

    @Override
    public void run() {
        if (this.pause) {
            return;
        }
        this.actualTask.run();
    }
}
