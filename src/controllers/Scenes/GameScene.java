package controllers.Scenes;

import core.managers.GameManager;
import core.objects.sprites.entities.ASprite;
import core.objects.sprites.entities.Shep;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GameScene extends AScene {

    private GameManager gameManager;

    private ASprite shep;

    /**
     * Controller
     * Responsible of events
     * @param root game root
     */
    public GameScene(Parent root) {
        super(root);

        this.shep = new Shep();

        this.addElement(this.shep);

        this.gameManager = new GameManager(this.shep);
        this.gameManager.start();

        this.setCursor(Cursor.NONE);

        this.setOnMouseMoved(event -> this.onMouseMoved(shep, event));
        this.setOnMouseDragged(event -> this.onMouseMoved(shep, event));

        this.setOnKeyPressed(this::onKeyPressed);
    }

    /*
    public void removeElement(ASprite e) {
        ObservableList<Node> list = ((Group)this.getRoot()).getChildren();
        Node n = list
            .stream()
            .filter(o -> o instanceof ASprite)
            .filter(o -> ((ASprite)o).getID() == e.getID())
            .findFirst();
    }*/

    private void onMouseMoved(ASprite Shep, MouseEvent event) {
        Shep.body.setX(event.getSceneX() - (Shep.body.getFitWidth()/2));
        Shep.body.setY(event.getSceneY() - (Shep.body.getFitHeight()/2));
    }

    /**
     * ESCAPE : pause -> PauseScene
     * @param event keyEvent
     */
    private void onKeyPressed(KeyEvent event) {
        switch(event.getCode()) {
            case ESCAPE: {
                System.out.println("pause");
                this.gameManager.pause();
                break;
            }
            case ENTER: {
                System.out.println("restart");
                this.gameManager.restart();
            }
            default: {
                //
            }
        }
    }
}
