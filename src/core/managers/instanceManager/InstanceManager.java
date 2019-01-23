package core.managers.instanceManager;

import constants.CONFIG;
import constants.PATH;
import core.managers.GameManager;
import core.managers.bulletManager.BulletManager;
import core.objects.Datasave;
import core.objects.entities.Bullet;
import core.objects.entities.spaceships.ASpaceship;
import core.objects.entities.spaceships.Shep;
import core.objects.entities.spaceships.enemies.AEnemy;
import core.objects.entities.items.AItem;
import models.DatasaveModel;

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

        DatasaveModel model = new DatasaveModel();
        Datasave ds = model.getDS();
        this.shep = new Shep(PATH.SHEP, CONFIG.DEFAULT_SHEP_WIDTH, CONFIG.DEFAULT_SHEP_HEIGHT, ds.getLife(), ds.getDamage(), CONFIG.DEFAULT_SPEED, ds.getBulletspeed(), ds.getFirerate());


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

    /**
     * Add an enemy to the instance manager
     * Setup his default position
     * Add it to the game / show it
     * @param e AEnemy
     */
    public void addEnemy(AEnemy e) {
        this.enemies.add(e);
        this.gameManager.getPositionManager().setEnemyBasePos(e);
        this.gameManager.getShowManager().show(e);
    }

    /**
     * Add a bullet (shep) to the instance manager
     * Setup his default position
     * Add it to the game / show it
     * @param b
     */
    public void addBulletShep(Bullet b) {
        this.bulletsShep.add(b);
        this.gameManager.getPositionManager().setShepBulletBasePos(b);
        this.gameManager.getShowManager().show(b);
    }

    /**
     * Add a bullet (enemy) to the instance manager
     * Setup his default position
     * Add it to the game / show it
     * @param b
     */
    public void addBulletEnemy(AEnemy e, Bullet b) {
        this.bulletEnemies.add(b);
        this.gameManager.getPositionManager().setEnemyBulletBasePos(e, b);
        this.gameManager.getShowManager().show(b);
    }

    // DELETE

    /**
     * Remove an enemy from the instanceManager / game
     * Destroy all references to the instance =>garbage collected
     * @param e AEnemy
     * @return boolean
     */
    public Boolean removeEnemy(AEnemy e) {
        this.gameManager.getShowManager().unShow(e);
        return this.enemies.remove(e);
    }

    /**
     * Remove a bullet (enemy) from the instanceManager / game
     * Destroy all references to the instance =>garbage collected
     * @param b Bullet
     * @return boolean
     */
    public Boolean removeBulletEnemy(Bullet b) {
        this.gameManager.getShowManager().unShow(b);
        return this.bulletEnemies.remove(b);
    }

    /**
     * Remove a bullet (shep) from the instanceManager / game
     * Destroy all references to the instance =>garbage collected
     * @param b Bullet
     * @return boolean
     */
    public Boolean removeBulletShep(Bullet b) {
        this.gameManager.getShowManager().unShow(b);
        return this.bulletsShep.remove(b);
    }

    // ITEMS not implemented yet
    public void addItem(AItem i) {
        this.items.put(i.toString(), i);
    }

    public AItem removeItem(String key) {
        return this.items.remove(key);
    }
}
