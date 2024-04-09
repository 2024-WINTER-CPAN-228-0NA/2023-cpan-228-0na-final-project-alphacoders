package org.humber.country.exceptions;

public class CountryValidationException extends RuntimeException {

    private final ErrorCode errorCode;

    public CountryValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
