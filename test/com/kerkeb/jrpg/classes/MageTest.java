package com.kerkeb.jrpg.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MageTest {
    @Test
    void Given_2mages_When_mage1UseBasicAttackOnMage2_Then_dealDamageEqualToMage1Intel() {
        Mage mage1 = new Mage(100,0,0,100);
        Mage mage2 = new Mage(100,0,0,100);

        assertEquals(500, mage2.getHealth());
        mage1.basicAttack(mage2);
        assertEquals(500 - mage1.getIntel(), mage2.getHealth());
    }

    @Test
    void Given_mageLevel100_When_Mage1UseSpecialAttack_MageIntelEquals150() {
        Mage mage = new Mage(100,0,0,100);

        assertEquals(100, mage.getIntel());
        mage.specialAttack(mage);
        assertEquals(150, mage.getIntel());
    }

}