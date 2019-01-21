package core.managers.moveManager;

import core.objects.entities.Bullet;
import core.objects.entities.sprites.enemies.AEnemy;
import javafx.animation.AnimationTimer;

public class MoveHandlerLoop extends AnimationTimer {

    private MoveManager moveManager;

    public MoveHandlerLoop(MoveManager moveManager) {
        super();
        this.moveManager = moveManager;
    }

    @Override
    public void handle(long l) {
        // SHEP bullets
        for (Bullet b : this.moveManager.instanceManager.getBulletsShep()) {
            b.body.relocate(b.body.getLayoutX(), b.body.getLayoutY() - b.getSpeed());
        }

        // ENEMY bullets
        for (Bullet b : this.moveManager.instanceManager.getBulletEnemies()) {
            b.body.relocate(b.body.getLayoutX(), b.body.getLayoutY() + b.getSpeed());
        }

        for (AEnemy e : this.moveManager.instanceManager.getEnemies()) {
            e.body.relocate(e.body.getLayoutX(), e.body.getLayoutY() + e.getSpeed());
            // move ENEMY regarding their trajectory function
        }
    }
}
