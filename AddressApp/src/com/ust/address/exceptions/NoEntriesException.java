package com.ust.address.exceptions;

public class NoEntriesException extends Exception{
    public NoEntriesException() {
    }

    public NoEntriesException(String message) {
        super(message);
    }

    public NoEntriesException(Throwable cause) {
        super(cause);
    }
}
