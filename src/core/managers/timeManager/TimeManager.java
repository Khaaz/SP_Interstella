package core.managers.timeManager;

import core.managers.GameManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeManager {

    private ScheduledExecutorService scheduler;
    private TimedCountTask timeTask;

    private GameManager manager;

    private long time;

    public TimeManager(GameManager manager) {
        this.manager = manager;
        this.scheduler = Executors.newScheduledThreadPool(0);
        this.timeTask = new TimedCountTask(this::incrementTime, 1, 1, TimeUnit.MILLISECONDS, this.scheduler);
    }

    public void start() {
        this.time = 0;
        this.timeTask.start();
        System.out.println("start call timemanager");
    }

    public void pause() {
        this.timeTask.pause();
        System.out.println("pause call timemanager");
    }

    public void resume() {
        this.timeTask.resume();
        System.out.println("resume call timemanager");
    }

    public void reset() {
        this.scheduler.shutdownNow();
        this.time = 0;
        System.out.println("reset call timemanager");
    }

    // increment time
    private void incrementTime() {
        this.time += 1;
        this.manager.increasePointByTime();
        if (this.time % 500 == 0) {
            this.manager.updateDisplayedTime(this.time);
        }
    }
}
