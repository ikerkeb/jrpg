package com.kerkeb.jrpg.classes;

import com.kerkeb.jrpg.player.Player;

public class Mage extends Player implements Action {

    public Mage(int level, int strength, int agility, int intel) {
        super(level, strength, agility, intel);
    }

    @Override
    public void basicAttack(Player target) {
        int damage = this.getIntel();
        target.dealDamage(damage);
    }

    @Override
    public void specialAttack(Player target) {
        target.buffIntel();
    }
}
