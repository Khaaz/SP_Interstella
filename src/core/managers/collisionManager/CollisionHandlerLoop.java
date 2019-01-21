package core.managers.collisionManager;

import core.objects.entities.AEntity;
import core.objects.entities.Bullet;
import core.objects.entities.sprites.ASpaceship;
import core.objects.entities.sprites.enemies.AEnemy;
import core.utility.Positioner;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class CollisionHandlerLoop extends AnimationTimer {

    private CollisionManager collisionManager;
    public CollisionHandlerLoop(CollisionManager collisionManager) {
        super();
        this.collisionManager = collisionManager;
    }

    @Override
    public void handle(long l) {

        // ENEMIES
        ArrayList<AEnemy> enemies = new ArrayList<>();
        ASpaceship shep = this.collisionManager.instanceManager.getShep();
        for (AEnemy enemy : this.collisionManager.instanceManager.getEnemies()) {
            // SHEP collision ENEMY
            if (checkCollision(enemy, shep)) {
                this.collisionManager.damageManager.collisionEnemyShep(enemy, shep);
                System.out.println("collision");
                enemies.add(enemy);
            }

            ArrayList<Bullet> bullets = new ArrayList<>();
            for (Bullet bullet : this.collisionManager.instanceManager.getBulletsShep()) {
                // ENEMY collision SHEP BULLET
                if (checkCollision(enemy, bullet)) {
                    if(this.collisionManager.damageManager.damageEnemy(enemy, bullet)) {
                        enemies.add(enemy);
                    }
                    bullets.add(bullet);
                    System.out.println("collision");
                }
            }
            // Remove all instances
            for (Bullet b : bullets) {
                this.collisionManager.instanceManager.removeBulletShep(b);
            }
        }
        // remove all instances
        for (AEnemy e : enemies) {
            this.collisionManager.instanceManager.removeEnemy(e);
        }

        // BULLETS
        ArrayList<Bullet> bullets = new ArrayList<>();
        // SHEP collision ENEMY BULLET
        for (Bullet enemyBullet : this.collisionManager.instanceManager.getBulletEnemies()) {
            if (checkCollision(enemyBullet, shep)) {
                this.collisionManager.damageManager.damageShep(shep, enemyBullet);
                bullets.add(enemyBullet);
                System.out.println("collision");
            }
        }
        // Remove all instances
        for (Bullet b : bullets) {
            this.collisionManager.instanceManager.removeBulletEnemy(b);
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
