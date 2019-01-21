package core.managers.BulletManager;

import constants.CONFIG;
import core.managers.IService;
import core.managers.InstanceManager;
import core.managers.SceneManager;
import core.managers.moveManager.MoveHandlerLoop;
import core.objects.entities.Bullet;
import core.objects.entities.sprites.enemies.AEnemy;
import core.utility.Positioner;

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
        System.out.println("reset call bullet manager");
    }

    public void addBulletShep() {
        Bullet b = new Bullet(this.instanceManager.getShep().getDamages(), this.instanceManager.getShep().getBulletSpeed());
        this.instanceManager.addBulletShep(b);
    }

    public void addBulletEnemy(AEnemy e) {
        Bullet b = new Bullet(e.getDamages(), e.getBulletSpeed());
        this.instanceManager.addBulletEnemy(e, b);
    }
}
