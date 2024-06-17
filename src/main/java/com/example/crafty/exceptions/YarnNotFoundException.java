package com.example.crafty.exceptions;

import lombok.Getter;

import java.util.UUID;

@Getter
public class YarnNotFoundException extends RuntimeException {
    private final UUID yarnId;

        public YarnNotFoundException(UUID yarnId) {
            super("Yarn with ID " + yarnId + " not found");
            this.yarnId = yarnId;
        }
}

