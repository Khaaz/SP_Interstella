package Views.Roots;

import Views.Backgrounds.MenuBG;
import Views.Components.MenuCpnt;


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
