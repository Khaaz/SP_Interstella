package core.managers.moveManager;

import core.managers.IService;
import core.managers.instanceManager.InstanceManager;
import core.managers.SceneManager;
import core.objects.entities.Bullet;
import core.objects.entities.spaceships.enemies.AEnemy;
import core.utility.Positioner;

/**
 * Handle movement
 * Bullets permanent mouvement
 * Enemies automatic movements
 */
public class PositionManager implements IService {

    protected InstanceManager instanceManager;

    private MoveHandlerLoop moveHandleLoop;

    public PositionManager(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.moveHandleLoop = new MoveHandlerLoop(this);
    }

    @Override
    public void start() {
        this.moveHandleLoop.start();
        System.out.println("start call move manager");
    }

    @Override
    public void pause() {
        this.moveHandleLoop.stop();
        System.out.println("pause call move manager");
    }

    @Override
    public void resume() {
        this.moveHandleLoop.start();
        System.out.println("resume call move manager");
    }

    @Override
    public void reset(InstanceManager instanceManager) {
        this.instanceManager = instanceManager;
        this.moveHandleLoop.stop();
        System.out.println("reset call move manager");
    }

    public void setEnemyBasePos(AEnemy e) {
        Positioner.setXMiddle(e, SceneManager.getCurWidth() * e.getStartPosX());
        Positioner.setYMiddle(e, SceneManager.getCurHeight() * e.getStartPosY() - e.body.getFitHeight());
    }

    public void setEnemyBulletBasePos(AEnemy e, Bullet b) {
        Positioner.setXMiddle(b, Positioner.getXCenter(e));
        Positioner.setYBottom(b, Positioner.getYBottom(e));
    }

    public void setShepBulletBasePos(Bullet b) {
        Positioner.setXMiddle(b, Positioner.getXCenter(this.instanceManager.getShep()));
        Positioner.setYTop(b, Positioner.getYTop(this.instanceManager.getShep()));
    }
}
