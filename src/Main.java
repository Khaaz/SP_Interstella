import constants.CONFIG;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import core.managers.SceneManager;
import javafx.util.Duration;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        Media media = new Media(new File("assets/tracks/OneMoreTime.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(media);
        player.setVolume(0);
        //player.setVolume(0.05);

        //Musique en boucle
        player.setOnEndOfMedia(new Runnable() {
            public void run() {
                player.seek(Duration.ZERO);
            }
        });
        player.play();

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