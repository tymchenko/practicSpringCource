package logger;

public class InfoLog extends Log implements Savable{
    private static final String LEVEL = "[INFO]";

    public InfoLog(String message) {
        super(message, LEVEL);
    }

    @Override
    public void save() {

    }
}
