package core.objects;

public class Datasave {
    private String skin;
    private int money;
    private int life;
    private int damage;
    private int bulletspeed;
    private int firerate;

    public Datasave (String skin, int money,int life, int dmg, int bs, int fr){
        this.skin=skin;
        this.money =money;
        this.life =life;
        this.damage =dmg;
        this.bulletspeed =bs;
        this.firerate =fr;
    }

    //GETTERS
    public String getSkin() {
        return skin;
    }
    public int getMoney() {
        return money;
    }
    public int getLife() {
        return life;
    }
    public int getDamage() {
        return damage;
    }
    public int getBulletspeed() {
        return bulletspeed;
    }
    public int getFirerate() {
        return firerate;
    }

    //SETTERS
    public void setSkin(String skin) {
        skin = skin;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setBulletspeed(int bulletspeed) {
        this.bulletspeed = bulletspeed;
    }
    public void setFirerate(int firerate) {
        this.firerate = firerate;
    }
}
