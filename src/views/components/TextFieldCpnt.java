package views.components;

import constants.PATH;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class TextFieldCpnt extends TextField {
    public TextFieldCpnt (){

        this.setFont(Font.loadFont(PATH.FONT, 25));
    }
}
