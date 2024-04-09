package org.humber.country.exceptions;

public enum ErrorCode {
    INVALID_COUNTRY_ID("Invalid country id"),
    INVALID_COUNTRY_NAME("Invalid country name");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
