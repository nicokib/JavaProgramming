package be.abis.courseadmin.exception;

public class CompanyNotFoundException extends Exception {
    public CompanyNotFoundException() {
        super();
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }

    public CompanyNotFoundException(Throwable cause) {
        super(cause);
    }

    public CompanyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
