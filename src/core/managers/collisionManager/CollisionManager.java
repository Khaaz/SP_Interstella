package core.managers.collisionManager;

import core.managers.IService;
import core.managers.InstanceManager;
public class CollisionManager implements IService {

    protected InstanceManager instanceManager;

    private CollisionHandlerLoop collisionHandler;

    public CollisionManager(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.collisionHandler = new CollisionHandlerLoop(this);
    }

    @Override
    public void start() {
        this.collisionHandler.start();
    }

    @Override
    public void pause() {
        this.collisionHandler.stop();
    }

    @Override
    public void resume() {
        this.collisionHandler.start();
    }

    @Override
    public void reset() {
        this.collisionHandler.stop();
    }


    public Boolean checkShepCollision() {
        return true;
    }

    public Boolean checkItemCollision() {
        return true;
    }

    public Boolean checkBulletsCollision() {
        return true;
    }
}
