package core.managers.collisionManager;

import core.objects.entities.Bullet;
import core.objects.entities.sprites.enemies.AEnemy;
import javafx.animation.AnimationTimer;

public class CollisionHandlerLoop extends AnimationTimer {

    private CollisionManager collisionManager;
    public CollisionHandlerLoop(CollisionManager collisionManager) {
        super();
        this.collisionManager = collisionManager;
    }

    @Override
    public void handle(long l) {
        for (AEnemy enemy : this.collisionManager.instanceManager.getEnemies()) {
            // check pos mainShip with enemy
            // enleve vie
            // destroy / gameOver
            for (Bullet bullets : this.collisionManager.instanceManager.getBulletsShep()) {
                // enleve vie
                // destroy
            }
        }

        for (Bullet enemyBullets : this.collisionManager.instanceManager.getBulletsShep()) {
            // check SHEP
            // enleve vie
            // destroy / gameOver
        }
    }
}
