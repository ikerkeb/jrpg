package com.kerkeb.jrpg.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {

    @Test
    void Given_2warriors_When_warrior1UseBasicAttackOnWarrior2_Then_dealDamageEqualToWarrior1Strength() {
        Warrior warrior1 = new Warrior(100,100,0,0);
        Warrior warrior2 = new Warrior(100,100,0,0);

        assertEquals(500, warrior2.getHealth());
        warrior1.basicAttack(warrior2);
        assertEquals(500 - warrior1.getStrength(), warrior2.getHealth());
    }

    @Test
    void Given_2warriors_When_warrior1UseSpecialAttackOnWarrior2_Then_bothWarriorsReceiveDamages() {
        Warrior warrior1 = new Warrior(100,100,0,0);
        Warrior warrior2 = new Warrior(100,100,0,0);

        assertEquals(500, warrior1.getHealth());
        assertEquals(500, warrior2.getHealth());
        warrior1.specialAttack(warrior2);
        assertEquals(500 - warrior1.getStrength() / 2, warrior1.getHealth());
        assertEquals(500 - warrior1.getStrength() * 2, warrior2.getHealth());
    }

}