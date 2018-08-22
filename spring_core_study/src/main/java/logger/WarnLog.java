package logger;

public class WarnLog extends Log{
    private final static String LEVEL = "[WARN]";

    public WarnLog(String message) {
        super(message, LEVEL);
    }
}
