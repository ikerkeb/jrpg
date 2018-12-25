package com.kerkeb.jrpg.player;

public class EmptyInputException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Please provide a non-empty input";
    }
}
