package Core.Managers.Scenes;

import Core.Managers.ScenarioManager;
import Core.Managers.CollisionManager;
import Core.Class.Entities.AEntity;
import Core.Class.Entities.Shep;

import Views.Roots.ARoot;

import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;

public class GameScene extends AScene {

    private CollisionManager CollisionManager;
    private ScenarioManager ScenarioManager;

    private AEntity Shep;

    public GameScene(ARoot root) {
        super(root);

        this.Shep = new Shep();

        this.addElement(this.Shep);

        this.CollisionManager = new CollisionManager();
        this.ScenarioManager = new ScenarioManager();

        this.setCursor(Cursor.NONE);

        this.setOnMouseMoved(event -> onMouseMoved(Shep, event));
        this.setOnMouseDragged(event -> onMouseMoved(Shep, event));
    }

    /*
    public void removeElement(AEntity e) {
        ObservableList<Node> list = ((Group)this.getRoot()).getChildren();
        Node n = list
            .stream()
            .filter(o -> o instanceof AEntity)
            .filter(o -> ((AEntity)o).getID() == e.getID())
            .findFirst();
    }*/

    private void onMouseMoved(AEntity Shep, MouseEvent event) {
        Shep.body.setX(event.getSceneX() - (Shep.body.getFitWidth()/2));
        Shep.body.setY(event.getSceneY() - (Shep.body.getFitHeight()/2));
    }
}
