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
        for (Bullet b : this.moveManager.instanceManager.getBulletsShep()) {
            // bullet pos Y + 1 * speed
        }

        for (Bullet b : this.moveManager.instanceManager.getBulletEnemies()) {
            // bullet pos Y - 1 * speed
        }

        for (AEnemy e : this.moveManager.instanceManager.getEnemies()) {
            // move enemy regarding their trajectory function
        }
    }
}
