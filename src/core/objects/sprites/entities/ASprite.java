package core.objects.sprites.entities;

import core.objects.sprites.AEntity;

public abstract class ASprite extends AEntity {

    private double life;
    private double damages;
    private double speed;

    public ASprite(String skinPath, double life, double damages, double speed) {
        super(skinPath);
        this.life = life;
        this.damages = damages;
        this.speed = speed;
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
}
