import jdk.nashorn.internal.ir.annotations.Ignore;
import logger.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String infoLog = "Info log 1";
        LOG.info(infoLog);
        LOG.save();
    }

    @Ignore
    @Test
    void saveWarnLogs(){

    }

    @Ignore
    @Test
    void saveErrorLogs(){

    }
}