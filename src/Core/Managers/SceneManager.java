package Core.Managers;

import Constants.CONFIG;
import Constants.SCENES;
import Core.Events.EventCollection;
import Core.Events.SceneEvent;
import Core.Managers.Scenes.*;

import Views.Roots.ARoot;
import Views.Roots.GameRoot;
import javafx.stage.Stage;

import java.util.HashMap;

public class SceneManager {
    private Stage stage;

    private AScene curScene;
    private HashMap<SCENES, AScene> scenes;

    private static double curHeight = CONFIG.height;
    private static double curWidth = CONFIG.width;

    public SceneManager(Stage primaryStage) {
        this.stage = primaryStage;

        this.scenes = new HashMap<>();

        // setup default scene
        ARoot root = new GameRoot();
        AScene sceneMenu = new GameScene(root);
        this.setScene(sceneMenu);
    }

    public void start() {

        // ADAPTIVE SIZING
        this.stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            SceneManager.curWidth = (double)newVal;
            this.curScene.resizeWidth(SceneManager.curWidth);
            this.curScene.onResize();
        });

        this.stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            SceneManager.curHeight = (double)newVal;
            this.curScene.resizeHeight(SceneManager.curHeight);
            this.curScene.onResize();
        });

        // DYNAMIC SCENE CHANGE
        this.stage.addEventHandler(EventCollection.SCENE_CHANGE, this::onSceneChange);
    }

    public static double getCurHeight() {
        return curHeight;
    }

    public static double getCurWidth() {
        return curWidth;
    }

    private void onSceneChange(SceneEvent event) {
        AScene scene = this.getOrFetchScene(event.getType());
        this.setScene(scene);
    }

    private AScene getOrFetchScene(SCENES s) {
        AScene scene = this.scenes.get(s);
        if (scene == null) {
            scene = this.createScene(s);
        }
        return scene;
    }

    private AScene createScene(SCENES type) {
        AScene scene;
        switch (type) {
            case GAMESCENE: {
                ARoot groot = new GameRoot();
                scene = new GameScene(groot);
                break;
            }
            case MENUSCENE:
                // load fxml and call new MenuScene
                ARoot mroot = new GameRoot();
                scene = new MenuScene(mroot);
                break;
            case SCORESCENE:
                // load fxml and call new MenuScene
                ARoot sroot = new GameRoot();
                scene = new ScoreScene(sroot);
                break;
            case CREDITSCENE:
                // load fxml and call new MenuScene
                ARoot croot = new GameRoot();
                scene = new CreditScene(croot);
                break;
            case EXIT: {
                scene = null;
                break;
            }
            default: {
                scene = null;
            }
        }
        this.scenes.put(type, scene);
        return scene;
    }

    private void setScene(AScene scene) {
        if (scene == null) {
            this.stage.close();
            return;

        }
        this.curScene = scene;
        this.stage.setScene(scene);
    }
}
