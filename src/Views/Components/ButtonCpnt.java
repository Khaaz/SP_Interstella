package Views.Components;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ButtonCpnt extends Button implements IResizableElement {
    public ButtonCpnt(String label) {
        super(label);

        setOnMouseEntered(envent -> {
            this.setStyle("-fx-border-width: 400%; -fx-background-color: #a6acaf; -fx-border-color: BLACK;");
            this.setTextFill(Color.BLACK);
        });

        setOnMouseExited(envent -> {
            this.setStyle("-fx-border-width: 400%; -fx-background-color: BLACK; -fx-border-color: #a6acaf;");
            this.setTextFill(Color.web("#a6acaf"));
        });


        this.setMinWidth(300);
        this.setMinHeight(100);
        this.setFont(Font.loadFont("file:assets/Fonts/Daft_Font.TTF", 50));
        this.setTextFill(Color.web("#a6acaf"));
        this.setStyle("-fx-border-width: 400%; -fx-background-color: BLACK; -fx-border-color: #a6acaf;");


        //this.setLayoutX(SceneManager.getCurWidth() / 2 - this.getMinWidth() / 2);
    }

    @Override
    public void resizeElement() {

    }
}


