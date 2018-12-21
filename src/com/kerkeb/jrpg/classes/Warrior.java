package com.kerkeb.jrpg.classes;

import com.kerkeb.jrpg.player.Player;

public class Warrior extends Player implements Action {

    private int health;

    /**
     * Warrior constructor, sets the Warrior's health to his level * 5
     * @param level     Warrior level
     * @param strength  Strength
     * @param agility   Agility
     * @param intel     Intelligence
     */
    public Warrior(int level, int strength, int agility, int intel ) {
        super(level, strength, agility, intel);
    }

    @Override
    public void basicAttack(Player target) {
        int damage = this.strength;
        target.dealDamage(damage);
    }

    @Override
    public void specialAttack(Player target) {
        int damage = this.strength * 2;
        int selfDamage = this.strength / 2;

        target.dealDamage(damage);

        this.dealDamage(selfDamage);
    }
}
