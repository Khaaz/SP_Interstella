package core.objects.sprites.entities.enemies;

import core.objects.sprites.entities.ASprite;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public abstract class AEnemy extends ASprite {
    private double posX;
    private double posY;
    private String trajectory;

    public AEnemy(String skin, EnemyConfig conf, double life, double damage, double speed) {
        super(skin, life, damage, speed);

        this.posX = conf.getPosX();
        this.posY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }

    public AEnemy(String skin, EnemyConfig conf, double life, double damage, double speed, PowerUpRate power) {
        super(skin, power.getLifeMultiplier()*life, power.getDamageMultiplier()*damage, power.getSpeedMultiplier()*speed);

        this.posX = conf.getPosX();
        this.posY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }
}
