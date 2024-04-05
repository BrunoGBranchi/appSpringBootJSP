package br.com.branchi.teste.exception;

public class AppException extends RuntimeException {

    private static final long serialVersionUID = -8309604864649687515L;

	public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(Throwable cause) {
        super(cause);
    }
}
