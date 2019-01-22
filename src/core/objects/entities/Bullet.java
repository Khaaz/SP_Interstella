package core.objects.entities;

import constants.CONFIG;

/**
 * Bullet
 * Damage = bullet creator's damages
 * Speed = bullet creator's bullet speed
 */
public class Bullet extends AEntity {

    private double damage;
    private double speed;

    public Bullet(String path, double damage, double speed) {
        super(path, CONFIG.BULLET_WIDTH, CONFIG.BULLET_HEIGHT);

        this.damage = damage;
        this.speed = speed;
    }

    public double getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }
}
