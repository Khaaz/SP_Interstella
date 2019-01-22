package core.managers;

import core.objects.entities.Bullet;
import core.objects.entities.spaceships.ASpaceship;
import javafx.application.Platform;

public class DamageManager {
    private GameManager gameManager;

    public DamageManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    /**
     * Check the collision between Shep and Enemy
     * Damage the Shep with enemy amount of life
     * Eventually call gameOver
     * @param enemy
     * @param shep
     */
    public void collisionEnemyShep(ASpaceship enemy, ASpaceship shep) {
        double life = shep.getCurLife() - enemy.getCurLife();

        if (life <= 0) {
            // call GameOver
            Platform.runLater(() -> this.gameManager.gameOver());
        } else {
            shep.setLife(life);
            this.gameManager.increasePointByKill();
            this.gameManager.updateDisplayedLife(shep.getCurLife(), shep.getLife());
        }
    }

    /**
     * Check the collision between an enemy and a shep's bullet
     * Remove life to the enemy (bullet damage)
     * OR
     * kill the enemy (setPoint)
     * @param enemy
     * @param bullet
     * @return true if enemy was killed
     */
    public Boolean damageEnemy(ASpaceship enemy, Bullet bullet) {
        double life = enemy.getCurLife() - bullet.getDamage();
        if (life <= 0) {
            this.gameManager.increasePointByKill();
            return true;
        } else {
            enemy.setLife(life);
            return false;
        }
    }

    /**
     * Damage Shep with a enemy bullet
     * remove life from the shep
     * Eventually call gameOver
     * @param shep
     * @param bullet
     */
    public void damageShep(ASpaceship shep, Bullet bullet) {
        double life = shep.getCurLife() - bullet.getDamage();
        if (life <= 0) {
            // call GameOver
            Platform.runLater(() -> this.gameManager.gameOver());
        } else {
            shep.setLife(life);
            this.gameManager.updateDisplayedLife(shep.getCurLife(), shep.getLife());
        }
    }

}
