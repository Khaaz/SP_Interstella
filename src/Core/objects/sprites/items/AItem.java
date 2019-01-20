package Core.objects.sprites.items;

import Constants.PATH;
import Core.objects.sprites.AEntity;

public abstract class AItem extends AEntity {
    public AItem() {
        super(PATH.enemy);
    }
}
