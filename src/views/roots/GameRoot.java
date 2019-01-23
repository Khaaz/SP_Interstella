package views.roots;

import core.managers.SceneManager;
import javafx.scene.paint.Color;
import views.backgrounds.GameBG;
import views.components.LabelCpnt;

public class GameRoot extends ARoot {

    private LabelCpnt timeDisplay;
    private LabelCpnt scoreDisplay;
    private LabelCpnt lifeDisplay;

    public GameRoot() {
        super(new GameBG());

        // displayer for the timeDisplay/scoreDisplay/lifeDisplay
        this.timeDisplay = new LabelCpnt();
        this.scoreDisplay = new LabelCpnt();
        this.lifeDisplay = new LabelCpnt();

        this.timeDisplay.setTextFill(Color.RED);
        this.scoreDisplay.setTextFill(Color.RED);
        this.lifeDisplay.setTextFill(Color.RED);

        this.positionDisplayer();

        this.getChildren().add(this.timeDisplay);
        this.getChildren().add(this.scoreDisplay);
        this.getChildren().add(this.lifeDisplay);
    }

    /**
     * Correctly position Displayers with current window size
     */
    public void positionDisplayer() {
        this.timeDisplay.setLayoutX(SceneManager.getCurWidth() * 0.92);
        this.timeDisplay.setLayoutY(SceneManager.getCurHeight() * 0.9);

        this.scoreDisplay.setLayoutX(SceneManager.getCurWidth() * 0.83);
        this.scoreDisplay.setLayoutY(SceneManager.getCurHeight() * 0.9);

        this.lifeDisplay.setLayoutX(SceneManager.getCurWidth() * 0.02);
        this.lifeDisplay.setLayoutY(SceneManager.getCurHeight() * 0.9);
    }

    public void updateTime(double time) {
        long rounded = Math.round(time / 1000);
        this.timeDisplay.setText(String.valueOf(rounded));
    }

    public void updateScore(double score) {
        long rounded = Math.round(score);
        this.scoreDisplay.setText(String.valueOf(rounded));
    }

    public void updateLife(double curLife, double maxLife) {
        long roundedCurLife = Math.round(curLife);
        long roundedMaxLife = Math.round(maxLife);
        this.lifeDisplay.setText(roundedCurLife + "/" + roundedMaxLife);
    }

    /**
     * Resize and reposition all components
     */
    @Override
    public void resizeComponents() {
        this.positionDisplayer();
    }
}
