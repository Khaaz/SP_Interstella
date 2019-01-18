package Core.Managers;

import Constants.CONFIG;
import Constants.PATH;
import Constants.SCENES;
import Core.Events.EventCollection;
import Core.Events.SceneEvent;
import Core.Managers.Scenes.*;

import Views.Roots.ARoot;
import Views.Roots.GameRoot;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;;
import java.util.HashMap;

public class SceneManager {
    private Stage stage;

    private FXMLLoader loader;

    private AScene curScene;
    private HashMap<SCENES, AScene> scenes;

    private static double curHeight = CONFIG.height;
    private static double curWidth = CONFIG.width;

    public SceneManager(Stage primaryStage) {
        this.stage = primaryStage;

        this.scenes = new HashMap<>();

        this.loader = new FXMLLoader();


        // setup default scene
        try {
            this.loader.setLocation(getClass().getResource(PATH.gameoverViews));

            Parent mroot = this.loader.load();
            AScene sceneMenu = new MenuScene(mroot);

            this.setScene(sceneMenu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (StackTraceElement err : e.getStackTrace()) {
                System.out.println(err.toString());
            }
        }

    }

    public void start() {

        // ADAPTIVE SIZING
        this.stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            SceneManager.curWidth = (double)newVal;
            //this.curScene.resizeWidth(SceneManager.curWidth);
            //this.curScene.onResize();
        });

        this.stage.heightProperty().addListener((obs, oldVal, newVal) -> {
            SceneManager.curHeight = (double)newVal;
            //this.curScene.resizeHeight(SceneManager.curHeight);
            //this.curScene.onResize();
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
        try {
            AScene scene = this.getOrFetchScene(event.getType());
            this.setScene(scene);
        } catch (IOException e) {
            //
        }
    }

    private AScene getOrFetchScene(SCENES s) throws IOException {
        AScene scene = this.scenes.get(s);
        if (scene == null) {
            scene = this.createScene(s);
        }
        return scene;
    }

    private AScene createScene(SCENES type) throws IOException {
        AScene scene;
        switch (type) {
            case GAMESCENE: {
                ARoot groot = new GameRoot();
                scene = new GameScene(groot);
                break;
            }
            case MENUSCENE:
                // load fxml and call new MenuScene
                this.loader.setLocation(getClass().getResource(PATH.menuViews));
                Parent mroot = this.loader.load();
                scene = new MenuScene(mroot);
                break;
            case SCORESCENE:
                // load fxml and call new MenuScene
                this.loader.setLocation(getClass().getResource(PATH.scoresViews));
                ARoot sroot = this.loader.load();
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
