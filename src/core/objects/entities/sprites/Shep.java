package core.objects.entities.sprites;

import constants.CONFIG;
import constants.PATH;

public class Shep extends ASpaceship {
    public Shep() {
        super(PATH.SHEP, CONFIG.DEFAULT_ENTITY_WIDTH, CONFIG.DEFAULT_ENTITY_HEIGHT, 10, 10, 10, CONFIG.BULLET_SPEED, CONFIG.BULLET_RATE);
    }
}
