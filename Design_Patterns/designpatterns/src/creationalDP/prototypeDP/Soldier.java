package creationalDP.prototypeDP;

public class Soldier implements Cloneable{

    private int health;

    private int speed;

    private int lifeTime;

    private int agility;

    private int rank;

    private int power;

    private String weapon;

    private boolean isAvailableForWar;

    public Soldier(int health, int speed, int lifeTime, int agility, int rank, int power, String weapon, boolean isAvailableForWar) {
        this.health = health;
        this.speed = speed;
        this.lifeTime = lifeTime;
        this.agility = agility;
        this.rank = rank;
        this.power = power;
        this.weapon = weapon;
        this.isAvailableForWar = isAvailableForWar;
    }

    public void showSoldierInfo(){
        System.out.println("health = " + health);
        System.out.println("speed = " + speed);
        System.out.println("lifeTime = " + lifeTime);
        System.out.println("agility = " + agility);
        System.out.println("rank = " + rank);
        System.out.println("power = " + power);
        System.out.println("weapon = " + weapon);
        if (isAvailableForWar){
            System.out.println("Soldier is ready for war!");
        }else System.out.println("Soldier is not ready for war!");
    }

    @Override
    public Soldier clone(){
        Soldier soldier = null;
        try {
            soldier = (Soldier) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return soldier;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public boolean isAvailableForWar() {
        return isAvailableForWar;
    }

    public void setAvailableForWar(boolean availableForWar) {
        isAvailableForWar = availableForWar;
    }
}
