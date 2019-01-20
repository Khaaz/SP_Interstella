package core.managers;

import core.objects.sprites.entities.ASprite;
import core.objects.sprites.entities.enemies.AEnemy;
import core.objects.sprites.items.AItem;

import java.util.ArrayList;
import java.util.HashMap;

public class CollisionManager {
    private ASprite shep;
    private ArrayList<AEnemy> enemies;

    private ArrayList<String> bulletsShep;
    private ArrayList<String> bulletEnemies;

    private HashMap<String, AItem> items;

    public CollisionManager(ASprite shep) {
        this.shep = shep;
    }


    public void refreshEnemies(ArrayList enemies) {
        this.enemies = enemies;
    }

    public void addItem(AItem i) {
        this.items.put(i.toString(), i);
    }

    public AItem removeItem(String key) {
        return this.items.remove(key);
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
