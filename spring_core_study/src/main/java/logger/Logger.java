package logger;

import java.util.LinkedList;
import java.util.List;

public class Logger {
    private List<InfoLog> info = new LinkedList();
    private List<WarnLog> warnings = new LinkedList();
    private List<ErrorLog> errors = new LinkedList();


    public void info(String message) {
        info.add(new InfoLog(message));
    }

    public List<InfoLog> getInfo() {
        return info;
    }

    public void warn(String message) {
        warnings.add(new WarnLog(message));
    }

    public List<WarnLog> getWarnings() {
        return warnings;
    }

    public void error(String message) {
        errors.add(new ErrorLog(message));
    }

    public List<ErrorLog> getErrors() {
        return errors;
    }

    public void cleanInfo() {
        info.clear();
    }

    public void cleanWarnings() {
        warnings.clear();
    }

    public void cleanErrors() {
        errors.clear();
    }

    public void clean() {
        cleanInfo();
        cleanWarnings();
        cleanErrors();
    }
}
