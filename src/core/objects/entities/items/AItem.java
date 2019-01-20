package core.objects.entities.items;

import constants.PATH;
import core.objects.entities.AEntity;

public abstract class AItem extends AEntity {
    public AItem() {
        super(PATH.enemy);
    }
}
