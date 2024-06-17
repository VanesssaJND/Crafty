package com.example.crafty.exceptions;

import lombok.Getter;

@Getter
public class ErrorResponse {
    public ErrorResponse(int value, String message) {

    }

    public class ResponseError {
        private final int statusCode;
        private final String message;
        private final long timestamp;

        public ResponseError(int statusCode, String message) {
            this.statusCode = statusCode;
            this.message = message;
            this.timestamp = System.currentTimeMillis();
        }
    }
}
