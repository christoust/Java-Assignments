package com.ust.address.exceptions;

public class NoEntryException extends Exception {
    public NoEntryException() {
    }

    public NoEntryException(String message) {
        super(message);
    }

    public NoEntryException(Throwable cause) {
        super(cause);
    }
}
