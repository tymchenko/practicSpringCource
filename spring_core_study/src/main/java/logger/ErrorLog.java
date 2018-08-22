package logger;

public class ErrorLog extends Log{
    private static final String LEVEL = "[ERROR]";

    public ErrorLog(String message) {
        super(message, LEVEL);
    }
}
