package logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class Log {
    protected String message;
    protected String date;
    protected String level;

    public Log(String message, String level) {
        this.message = message;
        this.level = level;
        date = currentDate();
    }

    private String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(new Date());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", date, level, message);
    }
}
