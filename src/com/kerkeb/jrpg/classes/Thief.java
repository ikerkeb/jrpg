package com.kerkeb.jrpg.classes;

import com.kerkeb.jrpg.player.Player;

public class Thief extends Player implements Action {

    public Thief(int level, int strength, int agility, int intel) {
        super(level, strength, agility, intel);
    }

    @Override
    public void basicAttack(Player target) {
        int damage = this.agility;
        target.dealDamage(damage);
    }

    @Override
    public void specialAttack(Player target) {
        target.buffAgility();
    }
}
