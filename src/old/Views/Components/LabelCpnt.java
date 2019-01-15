package old.Views.Components;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

public class LabelCpnt extends Label implements IResizableElement {
    public LabelCpnt(String label) {
        super(label);
        Stop[] stops = new Stop[] { new Stop(0, Color.CYAN), new Stop(1, Color.HOTPINK)};
        LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        this.setTextFill(lg);
        this.setFont(Font.loadFont("file:assets/Fonts/Daft_Font.TTF", 75));
    }



    @Override
    public void resizeElement() {

    }
}
