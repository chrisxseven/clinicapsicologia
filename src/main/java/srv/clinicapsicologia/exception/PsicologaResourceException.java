package srv.clinicapsicologia.exception;

public class PsicologaResourceException extends Exception {

    private static final long serialVersionUID = 7358650892789067700L;

    public PsicologaResourceException() {
        super();
    }

    public PsicologaResourceException(String message) {
        super(message);
    }

    public PsicologaResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PsicologaResourceException(Throwable cause) {
        super(cause);
    }

    public PsicologaResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
