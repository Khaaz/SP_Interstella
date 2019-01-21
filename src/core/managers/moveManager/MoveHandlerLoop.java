package core.managers.moveManager;

import constants.CONFIG;
import core.objects.entities.Bullet;
import core.objects.entities.sprites.enemies.AEnemy;
import core.utility.Positioner;
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
            // bullet pos Y + 1 * speed
            //b.body(b.getLayoutX(), Positioner.getYCenter(b) + CONFIG.BULLET_SPEED);
            b.body.relocate(b.body.getLayoutX(), b.body.getLayoutY() + CONFIG.BULLET_SPEED);
        }

        // ENEMY bullets
        for (Bullet b : this.moveManager.instanceManager.getBulletEnemies()) {
            // bullet pos Y - 1 * speed
            //b.relocate(b.getLayoutX(), Positioner.getYCenter(b) - CONFIG.BULLET_SPEED);
            b.body.relocate(b.body.getLayoutX(), b.body.getLayoutY() + CONFIG.BULLET_SPEED);
        }

        for (AEnemy e : this.moveManager.instanceManager.getEnemies()) {
            e.body.relocate(e.body.getLayoutX(), e.body.getLayoutY() + e.getSpeed());
            //System.out.println(e.body.getX());
            //System.out.println(e.body.getY());
            // move enemy regarding their trajectory function
        }
    }
}
