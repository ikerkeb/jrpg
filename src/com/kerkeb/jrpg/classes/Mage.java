package com.kerkeb.jrpg.classes;

import com.kerkeb.jrpg.player.Player;

public class Mage extends Player {

    public Mage(int level, int strength, int agility, int intel) {
        super(level, strength, agility, intel);
    }

    /**
     * Fire ball that deal damage equal to the mage intel
     * @param target target of the fire ball
     */
    @Override
    public void basicAttack(Player target) {
        int damage = this.getIntel();
        target.dealDamage(damage);
        System.out.println("- " + damage + "HP!");
    }

    /**
     * Heal that gives you twice your intel as bonus health
     * You can't get more health than what you started with
     * @param target You
     */
    @Override
    public void specialAttack(Player target) {
        target = this;
        target.heal();
    }
}
