package autenticacion.excepciones;

public class EmpleadoNoEncontradoException extends RuntimeException {
    public EmpleadoNoEncontradoException(String message) {
        super(message);
    }
}
