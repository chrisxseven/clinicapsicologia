package srv.clinicapsicologia.exception;

public class PsicologaNotFoundException extends Exception {
    private static final long serialVersionUID = 1479166460224127700L;

    public PsicologaNotFoundException() {
        super();
    }

    public PsicologaNotFoundException(String message) {
        super(message);
    }

    public PsicologaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PsicologaNotFoundException(Throwable cause) {
        super(cause);
    }

    public PsicologaNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}