package Core.Managers.Scenes;

import old.Views.Roots.ARoot;
import old.Views.Roots.MenuRoot;

public class MenuScene extends AScene {
    public MenuScene() {
        super(new MenuRoot());

    }

    public void onResize() {
        ((ARoot)this.getRoot()).resizeComponents();
    }
}
