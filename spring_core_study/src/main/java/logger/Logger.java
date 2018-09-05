package logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger implements Savable{
    private InfoLog info;
    private WarnLog warning;
    private ErrorLog error;
    private String infoLogDirectoryPath;
    private String infoLogFileName;
    private String warnLogDirectoryPath;
    private String warnLogFileName;
    private String errorLogDirectoryPath;
    private String errorLogFileName;

    public InfoLog getInfo() {
        return info;
    }

    public WarnLog getWarning() {
        return warning;
    }

    public ErrorLog getError() {
        return error;
    }

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
        info = new InfoLog(message);
    }

    public void warn(String message) {
        warning = new WarnLog(message);
    }

    public void error(String message) {
        error = new ErrorLog(message);
    }

    @Override
    public void save() {
        saveInfoLog();
        saveWarnLog();
        saveErrorLog();
    }

    private void saveLog(Log log) {
        String logDate = log.date.substring(0, log.date.indexOf(' '));
        Date date= null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(logDate);
        } catch (ParseException e) {
            error(e.getMessage());
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
        try {
            File logFile = new File(String.format("%s/%s", logDir, fileName));
            FileWriter writer = new FileWriter(logFile, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.append(message);
            bw.close();
        } catch (IOException e) {
            error(e.getMessage());
        }
    }

    private void saveInfoLog() {
        if(info != null) {
            saveLog(info);
        }
    }

    private void saveWarnLog() {
        if(warning != null) {
            saveLog(warning);
        }
    }

    private void saveErrorLog() {
        if(error != null){
            saveLog(error);
        }
    }
}
