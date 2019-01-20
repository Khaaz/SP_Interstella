package core.objects.sprites.items;

import constants.PATH;
import core.objects.sprites.AEntity;

public abstract class AItem extends AEntity {
    public AItem() {
        super(PATH.enemy);
    }
}
