package core.managers.moveManager;

import constants.CONFIG;
import core.objects.entities.Bullet;
import core.objects.entities.spaceships.enemies.AEnemy;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

public class MoveHandlerLoop {

    private PositionManager positionManager;

    private final Timeline timeline;

    public MoveHandlerLoop(PositionManager positionManager) {
        this.positionManager = positionManager;

        this.timeline = new Timeline();
        this.timeline.setCycleCount(Animation.INDEFINITE);

        this.timeline.getKeyFrames().add(new KeyFrame(Duration.millis(CONFIG.FRAME_TIME), this::handle));
    }

    public void start() {
        this.timeline.play();
    }

    public void stop() {
        this.timeline.stop();
    }

    public void handle(ActionEvent actionEvent) {
        // SHEP bullets
        for (Bullet b : this.positionManager.instanceManager.getBulletsShep()) {
            b.body.relocate(b.body.getLayoutX(), b.body.getLayoutY() - b.getSpeed());
        }

        // ENEMY bullets
        for (Bullet b : this.positionManager.instanceManager.getBulletEnemies()) {
            b.body.relocate(b.body.getLayoutX(), b.body.getLayoutY() + b.getSpeed());
        }

        for (AEnemy e : this.positionManager.instanceManager.getEnemies()) {
            e.body.relocate(e.body.getLayoutX(), e.body.getLayoutY() + e.getSpeed());
            // move ENEMY regarding their trajectory function
        }
    }
}
