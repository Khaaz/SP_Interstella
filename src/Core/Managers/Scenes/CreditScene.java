package Core.Managers.Scenes;

import old.Views.Roots.ARoot;
import old.Views.Roots.MenuRoot;

public class CreditScene extends AScene {
    public CreditScene() {
        super(new MenuRoot());

    }

    public void onResize() {
        ((ARoot)this.getRoot()).resizeComponents();
    }
}
