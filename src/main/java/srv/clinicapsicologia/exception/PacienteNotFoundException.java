package srv.clinicapsicologia.exception;

public class PacienteNotFoundException extends Exception {
    private static final long serialVersionUID = -4423085526900017103L;

    public PacienteNotFoundException() {
        super();
    }

    public PacienteNotFoundException(String message) {
        super(message);
    }

    public PacienteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PacienteNotFoundException(Throwable cause) {
        super(cause);
    }

    public PacienteNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

