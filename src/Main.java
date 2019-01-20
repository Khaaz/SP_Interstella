import Constants.CONFIG;
import javafx.application.Application;
import javafx.stage.Stage;

import Core.managers.SceneManager;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        SceneManager sceneManager = new SceneManager(primaryStage);
        sceneManager.start();

        primaryStage.setTitle(CONFIG.TITLE);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}