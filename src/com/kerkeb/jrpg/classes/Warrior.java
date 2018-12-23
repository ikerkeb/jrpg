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

    /**
     * Sword attack that deal damage equal to the warrior strength
     * @param target target of the sword attack
     */
    @Override
    public void basicAttack(Player target) {
        int damage = this.strength;
        target.dealDamage(damage);
    }

    /**
     * The player puts himself in Beast mode for this turn
     * He deals twice his strength as damages to the target
     * But he also deal damage to himself equal to half his strength
     * @param target target of the Beast mode attack
     */
    @Override
    public void specialAttack(Player target) {
        int damage = this.strength * 2;
        int selfDamage = this.strength / 2;

        target.dealDamage(damage);

        this.dealDamage(selfDamage);
    }
}
