package com.kerkeb.jrpg.player;

public class Player {

    protected int level;
    protected int strength;
    protected int agility;
    protected int intel;
    protected int health;

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntel() {
        return intel;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public void setLevel(int level) {
        try {
            if (level >= 1 && level <= 100) {
                this.level = level;
            } else {
                throw (new IllegalLevelException());
            }
        } catch (IllegalLevelException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public void setCharacteristics(int strength, int agility, int intel) {
        try {
            if (strength + agility + intel <= level) {
                this.strength = strength;
                this.agility = agility;
                this.intel = intel;
            } else {
                throw (new IllegalCharacteristicException());
            }
        } catch (IllegalCharacteristicException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }


    public Player(int level, int strength, int agility, int intel) {
        setLevel(level);
        setCharacteristics(strength, agility, intel);
        this.health = level * 5;
    }

    @Override
    public String toString() {
        return "Player{" +
                "level=" + level +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intel=" + intel +
                ", health=" + health +
                '}';
    }

    /**
     * Deals damage to the target
     * @param damage the number of damage to deal
     */
    public void dealDamage(int damage) {
        health = getHealth();

        setHealth(health - damage);
    }

    public boolean isDead() {
        if (this.getHealth() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void buffAgility() {
        int buff = this.level / 2;
        buff += this.agility;
        this.setAgility(buff);
    }

    public void buffIntel() {
        int buff = this.level / 2;
        buff += this.intel;
        this.setIntel(buff);
    }
}
