package com.ag.lld.tictactoe.model;

public class InvalidGameException extends RuntimeException {
    public InvalidGameException(String message) {
        super(message);
    }
}
