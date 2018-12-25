package com.kerkeb.jrpg;

import com.kerkeb.jrpg.classes.Thief;
import com.kerkeb.jrpg.classes.Warrior;
import com.kerkeb.jrpg.player.IllegalClassException;
import com.kerkeb.jrpg.player.Player;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void Given_wrongClassParameter_When_buildingPlayerCharacter_Then_throwIllegalClassException() {
        Game game = new Game();

        HashMap<String, Integer> wrongClassHash = new HashMap<>();
        wrongClassHash.put("class", 17);
        wrongClassHash.put("level", 100);
        wrongClassHash.put("strength", 100);
        wrongClassHash.put("agility", 0);
        wrongClassHash.put("intel", 0);

        assertThrows( IllegalClassException.class, () -> {
            game.createCharacter( wrongClassHash );
        });
    }

    @Test
    void Given_2players_When_createCharacterMethodCalled_Then_buildCharacterViaHash() {
        Player player1 = new Warrior(100,100,0,0);
        Player player2 = new Thief(100,0,100,0);
        Game game = new Game();

        HashMap<String, Integer> warriorHash = new HashMap<>();
        warriorHash.put("class", 1);
        warriorHash.put("level", 100);
        warriorHash.put("strength", 100);
        warriorHash.put("agility", 0);
        warriorHash.put("intel", 0);

        HashMap<String, Integer> thiefHash = new HashMap<>();
        thiefHash.put("class", 2);
        thiefHash.put("level", 100);
        thiefHash.put("strength", 0);
        thiefHash.put("agility", 100);
        thiefHash.put("intel", 0);

        Player warrior = game.createCharacter( warriorHash );
        Player thief = game.createCharacter( thiefHash );

        assertEquals( player1.getClass().getSimpleName(), warrior.getClass().getSimpleName() );
        assertEquals( player1.getLevel(), warrior.getLevel() );
        assertEquals( player1.getStrength(), warrior.getStrength() );
        assertEquals( player1.getAgility(), warrior.getAgility() );
        assertEquals( player1.getIntel(), warrior.getIntel() );
        assertEquals( player1.getHealth(), warrior.getHealth() );

        assertEquals( player2.getClass().getSimpleName(), thief.getClass().getSimpleName() );
        assertEquals( player2.getLevel(), thief.getLevel() );
        assertEquals( player2.getStrength(), thief.getStrength() );
        assertEquals( player2.getAgility(), thief.getAgility() );
        assertEquals( player2.getIntel(), thief.getIntel() );
        assertEquals( player2.getHealth(), thief.getHealth() );
    }


    @Test
    void Given_game_When_stopMethodIsCalled_Then_stopGame() {
        Game game = new Game();

        assertEquals(false, game.gameOver);
        game.stop();
        assertEquals(true, game.gameOver);
    }

    @Test
    void Given_game_When_welcomeMethodCalled_Then_displayWelcomeMessage() {
        Game game = new Game();

        assertEquals("Welcome to JRPG", game.welcome());
    }
}