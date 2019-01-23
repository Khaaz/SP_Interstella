package constants;

public class CONFIG {

    // GENERAL
    public static final String TITLE = "Interstella 5555";
    public static final double HEIGHT = 1080;
    public static final double WIDTH = 1900;

    // 40 => 24 frame/seconds. 1000/24 = 41 // 20 for even more fluent
    public static final int FRAME_TIME = 20;

    // SHEP SIZE
    public static final long DEFAULT_SHEP_WIDTH = 80;
    public static final long DEFAULT_SHEP_HEIGHT = 150;
    // BULLET SIZE
    public static final long BULLET_WIDTH = 15;
    public static final long BULLET_HEIGHT = 60;

    // DEFAULT SHEP
    public static final long DEFAULT_LIFE = 1000;
    public static final long DEFAULT_DAMAGE = 250;
    public static final long DEFAULT_SPEED = 5;
    public static final long DEFAULT_BULLET_SPEED = 18;
    // + rate => + space between bullets
    public static final long DEFAULT_BULLET_RATE = 13;

    // DEFAULT_ENEMY
    public static final long DEFAULT_ENEMY_LIFE = 200;
    public static final long DEFAULT_ENEMY_DAMAGE = 50;
    public static final long DEFAULT_ENEMY_SPEED = 5;
    public static final long DEFAULT_ENEMY_BULLET_SPEED = 12;
    public static final long DEFAULT_ENEMY_BULLET_RATE = 30;


    // SCENARIOS
    public static final long START_MIN_INTERVAL = 2000;
    public static final long MIN_INTERVAL = 200;
    public static final long MAX_INTERVAL = 4000;

    // DIFFICULTY CONF
    public static final long STEP_TO_REDUCE_MAX_INTERVAL = 5;
    public static final double MAX_INTERVAL_REDUCER = 0.95;

    public static final double CAP_INTERVAL_REDUCER = 500;

    public static final long STEP_TO_INCREASE_SCENARIO_DIFFICULTY = 20;

    public static final long STEP_TO_POWERUP_ENEMIES = 20;
    public static final double POWERUP_LIFE_MULTIPLIER = 1.1;
    public static final double POWERUP_SPEED_MULTIPLIER = 1.001;
    public static final double POWERUP_DAMAGE_MULTIPLIER = 1.01;

    public static final int PRICE_LIFE_UPGRADE = 1000;
    public static final int PRICE_DAMAGE_UPGRADE = 1000;
    public static final int PRICE_BULLETSPEED_UPGRADE = 1000;
    public static final int PRICE_FIRERATE_UPGRADE = 1000;

}
