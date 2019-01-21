package core.managers.BulletManager;

import core.objects.entities.sprites.enemies.AEnemy;
import javafx.animation.AnimationTimer;

public class BulletHandlerLoop extends AnimationTimer {

    private BulletManager bulletManager;

    private int count;

    public BulletHandlerLoop(BulletManager bulletManager) {
        super();
        this.bulletManager = bulletManager;
        this.count = 0;
    }

    @Override
    public void handle(long l) {

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
