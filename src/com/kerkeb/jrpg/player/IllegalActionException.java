package com.kerkeb.jrpg.player;

public class IllegalActionException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Select an action between 1 and 2";
    }

}
