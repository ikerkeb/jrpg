package com.kerkeb.jrpg.player;

import com.kerkeb.jrpg.classes.Thief;
import com.kerkeb.jrpg.classes.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void Given_2playersInstance_When_onePlayerDies_Then_thisPlayerIsDeadSetToTrue() {
        Player player1 = new Warrior(100,100,0,0);
        Player player2 = new Warrior(100,100,0,0);

        player1.basicAttack(player2);
        player1.basicAttack(player2);
        player1.basicAttack(player2);
        player1.basicAttack(player2);
        player1.basicAttack(player2);
        assertEquals(0, player2.getHealth());
        assertEquals(true, player2.isDead());
    }


    @Test
    void Given_2playersInstance_When_player2HealthGoesBelow0_Then_player2Dies() {
        Player player1 = new Warrior(100,100,0,0);
        Player player2 = new Warrior(100,100,0,0);

        player1.basicAttack(player2);
        assertEquals( 400, player2.getHealth());
        player1.basicAttack(player2);
        assertEquals( 300, player2.getHealth());
        player1.basicAttack(player2);
        assertEquals( 200, player2.getHealth());
        player1.basicAttack(player2);
        assertEquals( 100, player2.getHealth());
        player1.specialAttack(player2);
        assertEquals( -100, player2.getHealth());
        assertEquals(true, player2.isDead());
    }


    @Test
    void Given_2playersInstance_When_player2HealthEquals0_Then_player2Dies() {
        Player player1 = new Warrior(100,100,0,0);
        Player player2 = new Warrior(100,100,0,0);

        player1.basicAttack(player2);
        assertEquals( 400, player2.getHealth());
        player1.basicAttack(player2);
        assertEquals( 300, player2.getHealth());
        player1.basicAttack(player2);
        assertEquals( 200, player2.getHealth());
        player1.basicAttack(player2);
        assertEquals( 100, player2.getHealth());
        player1.basicAttack(player2);
        assertEquals( 0, player2.getHealth());
        assertEquals(true, player2.isDead());
    }

    @Test
    void Given_2warriorsPlayersInstance_When_player1HitsPlayer2WithSpecialAttack_Then_bothPlayersLoseHealth() {
        Player player1 = new Warrior(100,100,0,0);
        Player player2 = new Warrior(100,100,0,0);

        player1.specialAttack(player2);
        assertEquals( 300, player2.getHealth());
        assertEquals(450, player1.getHealth());
    }

    @Test
    void Given_2playersInstance_When_player1HitsPlayer2WithBasicAttack_Then_player2LoseHealth() {
        Player player1 = new Warrior(100,100,0,0);
        Player player2 = new Warrior(100,100,0,0);

        player1.basicAttack(player2);
        assertEquals( 400, player2.getHealth());
    }


    @Test
    void Given_playerWithInvalidCharacteristic_When_creatingInstance_Then_throwPlayerCharacteristicException() {
        assertThrows(IllegalCharacteristicException.class, () ->{
            Player player1 = new Warrior(100,100,100,100);
        });
        assertThrows(IllegalCharacteristicException.class, () ->{
            Player player2 = new Thief(100,50,50,1);
        });
    }

    @Test
    void Given_playerWithInvalidLevel_When_creatingPlayerInstance_Then_throwPlayerLevelException() {
        assertThrows(IllegalLevelException.class, () -> {
            Player player = new Warrior(200, 20,20,20);
        });
        assertThrows(IllegalLevelException.class, () -> {
            Player player = new Warrior(0, 20,20,20);
        });
    }


    @Test
    void Given_playerWithValidConstructorValues_When_creatingPlayerInstance_Then_createPlayerInstance() {
        Player player = new Warrior(100,80,20,0);
        assertEquals(player, player);
    }


}