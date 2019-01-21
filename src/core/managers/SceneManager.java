package core.managers;

import constants.CONFIG;
import constants.PATH;
import constants.SCENES;
import controllers.AController;
import core.events.EventCollection;
import core.events.SceneEvent;
import controllers.scenes.*;

import views.roots.ARoot;
import views.roots.GameRoot;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneManager {
    private Stage stage;

    private GameManager gameManager;

    private AScene curScene;
    private HashMap<SCENES, AScene> scenes;

    private static double curHeight = CONFIG.HEIGHT;
    private static double curWidth = CONFIG.WIDTH;

    public SceneManager(Stage primaryStage) {
        this.stage = primaryStage;

        this.scenes = new HashMap<>();

        FXMLLoader loader = new FXMLLoader();


        // setup default scene
        try {
            loader.setLocation(getClass().getResource(PATH.MENU_VIEWS));

            Parent root = loader.load();
            AController controller = loader.getController();
            AScene sceneMenu = new MenuScene(root, controller);

            this.setScene(sceneMenu);

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
        } else {
            scene.refresh();
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
        FXMLLoader loader = new FXMLLoader();

        switch (type) {
            case MENUSCENE: {
                // load fxml and call new MenuScene
                loader.setLocation(getClass().getResource(PATH.MENU_VIEWS));
                scene = new MenuScene(loader.load(), loader.getController());
                break;
            }
            case GAMESCENE: {
                ARoot root = new GameRoot();
                this.gameManager = new GameManager(root);
                scene = new GameScene(root, this.gameManager);
                break;
            }
            case PAUSESCENE: {
                loader.setLocation(getClass().getResource(PATH.PAUSE_VIEWS));
                scene = new PauseScene(loader.load(), loader.getController(), this.gameManager);
                break;
            }
            case GAMEOVERSCENE: {
                // load fxml and call new MenuScene
                loader.setLocation(getClass().getResource(PATH.GAMEOVER_VIEWS));
                scene = new GameOverScene(loader.load(), loader.getController(), this.gameManager);
                break;
            }
            case HANGARSCENE: {
                // load fxml and call new MenuScene
                loader.setLocation(getClass().getResource(PATH.HANGAR_VIEWS));
                scene = new HangarScene(loader.load(), loader.getController());
                break;
            }
            case SCORESCENE: {
                // load fxml and call new MenuScene
                loader.setLocation(getClass().getResource(PATH.SCORES_VIEWS));
                scene = new ScoreScene(loader.load(), loader.getController());
                break;
            }

            case CREDITSCENE: {
                // load fxml and call new MenuScene
                loader.setLocation(getClass().getResource(PATH.CREDITS_VIEWS));
                scene = new CreditScene(loader.load(), loader.getController());
                break;
            }

            case EXIT: {
                scene = null;
                break;
            }
            default: {
                loader.setLocation(getClass().getResource(PATH.MENU_VIEWS));
                scene = new MenuScene(loader.load(), loader.getController());
            }
        }
        this.scenes.put(type, scene);
        return scene;
    }

    /**&
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
