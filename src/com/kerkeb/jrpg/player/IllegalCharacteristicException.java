package com.kerkeb.jrpg.player;

public class IllegalCharacteristicException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The sum of your characteristics can't be higher than the player level";
    }
}
