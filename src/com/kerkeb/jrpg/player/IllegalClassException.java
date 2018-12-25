package com.kerkeb.jrpg.player;

public class IllegalClassException extends RuntimeException {
    @Override
    public String getMessage() {
        return "You must choose a class between 1 - Warrior, 2 - Thief and 3 - Mage";
    }
}
