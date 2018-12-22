package com.kerkeb.jrpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void Given_gameAnd2Players_When_onePlayerDies_Then_StopGame() {
        
    }

    @Test
    void Given_game_When_stopMethodIsCalled_Then_stopGame() {
        Game game = new Game();

        game.start();
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