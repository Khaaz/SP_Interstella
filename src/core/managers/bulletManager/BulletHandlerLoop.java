package core.managers.bulletManager;

import constants.CONFIG;
import core.objects.entities.spaceships.enemies.AEnemy;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class BulletHandlerLoop {

    private BulletManager bulletManager;

    private final Timeline timeline;

    private int count;


    public BulletHandlerLoop(BulletManager bulletManager) {

        this.bulletManager = bulletManager;
        this.count = 0;

        this.timeline = new Timeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);

        this.timeline.getKeyFrames().add(new KeyFrame(Duration.millis(CONFIG.FRAME_TIME), this::handle));
    }

    protected void start() {
        this.timeline.play();
    }

    protected void stop() {
        this.timeline.stop();
    }

    protected void resetCount() {
        this.count = 0;
    }

    public void handle(ActionEvent actionEvent) {
        this.count += 1;
        if (this.count % this.bulletManager.instanceManager.getShep().getBulletRate() == 0) {
            this.bulletManager.addBulletShep();
        }

        for (AEnemy e : this.bulletManager.instanceManager.getEnemies()) {
            if (this.count % e.getBulletRate() == 0) {
                this.bulletManager.addBulletEnemy(e);
            }
        }
    }
}
