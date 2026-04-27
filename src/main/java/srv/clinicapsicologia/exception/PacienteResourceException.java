package srv.clinicapsicologia.exception;

public class PacienteResourceException extends Exception {

    private static final long serialVersionUID = 5341083185416627866L;

    public PacienteResourceException() {
        super();
    }

    public PacienteResourceException(String message) {
        super(message);
    }

    public PacienteResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PacienteResourceException(Throwable cause) {
        super(cause);
    }

    public PacienteResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}