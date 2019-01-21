package core.managers.collisionManager;

import core.objects.entities.AEntity;
import core.objects.entities.Bullet;
import core.objects.entities.sprites.ASpaceship;
import core.objects.entities.sprites.enemies.AEnemy;
import core.utility.Positioner;
import javafx.animation.AnimationTimer;

public class CollisionHandlerLoop extends AnimationTimer {

    private CollisionManager collisionManager;
    public CollisionHandlerLoop(CollisionManager collisionManager) {
        super();
        this.collisionManager = collisionManager;
    }

    @Override
    public void handle(long l) {
        ASpaceship shep = this.collisionManager.instanceManager.getShep();
        for (AEnemy enemy : this.collisionManager.instanceManager.getEnemies()) {
            if (checkCollision(enemy, shep)) {
                System.out.println("collision");
            }
            // check pos mainShip with ENEMY
            // enleve vie
            // destroy / gameOver
            for (Bullet bullet : this.collisionManager.instanceManager.getBulletsShep()) {
                if (checkCollision(enemy, bullet)) {
                    System.out.println("collision");
                }
                // enleve vie
                // destroy
            }
        }

        for (Bullet enemyBullet : this.collisionManager.instanceManager.getBulletEnemies()) {
            if (checkCollision(enemyBullet, shep)) {
                System.out.println("collision");
            }
        }
    }

    private Boolean checkCollision(AEntity a, AEntity b) {
        return (Positioner.getXRight(a) > Positioner.getXLeft(b)
                && Positioner.getXLeft(a) < Positioner.getXRight(b)
                && Positioner.getYBottom(a) > Positioner.getYTop(b)
                && Positioner.getYTop(a) < Positioner.getYBottom(b)
        );
    }
}
