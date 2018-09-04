package logger;

public class ErrorLog extends Log implements Savable{
    private static final String LEVEL = "[ERROR]";

    public ErrorLog(String message) {
        super(message, LEVEL);
    }

    @Override
    public void save() {

    }
}
