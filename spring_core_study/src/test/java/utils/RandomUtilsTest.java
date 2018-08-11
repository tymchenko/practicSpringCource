package utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RandomUtilsTest {
    private static RandomUtils randomUtils;

    @BeforeAll
    static void beforeTestSetUp(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        randomUtils = (RandomUtils) context.getBean("randomUtils");
    }

    @Test
    void verifyRandomUtilsNotNull(){
        assertNotNull(randomUtils);
    }

    @Test
    void getRandomLong(){
        assertNotEquals(randomUtils.getRandomLong(), randomUtils.getRandomLong());
    }
}