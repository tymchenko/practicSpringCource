import logger.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    void saveInfoLogs(){

    }

    @Test
    void saveWarnLogs(){

    }

    @Test
    void saveErrorLogs(){

    }
}