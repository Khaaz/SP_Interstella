package core.managers;

import core.objects.entities.Bullet;
import core.objects.entities.sprites.ASprite;
import core.objects.entities.sprites.Shep;
import core.objects.entities.sprites.enemies.AEnemy;
import core.objects.entities.items.AItem;

import java.util.ArrayList;
import java.util.HashMap;

public class InstanceManager {

    private GameManager gameManager;

    private ASprite shep;
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
    }

    // GETTER
    public ASprite getShep() {
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

    // SETTER - ADDER - REMOVER
    public void refreshEnemies(ArrayList<AEnemy> enemies) {
        this.enemies = enemies;
    }

    public void addEnemy(AEnemy e) {
        this.enemies.add(e);
        this.gameManager.getMoveManager().setEnemyBasePos(e);
        this.gameManager.getShowManager().show(e);
    }

    public Boolean removeEnemy(AEnemy e) {
        System.out.println("remove");
        return this.enemies.remove(e);
    }

    public void addItem(AItem i) {
        this.items.put(i.toString(), i);
    }

    public AItem removeItem(String key) {
        return this.items.remove(key);
    }
}
