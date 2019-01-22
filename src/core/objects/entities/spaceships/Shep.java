package core.objects.entities.spaceships;

import constants.CONFIG;
import constants.PATH;

public class Shep extends ASpaceship {
    public Shep() {
        super(PATH.SHEP,
                CONFIG.DEFAULT_ENTITY_WIDTH,
                CONFIG.DEFAULT_ENTITY_HEIGHT,
                CONFIG.DEFAULT_LIFE,
                CONFIG.DEFAULT_DAMAGE,
                CONFIG.DEFAULT_ENEMY_SPEED,
                CONFIG.BULLET_SPEED,
                CONFIG.BULLET_RATE);
    }
}
