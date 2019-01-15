package Core.Managers.Scenes;

import old.Views.Roots.ARoot;
import old.Views.Roots.MenuRoot;

public class ScoreScene extends AScene {
    public ScoreScene() {
        super(new MenuRoot());

    }

    public void onResize() {
        ((ARoot)this.getRoot()).resizeComponents();
    }
}
