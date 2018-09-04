package logger;

public class ErrorLog extends Log implements Savable{
    public ErrorLog(String message) {
        super(message, LogLevel.ERROR);
    }

    @Override
    public void save() {

    }
}
