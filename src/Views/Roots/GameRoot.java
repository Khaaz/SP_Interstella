package Views.Roots;

import Core.Entities.Shep;
import Views.Backgrounds.GameBG;
import Views.Components.IResizableElement;

public class GameRoot extends ARoot {
    public Shep Shep;
    public GameRoot() {
        super(new GameBG());

        this.Shep = new Shep();
        this.getChildren().add(this.Shep);
    }

    @Override
    public void resizeComponents() {
        //for(IResizableElement elem : this.getChildren()) {
        //    elem.resizeElement();
        //}
    }
}
