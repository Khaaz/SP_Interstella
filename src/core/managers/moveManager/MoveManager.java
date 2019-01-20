package core.managers.moveManager;

import core.managers.IService;
import core.managers.InstanceManager;

public class MoveManager implements IService {

    protected InstanceManager instanceManager;

    private MoveHandlerLoop moveHandleLoop;

    public MoveManager(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.moveHandleLoop = new MoveHandlerLoop(this);
    }

    @Override
    public void start() {
        this.moveHandleLoop.start();
    }

    @Override
    public void pause() {
        this.moveHandleLoop.stop();
    }

    @Override
    public void resume() {
        this.moveHandleLoop.start();
    }

    @Override
    public void reset() {
        this.moveHandleLoop.stop();
    }
}
