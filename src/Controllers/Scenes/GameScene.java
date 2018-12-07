package Controllers.Scenes;

import Class.Entities.AEntity;
import Views.Roots.ARoot;
import Views.Roots.GameRoot;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

public class GameScene extends AScene {
    public GameScene() {
        super(new GameRoot());

        this.setCursor(Cursor.NONE);

        AEntity Shep = ((GameRoot)this.getRoot()).Shep;

        this.setOnMouseMoved(event -> onMouseMoved(Shep, event));
        this.setOnMouseDragged(event -> onMouseMoved(Shep, event));

    }

    private void onMouseMoved(AEntity Shep, MouseEvent event) {
        Shep.body.setX(event.getSceneX() - (Shep.body.getFitWidth()/2));
        Shep.body.setY(event.getSceneY() - (Shep.body.getFitHeight()/2));
    }

    public void onResize() {
        ((ARoot)this.getRoot()).resizeComponents();
    }
}
