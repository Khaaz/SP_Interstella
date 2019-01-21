package core.managers;

import core.managers.BulletManager.BulletManager;
import core.objects.entities.Bullet;
import core.objects.entities.sprites.ASpaceship;
import core.objects.entities.sprites.Shep;
import core.objects.entities.sprites.enemies.AEnemy;
import core.objects.entities.items.AItem;

import java.util.ArrayList;
import java.util.HashMap;

public class InstanceManager {

    private GameManager gameManager;
    private InstanceHandlerLoop instanceHandlerLoop;
    private BulletManager bulletManager;

    private ASpaceship shep;
    private ArrayList<AEnemy> enemies;

    private ArrayList<Bullet> bulletsShep;
    private ArrayList<Bullet> bulletEnemies;

    private HashMap<String, AItem> items;

    public InstanceManager(GameManager gameManager) {
        this.gameManager = gameManager;

        this.shep = new Shep();
        this.enemies = new ArrayList<>();
        this.bulletsShep = new ArrayList<>();
        this.bulletEnemies = new ArrayList<>();

        this.instanceHandlerLoop = new InstanceHandlerLoop(this);
        this.bulletManager = new BulletManager(this);
    }

    // GETTER
    public ASpaceship getShep() {
        return shep;
    }

    public ArrayList<AEnemy> getEnemies() {
        return enemies;
    }

    public ArrayList<Bullet> getBulletEnemies() {
        return bulletEnemies;
    }

    public ArrayList<Bullet> getBulletsShep() {
        return bulletsShep;
    }

    public void start() {
        this.instanceHandlerLoop.start();
        this.bulletManager.start();
        System.out.println("start call instance manager");
    }

    public void pause() {
        this.instanceHandlerLoop.stop();
        this.bulletManager.pause();
        System.out.println("pause call instance manager");
    }

    public void resume() {
        this.instanceHandlerLoop.start();
        this.bulletManager.resume();
        System.out.println("resume call instance manager");
    }

    public void reset() {
        this.instanceHandlerLoop.stop();
        this.bulletManager.reset(this);
    }

    // SETTER - ADDER - REMOVER

    // ADD
    public void addEnemy(AEnemy e) {
        this.enemies.add(e);
        this.gameManager.getMoveManager().setEnemyBasePos(e);
        this.gameManager.getShowManager().show(e);
    }

    public void addBulletShep(Bullet b) {
        this.bulletsShep.add(b);
        this.gameManager.getMoveManager().setShepBulletBasePos(b);
        this.gameManager.getShowManager().show(b);
    }

    public void addBulletEnemy(AEnemy e, Bullet b) {
        this.bulletEnemies.add(b);
        this.gameManager.getMoveManager().setEnemyBulletBasePos(e, b);
        this.gameManager.getShowManager().show(b);
    }

    // DELETE
    public Boolean removeEnemy(AEnemy e) {
        this.gameManager.getShowManager().unShow(e);
        return this.enemies.remove(e);
    }

    public Boolean removeBulletEnemy(Bullet b) {
        this.gameManager.getShowManager().unShow(b);
        return this.bulletEnemies.remove(b);
    }

    public Boolean removeBulletShep(Bullet b) {
        this.gameManager.getShowManager().unShow(b);
        return this.bulletsShep.remove(b);
    }

    // ITEMS
    public void addItem(AItem i) {
        this.items.put(i.toString(), i);
    }

    public AItem removeItem(String key) {
        return this.items.remove(key);
    }
}
