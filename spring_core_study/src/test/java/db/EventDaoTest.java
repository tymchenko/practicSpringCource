package db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Event;

import static org.junit.jupiter.api.Assertions.*;

class EventDaoTest {
    private static final String NAME = "Test event1";
    private static final int NUMBER_OF_EVENTS = 2;
    private static Event event1;
    private static Event event2;
    private static EventDao dao;

    @BeforeAll
    static void beferoTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        event1 = (Event) context.getBean("event");
        event2 = (Event) context.getBean("event");
        dao = (EventDao) context.getBean("eventDao");
    }

    @AfterEach
    void afterTestCleanup(){
        dao.remove(event1);
    }

    @Test
    void notNull(){
        assertNotNull(event1);
        assertNotNull(dao);
    }

    @Test
    void save() {
        dao.save(event1);
        assertTrue(dao.getAll().contains(event1));
    }

    @Test
    void remove() {
        dao.save(event1);
        assertTrue(dao.getAll().contains(event1));
        dao.remove(event1);
        assertFalse(dao.getAll().contains(event1));
    }

    @Test
    void getById() {
        dao.save(event1);
        assertEquals(dao.getById(event1.getId()), event1);
    }

    @Test
    void getByName() {
        event1.setName(NAME);
        dao.save(event1);

        assertEquals(dao.getByName(event1.getName()), event1);
    }

    @Test
    void getAll() {
        dao.save(event1);
        dao.save(event2);

        assertEquals(dao.getAll().size(), NUMBER_OF_EVENTS);
    }

    @Test
    void getForDateRange() {
    }

    @Test
    void getNextEvents() {
    }
}