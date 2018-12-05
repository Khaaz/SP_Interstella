package Controllers.Scenes;

import Views.Roots.ARoot;
import Views.Roots.MenuRoot;

public class MenuScene extends AScene {
    public MenuScene() {
        super(new MenuRoot());

    }

    public void onResize() {
        ((ARoot)this.getRoot()).resizeComponents();
    }
}
