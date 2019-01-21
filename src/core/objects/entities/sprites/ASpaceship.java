package core.objects.entities.sprites;

import core.objects.entities.AEntity;

public abstract class ASpaceship extends AEntity {

    private double life;
    private double damages;
    private double speed;

    private double bulletSpeed;
    private double bulletRate;

    public ASpaceship(String skinPath, double imageWidth, double imageHeight, double life, double damages, double speed, double bulletSpeed, double bulletRate) {
        super(skinPath, imageWidth, imageHeight);
        this.life = life;
        this.damages = damages;
        this.speed = speed;

        this.bulletSpeed = bulletSpeed;
        this.bulletRate = bulletRate;
    }

    public double getLife() {
        return life;
    }

    public double getDamages() {
        return damages;
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
}
