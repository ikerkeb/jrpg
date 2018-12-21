package com.kerkeb.jrpg.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThiefTest {

    @Test
    void Given_2thiefs_When_thief1UseBasicAttackOnThief2_Then_dealDamageEqualToThief1Agility() {
        Thief thief1 = new Thief(100,0,100,0);
        Thief thief2 = new Thief(100,0,100,0);

        assertEquals(500, thief2.getHealth());
        thief1.basicAttack(thief2);
        assertEquals(500 - thief1.getAgility(), thief2.getHealth());
    }

    @Test
    void Given_thiefLevel100_When_thief1UseSpecialAttack_thiefAgilityEquals150() {
        Thief thief = new Thief(100,0,100,0);

        assertEquals(100, thief.getAgility());
        thief.specialAttack(thief);
        assertEquals(150, thief.getAgility());
    }

    @Test
    void Given_thiefLevel1_When_thiefUseSpecialAttack_thiefAgilityEquals1() {
        Thief thief = new Thief(1,0,1,0);

        assertEquals(1, thief.getAgility());
        thief.specialAttack(thief);
        assertEquals(1, thief.getAgility());
    }

}