package autenticacion.excepciones;

public class RostroYaRegistradoException extends RuntimeException {
    public RostroYaRegistradoException(String message) {
        super(message);
    }
}
