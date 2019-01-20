package controllers.scenes;

import controllers.AController;
import controllers.GameOverController;
import core.managers.GameManager;
import javafx.scene.Parent;

public class GameOverScene extends AScene {

    private GameManager manager;

    public GameOverScene(Parent root, AController controller, GameManager manager) {
        super(root, controller);
        this.manager = manager;
        ((GameOverController)this.controller).setResetGameManager(this.manager::reset);
    }
}
