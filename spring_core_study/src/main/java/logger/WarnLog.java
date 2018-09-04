package logger;

public class WarnLog extends Log implements Savable{
    public WarnLog(String message) {
        super(message, LogLevel.WARN);
    }

    @Override
    public void save() {

    }
}
