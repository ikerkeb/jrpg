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
    void Given_2mageLevel100_When_mage1UseSpecialAttack_Then_mage1HealthEqual500() {
        Mage mage1 = new Mage(100,0,0,100);
        Mage mage2 = new Mage(100,0,0,100);

        assertEquals(500, mage1.getHealth());

        mage2.basicAttack( mage1 );
        assertEquals(400, mage1.getHealth());

        mage1.specialAttack(mage1);
        assertEquals(500, mage1.getHealth());
    }

    @Test
    void Given_2mageLevel100_When_mage1UseSpecialAttack_Then_mage1HealthEqual400() {
        Mage mage1 = new Mage(100,0,0,100);
        Mage mage2 = new Mage(100,0,0,100);

        assertEquals(500, mage1.getHealth());

        mage2.basicAttack( mage1 );
        mage2.basicAttack( mage1 );
        mage2.basicAttack( mage1 );
        assertEquals(200, mage1.getHealth());

        mage1.specialAttack(mage1);
        assertEquals(400, mage1.getHealth());
    }

}