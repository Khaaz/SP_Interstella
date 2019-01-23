package core.objects.entities.spaceships;

import constants.CONFIG;
import constants.PATH;

public class Shep extends ASpaceship {
    public Shep() {
        super(PATH.SHEP,
                CONFIG.DEFAULT_SHEP_WIDTH,
                CONFIG.DEFAULT_SHEP_HEIGHT,
                CONFIG.DEFAULT_LIFE,
                CONFIG.DEFAULT_DAMAGE,
                CONFIG.DEFAULT_SPEED,
                CONFIG.DEFAULT_BULLET_SPEED,
                CONFIG.DEFAULT_BULLET_RATE);
    }

    public Shep(String path, double width, double height, long life, long damage, long speed, int bulletSpeed, int bulletRate) {
        super(path, width, height, life, damage, speed, bulletSpeed, bulletRate);
    }
}
