package core.managers.showManager;

import core.objects.entities.Bullet;
import core.objects.entities.sprites.enemies.AEnemy;
import javafx.animation.AnimationTimer;

public class ShowHandlerLoop extends AnimationTimer {

    private ShowManager showManager;

    public ShowHandlerLoop(ShowManager showManager) {
        this.showManager = showManager;
    }

    @Override
    public void handle(long l) {
        for (AEnemy e : this.showManager.instanceManager.getEnemies()) {
            // check position with window size
            // unshow
        }

        for (Bullet b : this.showManager.instanceManager.getBulletEnemies()) {
            //
        }

        for (Bullet b : this.showManager.instanceManager.getBulletsShep()) {
            //
        }
    }
}
