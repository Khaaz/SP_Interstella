package core.managers;

import core.objects.entities.Bullet;
import core.objects.entities.spaceships.enemies.AEnemy;
import core.utility.Positioner;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class InstanceHandlerLoop extends AnimationTimer {

    private InstanceManager instanceManager;

    public InstanceHandlerLoop(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
    }

    @Override
    public void handle(long l) {

        // ENEMIES
        ArrayList<AEnemy> enemies = new ArrayList<>();
        for (AEnemy e : this.instanceManager.getEnemies()) {
            if (Positioner.getYTop(e) > SceneManager.getCurHeight()
                    || Positioner.getYBottom(e) < 0
                    || Positioner.getXLeft(e) > SceneManager.getCurWidth()
                    || Positioner.getXRight(e) < 0
            ) {
                enemies.add(e);
            }
        }
        // delete
        for (AEnemy e : enemies) {
            this.instanceManager.removeEnemy(e);
        }

        // ENEMY BULLETS
        ArrayList<Bullet> bullets = new ArrayList<>();
        for (Bullet b : this.instanceManager.getBulletEnemies()) {
            if (Positioner.getYTop(b) > SceneManager.getCurHeight()) {
                bullets.add(b);
            }
        }
        // delete
        for (Bullet b : bullets) {
            this.instanceManager.removeBulletEnemy(b);
        }

        //SHEP BULLETS
        bullets = new ArrayList<>();
        for (Bullet b : this.instanceManager.getBulletsShep()) {
            if (Positioner.getYBottom(b) < 0) {
                bullets.add(b);
            }
        }
        for (Bullet b : bullets) {
            this.instanceManager.removeBulletShep(b);
        }
    }
}
