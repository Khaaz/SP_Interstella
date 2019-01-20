package Core.managers.scenarioManager;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class TimedScenarioTask implements Runnable {
    private final ScheduledExecutorService scheduler;
    private final Supplier<Boolean> actualTask;
    private final TimeUnit unit;

    private long minInterval;
    private long maxInterval;
    private long remainingTime;


    private boolean pause;

    public TimedScenarioTask(Supplier<Boolean> actualTask, long minInterval, long maxInterval, TimeUnit unit, ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
        this.actualTask = actualTask;
        this.minInterval = minInterval;
        this.maxInterval = maxInterval;
        this.unit = unit;
    }

    protected void start() {
        this.pause = false;
        this.scheduleNextInvocation();
    }

    protected void pause() {
        this.pause = true;
    }

    protected void restart() {
        if (this.pause) {
            this.pause = false;
            this.scheduleNextInvocation();
        }
    }

    /**
     * Update min and max intervals
     * @param minInterval min
     * @param maxInterval max
     */
    protected void updateIntervals(long minInterval, long maxInterval) {
        this.minInterval = minInterval;
        this.maxInterval = maxInterval;
    }

    /**
     * Randomly create a time between MIN_INTERVAL and MAX_INTERVAL to call run
     */
    private void scheduleNextInvocation() {
        long interval = (long) ((ThreadLocalRandom.current().nextFloat() * (this.maxInterval - this.minInterval)) + this.minInterval);
        scheduler.schedule(this, this.remainingTime + interval, unit);
        this.remainingTime = this.maxInterval - interval;
    }

    @Override
    public void run() {
        if (this.pause) {
            return;
        }
        if(this.actualTask.get()) {
            this.scheduleNextInvocation();
        }
    }
}
