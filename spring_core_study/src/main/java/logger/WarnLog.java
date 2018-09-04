package logger;

public class WarnLog extends Log implements Savable{
    private final static String LEVEL = "[WARN]";

    public WarnLog(String message) {
        super(message, LEVEL);
    }

    @Override
    public void save() {

    }
}
