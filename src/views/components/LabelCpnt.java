package views.components;

import constants.PATH;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class LabelCpnt extends Label {
    public LabelCpnt(){

        this.setFont(Font.loadFont(PATH.FONT, 50));
    }
}
