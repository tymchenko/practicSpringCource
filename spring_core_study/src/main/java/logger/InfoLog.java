package logger;

public class InfoLog extends Log {
    private static final String LEVEL = "[INFO]";

    public InfoLog(String message) {
        super(message, LEVEL);
    }
}
