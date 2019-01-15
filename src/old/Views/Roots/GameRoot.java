package old.Views.Roots;

import old.Core.Entities.Shep;
import old.Views.Backgrounds.GameBG;

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
