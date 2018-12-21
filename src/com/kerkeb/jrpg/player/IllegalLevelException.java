package com.kerkeb.jrpg.player;

public class IllegalLevelException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Your character level must be between 1 and 100";
    }
}
