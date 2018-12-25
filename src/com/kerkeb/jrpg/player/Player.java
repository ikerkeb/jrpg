package com.kerkeb.jrpg.player;

public abstract class Player{

    protected int level;
    protected int strength;
    protected int agility;
    protected int intel;
    protected int health;

    public boolean isDead = false;

    public abstract void basicAttack(Player target);

    public abstract void specialAttack(Player target);

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

    /**
     * Deals damage to the target
     * @param damage the number of damage to deal
     */
    public void dealDamage(int damage) {
        health = this.getHealth();

        setHealth(health - damage);
        if (health <= 0) {
            this.isDead = true;
        }
    }

    public void buffAgility() {
        int buff = this.level / 2;
        buff += this.agility;
        this.setAgility(buff);
        System.out.println("+ " + buff + " Agility!");
    }

    public void heal() {
        int buff = this.intel * 2;
        int currentHealth = this.getHealth();
        int totalHealth = currentHealth += buff;

        this.setHealth( totalHealth );

        if (this.getHealth() >= this.level * 5) {
            this.setHealth( this.level * 5 );
        }
        System.out.println("+ " + buff + " HP! - Total:" + this.getHealth());
    }
}
