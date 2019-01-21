package constants;

public class CONFIG {
    public static final String TITLE = "Interstella 5555";

    public static final double HEIGHT = 1080;
    public static final double WIDTH = 1900;

    public static final String BGColor = "ff1cb0";


    public static final long BULLET_SPEED = 2;
    // SIZE
    public static final long DEFAULT_ENTITY_WIDTH = 150;
    public static final long DEFAULT_ENTITY_HEIGHT = 150;

    // SCENARIOS
    public static final long START_MIN_INTERVAL = 2000;
    public static final long MIN_INTERVAL = 100;
    public static final long MAX_INTERVAL = 5000;

    // DIFFICULTY
    public static final long STEP_TO_REDUCE_MAX_INTERVAL = 10;
    public static final double MAX_INTERVAL_REDUCER = 0.7;

    public static final long STEP_TO_INCREASE_SCENARIO_DIFFICULTY = 20;

    public static final long STEP_TO_POWERUP_ENEMIES = 20;
    public static final double POWERUP_LIFE_MULTIPLIER = 1.1;
    public static final double POWERUP_SPEED_MULTIPLIER = 1.001;
    public static final double POWERUP_DAMAGE_MULTIPLIER = 1.01;
}
