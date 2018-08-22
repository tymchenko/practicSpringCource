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
        assertTrue(LOG.getInfoLogs().contains(infoLog));
    }

    @Test
    void logWarn(){

    }

    @Test
    void logError(){

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