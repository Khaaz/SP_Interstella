package Core.managers;

import Constants.CONFIG;
import Constants.PATH;
import Constants.SCENES;
import Core.events.EventCollection;
import Core.events.SceneEvent;
import Controllers.Scenes.*;

import Views.Roots.ARoot;
import Views.Roots.GameRoot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;;
import java.util.HashMap;

public class SceneManager {
    private Stage stage;

    private FXMLLoader loader;

    private AScene curScene;
    private HashMap<SCENES, AScene> scenes;

    private static double curHeight = CONFIG.HEIGHT;
    private static double curWidth = CONFIG.WIDTH;

    public SceneManager(Stage primaryStage) {
        this.stage = primaryStage;

        this.scenes = new HashMap<>();

        this.loader = new FXMLLoader();


        // setup default scene
        try {
            this.loader.setLocation(getClass().getResource(PATH.MENU_VIEWS));

            Parent mroot = this.loader.load();
            AScene sceneMenu = new MenuScene(mroot);

            this.setScene(sceneMenu);

            /////// TEST //////
            ARoot groot = new GameRoot();
            AScene scene = new GameScene(groot);
            this.setScene(scene);
            /////// TEST //////

        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (StackTraceElement err : e.getStackTrace()) {
                System.out.println(err.toString());
            }
        }

    }

    /**
     * Start the sceneManager
     * Start the application
     *
     * Listen to Scene event and dynamically change scenes
     *
     * Dynamically change window size
     */
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

    /**
     * Method bound to sceneEvent invocation
     * Get a scene or create one (prevent recreating scenes over and over)
     * @param event sceneEvent
     */
    private void onSceneChange(SceneEvent event) {
        try {
            AScene scene = this.getOrFetchScene(event.getType());
            this.setScene(scene);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (StackTraceElement err : e.getStackTrace()) {
                System.out.println(err.toString());
            }
        }
    }

    /**
     * Get or create a scene
     * @param s scene
     * @return scene
     * @throws IOException scene error
     */
    private AScene getOrFetchScene(SCENES s) throws IOException {
        AScene scene = this.scenes.get(s);
        if (scene == null) {
            scene = this.createScene(s);
        }
        return scene;
    }

    /**
     * Dynamically create a scene according to the scene type
     * @param type scene type
     * @return scene
     * @throws IOException scene error
     */
    private AScene createScene(SCENES type) throws IOException {
        AScene scene;
        switch (type) {
            case MENUSCENE: {
                // load fxml and call new MenuScene
                this.loader.setLocation(getClass().getResource(PATH.MENU_VIEWS));
                Parent mroot = this.loader.load();
                scene = new MenuScene(mroot);
                break;
            }
            case GAMESCENE: {
                ARoot groot = new GameRoot();
                scene = new GameScene(groot);
                break;
            }
            case GAMEOVERSCENE: {
                // load fxml and call new MenuScene
                this.loader.setLocation(getClass().getResource(PATH.GAMEOVER_VIEWS));
                ARoot goroot = this.loader.load();
                scene = new ScoreScene(goroot);
                break;
            }
            case SCORESCENE: {
                // load fxml and call new MenuScene
                this.loader.setLocation(getClass().getResource(PATH.SCORES_VIEWS));
                ARoot sroot = this.loader.load();
                scene = new ScoreScene(sroot);
                break;
            }
            case CREDITSCENE: {
                // load fxml and call new MenuScene
                ARoot croot = new GameRoot();
                scene = new CreditScene(croot);
                break;
            }
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

    /**
     * Set the scene as the current scene in cache and for the application
     * @param scene scene to setup
     */
    private void setScene(AScene scene) {
        if (scene == null) {
            this.stage.close();
            return;

        }
        this.curScene = scene;
        this.stage.setScene(scene);
    }
}
