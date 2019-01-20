package core.objects.entities.sprites.enemies;

import core.objects.entities.sprites.ASprite;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public abstract class AEnemy extends ASprite {
    private double posX;
    private double posY;
    private String trajectory;

    public AEnemy(String skin, double imageWidth, double imageHeight, EnemyConfig conf, double life, double damage, double speed) {
        super(skin, imageWidth, imageHeight, life, damage, speed);

        this.posX = conf.getPosX();
        this.posY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }

    public AEnemy(String skin, double imageWidth, double imageHeight, EnemyConfig conf, double life, double damage, double speed, PowerUpRate power) {
        super(skin, imageWidth, imageHeight, power.getLifeMultiplier()*life, power.getDamageMultiplier()*damage, power.getSpeedMultiplier()*speed);

        this.posX = conf.getPosX();
        this.posY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }
}
