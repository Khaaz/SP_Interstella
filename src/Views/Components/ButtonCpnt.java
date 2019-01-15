package Views.Components;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ButtonCpnt extends Button {
    public ButtonCpnt() {

        this.setFont(Font.loadFont("file:assets/Fonts/Daft_Font.TTF", 25));
        this.setMinWidth(300);
        this.setMinHeight(50);
        this.setMaxHeight(60);
    }


}
