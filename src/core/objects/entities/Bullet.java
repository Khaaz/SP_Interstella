package core.objects.entities;

import constants.PATH;

public class Bullet extends AEntity {

    private double damage;
    private double speed;

    public Bullet(double damage, double speed) {
        super(PATH.BULLET, 10, 45);

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
