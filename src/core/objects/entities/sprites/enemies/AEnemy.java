package core.objects.entities.sprites.enemies;

import core.objects.entities.sprites.ASpaceship;
import core.objects.PowerUpRate;
import core.objects.configObject.EnemyConfig;

public abstract class AEnemy extends ASpaceship {
    private double startPosX;
    private double startPosY;
    private String trajectory;

    public AEnemy(String skin, double imageWidth, double imageHeight, EnemyConfig conf, double life, double damage, double speed, double bulletSpeed, double bulletRate) {
        super(skin, imageWidth, imageHeight, life, damage, speed, bulletSpeed, bulletRate);

        this.startPosX = conf.getPosX();
        this.startPosY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }

    public AEnemy(String skin, double imageWidth, double imageHeight, EnemyConfig conf, double life, double damage, double speed, double bulletSpeed, double bulletRate, PowerUpRate power) {
        super(skin, imageWidth, imageHeight, power.getLifeMultiplier()*life, power.getDamageMultiplier()*damage, power.getSpeedMultiplier()*speed, bulletSpeed, bulletRate);

        this.startPosX = conf.getPosX();
        this.startPosY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }

    public String getTrajectory() {
        return trajectory;
    }

    public double getStartPosX() {
        return startPosX;
    }

    public double getStartPosY() {
        return startPosY;
    }


}
