package org.grostarin.springboot.demorest.exceptions;

public class BookIsBannedException extends RuntimeException {

    public BookIsBannedException() {
        super();
    }

    public BookIsBannedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BookIsBannedException(final String message) {
        super(message);
    }

    public BookIsBannedException(final Throwable cause) {
        super(cause);
    }
}
