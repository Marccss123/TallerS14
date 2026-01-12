package autenticacion.excepciones;

public class EmpleadoYaExisteException extends Exception {
    public EmpleadoYaExisteException(String message) {
        super(message);
    }
}
