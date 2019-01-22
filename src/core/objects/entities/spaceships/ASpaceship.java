package core.objects.entities.spaceships;

import core.objects.entities.AEntity;

/**
 * Abstract class for all spaceship in the game
 * life, damage, speed, bulletSpeed, bulletRate
 */
public abstract class ASpaceship extends AEntity {

    private final double life;
    private double curLife;
    private final double damage;
    private final double speed;

    private final double bulletSpeed;
    private final double bulletRate;

    public ASpaceship(String skinPath, double imageWidth, double imageHeight, double life, double damage, double speed, double bulletSpeed, double bulletRate) {
        super(skinPath, imageWidth, imageHeight);
        this.life = life;
        this.curLife = life;
        this.damage = damage;
        this.speed = speed;

        this.bulletSpeed = bulletSpeed;
        this.bulletRate = bulletRate;
    }

    public double getLife() {
        return life;
    }

    public double getCurLife() {
        return curLife;
    }

    public double getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }

    public double getBulletSpeed() {
        return bulletSpeed;
    }

    public double getBulletRate() {
        return bulletRate;
    }

    public void setLife(double life) {
        this.curLife = life;
    }
}
