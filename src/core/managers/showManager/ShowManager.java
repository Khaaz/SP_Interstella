package core.managers.showManager;

import core.managers.IService;
import core.managers.InstanceManager;
import views.roots.ARoot;

public class ShowManager implements IService {

    protected InstanceManager instanceManager;

    private ShowHandlerLoop showHandlerLoop;

    protected ARoot root;

    private Boolean running;

    public ShowManager(InstanceManager instanceManager, ARoot root) {
        this.instanceManager = instanceManager;
        this.root = root;
        this.showHandlerLoop = new ShowHandlerLoop(this);
    }

    @Override
    public void start() {
        this.running = false;
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
        this.running = true;
        this.showHandlerLoop.stop();
    }

    public Boolean show() {
        if(!this.running) {
            return false;
        }
        return true;
    }
}
