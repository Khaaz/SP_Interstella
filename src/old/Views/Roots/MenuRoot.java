package old.Views.Roots;

import old.Views.Backgrounds.MenuBG;
import old.Views.Components.MenuCpnt;


public class MenuRoot extends ARoot {
    public MenuRoot() {
        super(new MenuBG());

        MenuCpnt menu = new MenuCpnt();
        this.getChildren().add(menu);
    }

    @Override
    public void resizeComponents() {
        int i = 1 + 1;
    }
}
