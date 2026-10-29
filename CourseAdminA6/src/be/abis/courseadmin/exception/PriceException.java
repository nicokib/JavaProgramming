package be.abis.courseadmin.exception;

public class PriceException extends Exception {
    public PriceException() {
        super();
    }

    public PriceException(String message) {
        super(message);
    }

    public PriceException(Throwable cause) {
        super(cause);
    }

    public PriceException(String message, Throwable cause) {
        super(message, cause);
    }
}
