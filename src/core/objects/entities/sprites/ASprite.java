package core.objects.entities.sprites;

import core.objects.entities.AEntity;

public abstract class ASprite extends AEntity {

    private double life;
    private double damages;
    private double speed;

    public ASprite(String skinPath, double imageWidth, double imageHeight, double life, double damages, double speed) {
        super(skinPath, imageWidth, imageHeight);
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
