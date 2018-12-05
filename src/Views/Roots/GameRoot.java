package Views.Roots;

import Class.Entities.Shep;
import Views.Backgrounds.GameBG;

public class GameRoot extends ARoot {
    public Shep Shep;
    public GameRoot() {
        super(new GameBG());

        this.Shep = new Shep();
        this.getChildren().add(this.Shep);
    }

    @Override
    public void resizeComponents() {
        int i = 1 + 1;
    }
}
