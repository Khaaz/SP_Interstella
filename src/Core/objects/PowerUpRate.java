package Core.objects;

public class PowerUpRate {
    private double lifeMultiplier;
    private double damageMultiplier;
    private double speedMultiplier;

    public PowerUpRate(double lifeMultiplier, double damageMultiplier, double speedMultiplier) {
            this.lifeMultiplier = lifeMultiplier;
            this.damageMultiplier = damageMultiplier;
            this.speedMultiplier = speedMultiplier;
    }

    public double getLifeMultiplier() {
        return lifeMultiplier;
    }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void buffLifeMultiplier(double lifeMultiplier) {
        this.lifeMultiplier *= lifeMultiplier;
    }

    public void buffDamageMultiplier(double damageMultiplier) {
        this.damageMultiplier *= damageMultiplier;
    }

    public void buffSpeedMultiplier(double speedMultiplier) {
        this.speedMultiplier *= speedMultiplier;
    }
}
