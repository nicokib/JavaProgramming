package be.abis.courseadmin.exception;

public class PriceTooHighException extends PriceException {
    public PriceTooHighException() {
        super();
    }

    public PriceTooHighException(String message) {
        super(message);
    }

    public PriceTooHighException(Throwable cause) {
        super(cause);
    }

    public PriceTooHighException(String message, Throwable cause) {
        super(message, cause);
    }
}
