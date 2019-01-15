package Core.Class;

public class PowerupRate {
    private double lifeMultiplier;
    private double damageMultiplier;
    private double speedMultiplier;

    public PowerupRate(double lifeMultiplier, double damageMultiplier, double speedMultiplier) {
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
}
