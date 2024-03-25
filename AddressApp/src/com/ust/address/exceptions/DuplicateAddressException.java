package com.ust.address.exceptions;

public class DuplicateAddressException extends Exception{
    public DuplicateAddressException() {
    }

    public DuplicateAddressException(String message) {
        super(message);
    }

    public DuplicateAddressException(Throwable cause) {
        super(cause);
    }
}
