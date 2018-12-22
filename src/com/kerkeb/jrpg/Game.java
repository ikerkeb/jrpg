package com.kerkeb.jrpg;

public class Game {

    boolean gameOver;

    public void start() {
        this.welcome();
    }

    public void stop() {
        this.gameOver = true;
    }
//
//    public boolean gameOver() {
//        return this.gameOver = true;
//    }


    /**
     * Display welcome message when a new game is started
     */
    public String welcome() {
        String welcome = "Welcome to JRPG";
        return (welcome);
    }
}
