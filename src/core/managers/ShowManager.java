package core.managers;

import core.objects.entities.AEntity;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;

import java.util.function.Supplier;

/**
 * Handle showing entity on the screen
 * (Add/remove entity from observable list)
 */
public class ShowManager implements IService {

    private Supplier<Parent> getRoot;

    protected InstanceManager instanceManager;

    private Boolean running;

    public ShowManager(InstanceManager instanceManager, Supplier<Parent> getRoot) {
        this.instanceManager = instanceManager;
        this.getRoot = getRoot;
    }

    /**
     * Get the root as a Group and not as a Parent
     * @return Group (root)
     */
    public Group getActualRoot() {
        return (Group)(this.getRoot.get());
    }

    @Override
    public void start() {
        this.running = true;
        this.show(this.instanceManager.getShep());
        System.out.println("start call show manager");
    }

    @Override
    public void pause() {
        this.running = false;
        System.out.println("pause call show manager");
    }

    @Override
    public void resume() {
        this.running = true;
        System.out.println("resume call show manager");
    }

    @Override
    public void reset(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.running = false;
        // remove all except background
        Platform.runLater(() -> this.getActualRoot().getChildren().remove(1, this.getActualRoot().getChildren().size()));
        System.out.println("reset call show manager");
    }

    /**
     * Add the entity to the root
     * @param e AEntity
     * @return boolean
     */
    public Boolean show(AEntity e) {
        if(!this.running) {
            return false;
        }
        Platform.runLater(() -> this.getActualRoot().getChildren().add(e));

        return true;
    }

    /**
     * Remove the entity from the Root
     * @param e AEntity
     * @return boolean
     */
    public Boolean unShow(AEntity e) {
        if(!this.running) {
            return false;
        }
        Platform.runLater(() -> this.getActualRoot().getChildren().remove(e));
        return true;
    }
}
