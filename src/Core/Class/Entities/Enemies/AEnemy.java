package Core.Class.Entities.Enemies;

import Core.Class.Entities.AEntity;
import Core.Class.PowerupRate;
import Core.Class.ConfigClass.EnemyConfig;

public abstract class AEnemy extends AEntity {
    private double posX;
    private double posY;
    private String trajectory;

    public AEnemy(String skin, EnemyConfig conf, double life, double damage, double speed) {
        super(skin, life, damage, speed);

        this.posX = conf.getPosX();
        this.posY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }

    public AEnemy(String skin, EnemyConfig conf, double life, double damage, double speed, PowerupRate power) {
        super(skin, power.getLifeMultiplier()*life, power.getDamageMultiplier()*damage, power.getSpeedMultiplier()*speed);

        this.posX = conf.getPosX();
        this.posY = conf.getPosY();
        this.trajectory = conf.getTrajectory();
    }
}
