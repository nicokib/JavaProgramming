package be.abis.courseadmin.exception;

public class CompanyAlreadyExistsException extends Exception {
    public CompanyAlreadyExistsException() {
        super();
    }

    public CompanyAlreadyExistsException(String message) {
        super(message);
    }

    public CompanyAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public CompanyAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
