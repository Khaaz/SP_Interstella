package core.managers.collisionManager;

import core.managers.DamageManager;
import core.managers.IService;
import core.managers.InstanceManager;
public class CollisionManager implements IService {

    protected InstanceManager instanceManager;

    protected DamageManager damageManager;

    private CollisionHandlerLoop collisionHandler;

    public CollisionManager(InstanceManager instanceManager, DamageManager damageManager) {
        this.instanceManager = instanceManager;
        this.damageManager = damageManager;
        this.collisionHandler = new CollisionHandlerLoop(this);
    }

    @Override
    public void start() {
        this.collisionHandler.start();
        System.out.println("start call collision manager");
    }

    @Override
    public void pause() {
        this.collisionHandler.stop();
        System.out.println("pause call collision manager");
    }

    @Override
    public void resume() {
        this.collisionHandler.start();
        System.out.println("resume call collision manager");
    }

    @Override
    public void reset(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.collisionHandler.stop();
        System.out.println("reset call collision manager");
    }
}
