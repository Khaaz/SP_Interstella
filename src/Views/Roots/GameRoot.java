package Views.Roots;

import Views.Backgrounds.GameBG;

public class GameRoot extends ARoot {

    public GameRoot() {
        super(new GameBG());
    }

    @Override
    public void resizeComponents() {
        //for(IResizableElement elem : this.getChildren()) {
        //    elem.resizeElement();
        //}
    }
}
