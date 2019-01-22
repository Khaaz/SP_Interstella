package core.managers.bulletManager;

import core.managers.IService;
import core.managers.InstanceManager;
import core.objects.entities.Bullet;
import core.objects.entities.spaceships.enemies.AEnemy;

public class BulletManager implements IService {

    protected InstanceManager instanceManager;

    private BulletHandlerLoop bulletHandlerLoop;

    public BulletManager(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.bulletHandlerLoop = new BulletHandlerLoop(this);
    }

    @Override
    public void start() {
        this.bulletHandlerLoop.start();
        System.out.println("start call bullet manager");
    }

    @Override
    public void pause() {
        this.bulletHandlerLoop.stop();
        System.out.println("pause call bullet manager");
    }

    @Override
    public void resume() {
        this.bulletHandlerLoop.start();
        System.out.println("resume call bullet manager");
    }

    @Override
    public void reset(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.bulletHandlerLoop.stop();
        this.bulletHandlerLoop.resetCount();
        System.out.println("reset call bullet manager");
    }

    /**
     * Create a bullet with the damage of the Shep and the bulletSpeed of the schep
     * Call instance manager
     */
    public void addBulletShep() {
        Bullet b = new Bullet(this.instanceManager.getShep().getDamage(), this.instanceManager.getShep().getBulletSpeed());
        this.instanceManager.addBulletShep(b);
    }

    /**
     * Create a bullet with the enemy damages and the enemy bullet speed
     * Call instance manager
     * @param e Enemy that created the bullet
     */
    public void addBulletEnemy(AEnemy e) {
        Bullet b = new Bullet(e.getDamage(), e.getBulletSpeed());
        this.instanceManager.addBulletEnemy(e, b);
    }
}
