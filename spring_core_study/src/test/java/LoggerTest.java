import logger.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {
    private static Logger LOG;

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        LOG = (Logger) context.getBean("logger");
    }

    @Test
    void logInfo(){
        String infoLog = "Test log info";
        LOG.info(infoLog);
        assertTrue(LOG.getInfo().toString().contains("[INFO] " + infoLog));
    }

    @Test
    void logWarn(){
        String warnLog = "Test log warn";
        LOG.warn(warnLog);
        assertTrue(LOG.getWarnings().toString().contains("[WARN] " + warnLog));
    }

    @Test
    void logError(){
        String errorLog = "Test error warn";
        LOG.error(errorLog);
        assertTrue(LOG.getErrors().toString().contains("[ERROR] " + errorLog));
    }

    @Test
    void cleanInfo(){
        String infoLog = "Info log 1";
        LOG.info(infoLog);
        assertEquals(1, LOG.getInfo().size());
        assertTrue(LOG.getInfo().toString().contains("[INFO] " + infoLog));
        LOG.cleanInfo();
        assertEquals(0, LOG.getInfo().size());
        assertFalse(LOG.getInfo().toString().contains("[INFO] " + infoLog));
    }

    @Test
    void cleanWarnings(){
        String warnLog = "Warning log 1";
        LOG.warn(warnLog);
        assertEquals(1, LOG.getWarnings().size());
        assertTrue(LOG.getWarnings().toString().contains("[WARN] " + warnLog));
        LOG.cleanWarnings();
        assertEquals(0, LOG.getWarnings().size());
        assertFalse(LOG.getWarnings().toString().contains("[WARN] " + warnLog));
    }

    @Test
    void cleanErrors(){
        String error = "Error log 1";
        LOG.error(error);
        assertEquals(1, LOG.getErrors().size());
        assertTrue(LOG.getErrors().toString().contains("[ERROR] " + error));
        LOG.cleanErrors();
        assertEquals(0, LOG.getErrors().size());
        assertFalse(LOG.getErrors().toString().contains("[ERROR] " + error));
    }

    @Test
    void clean(){
        String infoLog = "Info log 1";
        String warnLog = "Warning log 1";
        String error = "Error log 1";

        LOG.info(infoLog);
        LOG.warn(warnLog);
        LOG.error(error);

        assertEquals(1, LOG.getInfo().size());
        assertEquals(1, LOG.getWarnings().size());
        assertEquals(1, LOG.getErrors().size());

        assertTrue(LOG.getInfo().toString().contains("[INFO] " + infoLog));
        assertTrue(LOG.getWarnings().toString().contains("[WARN] " + warnLog));
        assertTrue(LOG.getErrors().toString().contains("[ERROR] " + error));

        LOG.clean();

        assertEquals(0, LOG.getInfo().size());
        assertEquals(0, LOG.getWarnings().size());
        assertEquals(0, LOG.getErrors().size());

        assertFalse(LOG.getInfo().toString().contains("[INFO] " + infoLog));
        assertFalse(LOG.getWarnings().toString().contains("[WARN] " + warnLog));
        assertFalse(LOG.getErrors().toString().contains("[ERROR] " + error));
    }

    @Test
    void saveInfoLogs(){
        String infoLog = String.format("Info log %s", new Date().toString());
        String fileLine = String.format("%s %s",
                "[INFO]",
                infoLog);
        LOG.info(infoLog);
        LOG.save();

        String path = String.format("%s/%s/%s",
                "/Users/ivan/Documents/projects/logs/info",
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
                "info.log");

        assertTrue(getFileContent(path).contains(fileLine));
    }

    @Test
    void saveWarnLogs(){
        String warnLog = String.format("Warn log %s", new Date().toString());
        String fileLine = String.format("%s %s",
                "[WARN]",
                warnLog);
        LOG.warn(warnLog);
        LOG.save();

        String path = String.format("%s/%s/%s",
                "/Users/ivan/Documents/projects/logs/warn",
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
                "warn.log");
        assertTrue(getFileContent(path).contains(fileLine));
    }

    @Test
    void saveErrorLogs(){
        String errorLog = String.format("Error log %s", new Date().toString());
        String fileLine = String.format("%s %s",
                "[ERROR]",
                errorLog);
        LOG.error(errorLog);
        LOG.save();

        String path = String.format("%s/%s/%s",
                "/Users/ivan/Documents/projects/logs/error",
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
                "error.log");
        assertTrue(getFileContent(path).contains(fileLine));
    }

    private String getFileContent(String path) {
        List<String> fileLines = new LinkedList();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                fileLines.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLines.toString();
    }
}