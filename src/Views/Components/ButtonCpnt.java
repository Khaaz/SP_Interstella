package Views.Components;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ButtonCpnt extends Button implements IResizableElement {
    public ButtonCpnt(String label) {
        super(label);

        this.setMinWidth(300);
        this.setMinHeight(100);
        this.setFont(Font.loadFont("file:assets/Fonts/Daft_Font.TTF", 50));
        this.setTextFill(Color.RED);
        this.setStyle("-fx-background-color: BLACK;");
        //this.setLayoutX(ISceneListener.getCurWidth() / 2 - this.getMinWidth() / 2);
    }

    @Override
    public void resizeElement() {

    }
}


