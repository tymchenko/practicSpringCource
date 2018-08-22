package logger;

import java.util.LinkedList;
import java.util.List;

public class Logger {
    private List<Log> infoLog = new LinkedList();

    public void info(String message) {
        infoLog.add(new Log(message));
    }

    public List<Log> getInfoLogs() {
        return null;
    }
}
