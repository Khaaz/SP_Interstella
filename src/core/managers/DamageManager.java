package core.managers;

import core.objects.entities.Bullet;
import core.objects.entities.sprites.ASpaceship;
import javafx.application.Platform;

public class DamageManager {
    private GameManager gameManager;

    public DamageManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void collisionEnemyShep(ASpaceship enemy, ASpaceship shep) {
        double life = shep.getLife() - enemy.getLife();

        if (life <= 0) {
            // call GameOver
            Platform.runLater(() -> this.gameManager.gameOver());
        } else {
            shep.setLife(life);
            this.gameManager.increasePointByKill();
        }
    }

    public Boolean damageEnemy(ASpaceship enemy, Bullet bullet) {
        double life = enemy.getLife() - bullet.getDamage();
        if (life <= 0) {
            this.gameManager.increasePointByKill();
            return true;
        } else {
            enemy.setLife(life);
            return false;
        }
    }

    public void damageShep(ASpaceship shep, Bullet bullet) {
        double life = shep.getLife() - bullet.getDamage();
        if (life <= 0) {
            // call GameOver
            Platform.runLater(() -> this.gameManager.gameOver());
        } else {
            shep.setLife(life);
        }
    }

}
