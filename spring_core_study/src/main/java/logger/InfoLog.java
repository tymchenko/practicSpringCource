package logger;

public class InfoLog extends Log implements Savable{
    public InfoLog(String message) {
        super(message, LogLevel.INFO);
    }

    @Override
    public void save() {

    }
}
