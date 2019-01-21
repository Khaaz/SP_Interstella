package core.managers.showManager;

import core.managers.IService;
import core.managers.InstanceManager;
import core.objects.entities.AEntity;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;

import java.util.function.Supplier;

/**
 * Handle showing entity at the screen
 * (Add/remove entity from observable list)
 */
public class ShowManager implements IService {

    private Supplier<Parent> getRoot;

    protected InstanceManager instanceManager;

    private ShowHandlerLoop showHandlerLoop;

    private Boolean running;

    public ShowManager(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.showHandlerLoop = new ShowHandlerLoop(this);
    }

    public void setGetRoot(Supplier<Parent> getRoot) {
        this.getRoot = getRoot;
    }

    public Group getActualRoot() {
        return (Group)(this.getRoot.get());
    }

    @Override
    public void start() {
        this.running = true;
        this.show(this.instanceManager.getShep());
        this.showHandlerLoop.start();
    }

    @Override
    public void pause() {
        this.running = false;
        this.showHandlerLoop.stop();
    }

    @Override
    public void resume() {
        this.running = true;
        this.showHandlerLoop.start();
    }

    @Override
    public void reset() {
        this.running = false;
        this.showHandlerLoop.stop();
        // remove all except background
        this.getActualRoot().getChildren().remove(1, this.getActualRoot().getChildren().size());
    }

    public Boolean show(AEntity e) {
        if(!this.running) {
            return false;
        }
        Platform.runLater(() -> this.getActualRoot().getChildren().add(e));

        return true;
    }

    public Boolean unShow(AEntity e) {
        if(!this.running) {
            return false;
        }
        this.getActualRoot().getChildren().remove(e);
        return true;
    }
}
