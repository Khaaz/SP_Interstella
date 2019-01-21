package core.managers.showManager;

import core.managers.SceneManager;
import core.objects.entities.Bullet;
import core.objects.entities.sprites.enemies.AEnemy;
import core.utility.Positioner;
import javafx.animation.AnimationTimer;

import java.util.ArrayList;

public class ShowHandlerLoop extends AnimationTimer {

    private ShowManager showManager;

    public ShowHandlerLoop(ShowManager showManager) {
        this.showManager = showManager;
    }

    @Override
    public void handle(long l) {

        // ENEMIES
        ArrayList<AEnemy> enemies = new ArrayList<>();
        for (AEnemy e : this.showManager.instanceManager.getEnemies()) {
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
            this.showManager.unShow(e);
            this.showManager.instanceManager.removeEnemy(e);
        }

        // ENEMY BULLETS
        ArrayList<Bullet> bullets = new ArrayList<>();
        for (Bullet b : this.showManager.instanceManager.getBulletEnemies()) {
            if (Positioner.getYTop(b) > SceneManager.getCurHeight()) {
                bullets.add(b);
            }
        }
        // delete
        for (Bullet b : bullets) {
            this.showManager.unShow(b);
            this.showManager.instanceManager.removeBulletEnemy(b);
        }

        //SHEP BULLETS
        bullets = new ArrayList<>();
        for (Bullet b : this.showManager.instanceManager.getBulletsShep()) {
            if (Positioner.getYBottom(b) < 0) {
                bullets.add(b);
            }
        }
        for (Bullet b : bullets) {
            this.showManager.unShow(b);
            this.showManager.instanceManager.removeBulletShep(b);
        }
    }
}
