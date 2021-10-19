package com.gym.bootcamp.exception;

public class GymSpaceNotFoundException extends RuntimeException {
    public GymSpaceNotFoundException(String message) {
        super(message);
    }
}