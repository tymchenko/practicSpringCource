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
    void testInfo(){
        String infoLog = String.format("Info log %s", new Date().toString());
        String fileLine = String.format("%s %s",
                "[INFO]",
                infoLog);
        LOG.info(infoLog);

        String path = String.format("%s/%s/%s",
                "/Users/ivan/Documents/projects/logs/info",
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
                "info.log");

        assertTrue(getFileContent(path).contains(fileLine));
    }

    @Test
    void testWarn(){
        String warnLog = String.format("Warn log %s", new Date().toString());
        String fileLine = String.format("%s %s",
                "[WARN]",
                warnLog);
        LOG.warn(warnLog);

        String path = String.format("%s/%s/%s",
                "/Users/ivan/Documents/projects/logs/warn",
                new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
                "warn.log");
        assertTrue(getFileContent(path).contains(fileLine));
    }

    @Test
    void saveError(){
        String errorLog = String.format("Error log %s", new Date().toString());
        String fileLine = String.format("%s %s",
                "[ERROR]",
                errorLog);
        LOG.error(errorLog);

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