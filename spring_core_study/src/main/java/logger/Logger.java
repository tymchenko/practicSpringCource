package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Logger implements Savable{
    private List<InfoLog> info = new LinkedList();
    private List<WarnLog> warnings = new LinkedList();
    private List<ErrorLog> errors = new LinkedList();
    private String infoLogDirectoryPath;
    private String infoLogFileName;
    private String warnLogDirectoryPath;
    private String warnLogFileName;
    private String errorLogDirectoryPath;
    private String errorLogFileName;

    public void setInfoLogDirectoryPath(String infoLogDirectoryPath) {
        this.infoLogDirectoryPath = infoLogDirectoryPath;
    }

    public void setInfoLogFileName(String infoLogFileName) {
        this.infoLogFileName = infoLogFileName;
    }

    public void setWarnLogDirectoryPath(String warnLogDirectoryPath) {
        this.warnLogDirectoryPath = warnLogDirectoryPath;
    }

    public void setWarnLogFileName(String warnLogFileName) {
        this.warnLogFileName = warnLogFileName;
    }

    public void setErrorLogDirectoryPath(String errorLogDirectoryPath) {
        this.errorLogDirectoryPath = errorLogDirectoryPath;
    }

    public void setErrorLogFileName(String errorLogFileName) {
        this.errorLogFileName = errorLogFileName;
    }

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

    @Override
    public void save() {
        saveInfoLog();
        saveWarnLog();
        saveErrorLog();
    }

    private void saveInfoLog() {
        for(InfoLog log: info){
            saveLog(log);
        }
        info.clear();
    }

    private void saveLog(Log log) {
        String logDate = log.date.substring(0, log.date.indexOf(' '));
        Date date= null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(logDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(LogLevel.INFO == log.level){
            saveLog(String.format("%s/%s", infoLogDirectoryPath, new SimpleDateFormat("dd-MM-yyyy").format(date)),
                    infoLogFileName,
                    log.toString());
        }
        if(LogLevel.WARN == log.level){
            saveLog(String.format("%s/%s", warnLogDirectoryPath, new SimpleDateFormat("dd-MM-yyyy").format(date)),
                    warnLogFileName,
                    log.toString());
        }
        if(LogLevel.ERROR == log.level){
            saveLog(String.format("%s/%s", errorLogDirectoryPath, new SimpleDateFormat("dd-MM-yyyy").format(date)),
                    errorLogFileName,
                    log.toString());
        }
    }

    private void saveLog(String logDir, String fileName, String message) {
        File directory = new File(logDir);
        if(!directory.exists()){
            directory.mkdir();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(String.format("%s/%s", logDir, fileName)))) {
            bw.append(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveWarnLog() {
        for(WarnLog log : warnings){
            saveLog(log);
        }
        warnings.clear();
    }

    private void saveErrorLog() {
        for(ErrorLog log : errors){
            saveLog(log);
        }
        errors.clear();
    }
}
