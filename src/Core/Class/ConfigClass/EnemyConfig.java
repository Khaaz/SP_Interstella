package Core.Class.ConfigClass;

public class EnemyConfig {
    private String type;
    private double posX;
    private double posY;
    private String trajectory;

    public EnemyConfig(String type, double posX, double posY, String trajectory) {
        this.type = type;
        this.posX = posX;
        this.posY = posY;
        this.trajectory = trajectory;
    }

    public String getType() {
        return type;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public String getTrajectory() {
        return trajectory;
    }
}
