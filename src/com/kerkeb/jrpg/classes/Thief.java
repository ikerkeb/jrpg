package com.kerkeb.jrpg.classes;

import com.kerkeb.jrpg.player.Player;

public class Thief extends Player {

    public Thief(int level, int strength, int agility, int intel) {
        super(level, strength, agility, intel);
    }

    /**
     * Arrow shoot that deal damage equal to the thief agility
     * @param target target of the Arrow shoot
     */
    @Override
    public void basicAttack(Player target) {
        int damage = this.agility;
        target.dealDamage(damage);
        System.out.println("- " + damage + "HP!");
    }

    /**
     * Focus on yourself a bonus equal to half your level in agility
     * @param target You
     */
    @Override
    public void specialAttack(Player target) {
        target = this;
        target.buffAgility();
    }
}
