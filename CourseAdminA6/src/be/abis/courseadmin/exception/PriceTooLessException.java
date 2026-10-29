package be.abis.courseadmin.exception;

public class PriceTooLessException extends PriceException {
    public PriceTooLessException() {
        super();
    }

    public PriceTooLessException(String message) {
        super(message);
    }

    public PriceTooLessException(Throwable cause) {
        super(cause);
    }

    public PriceTooLessException(String message, Throwable cause) {
        super(message, cause);
    }
}
