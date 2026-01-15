package exception;

public final class ConfigReadingException extends RuntimeException {

    public ConfigReadingException(String message) {
        super("Error reading configuration: " + message);
    }
}
