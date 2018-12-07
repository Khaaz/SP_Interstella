package Views.Components;

import Controllers.SceneManager;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ButtonCpnt extends Button {
    public ButtonCpnt(String label) {
        super(label);

        //this.setMinWidth(300);

        //this.setLayoutX(SceneManager.getCurWidth() / 2 - this.getMinWidth() / 2);
    }
}
