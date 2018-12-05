package Controllers;

import Configuration.Config;
import Controllers.Scenes.AScene;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage stage;

    private static AScene curScene;

    private static double curHeight = Config.height;
    private static double curWidth = Config.width;

    public static void setup(Stage primaryStage, AScene defaultScene) {
        SceneManager.stage = primaryStage;

        SceneManager.setScene(defaultScene);

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            SceneManager.curWidth = (double)newVal;
            SceneManager.curScene.resizeWidth(SceneManager.curWidth);
            SceneManager.curScene.onResize();
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            SceneManager.curHeight = (double)newVal;
            SceneManager.curScene.resizeHeight(SceneManager.curHeight);
            SceneManager.curScene.onResize();
        });
    }

    public static double getCurHeight() {
        return curHeight;
    }

    public static double getCurWidth() {
        return curWidth;
    }

    public static void setScene(AScene scene) {
        SceneManager.curScene = scene;
        SceneManager.stage.setScene(scene);
    }
}
