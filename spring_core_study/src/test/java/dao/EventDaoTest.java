package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventDaoTest {
    private static final String NAME = "Test event1";
    private static final int NUMBER_OF_EVENTS = 2;
    private static Event event1 = new Event();
    private static Event event2 = new Event();
    private static Event event3 = new Event();
    private static EventDao dao;

    @BeforeEach
    void beferoTestSetup() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring.xml"});

        dao = (EventDao) context.getBean("eventDao");
    }

    @AfterEach
    void afterTestCleanup() {
        dao.remove(event1);
    }

    @Test
    void notNull() {
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
        List firstDateList = Arrays.asList(parseDate("01.01.2018"));
        List secondDateList = Arrays.asList(parseDate("01.01.2015"));
        List thirdDateList = Arrays.asList(parseDate("01.01.2010"));

        event1.setDates(firstDateList);
        event2.setDates(secondDateList);
        event3.setDates(thirdDateList);

        dao.save(event1);
        dao.save(event2);
        dao.save(event3);

        event1 = dao.getForDateRange(parseDate("01.01.2014"), parseDate("01.01.2016")).get(0);

        assertEquals(event2, dao.getForDateRange(parseDate("01.01.2014"), parseDate("01.01.2016")).get(0));
        assertTrue(dao.getForDateRange(parseDate("01.01.2014"), parseDate("01.01.2016")).size() == 1);
    }

    @Test
    void getNextEvents() {
        List firstDateList = Arrays.asList(parseDate("01.01.2018"));
        List secondDateList = Arrays.asList(parseDate("01.10.2018"));
        List thirdDateList = Arrays.asList(parseDate("01.01.2010"));

        event1.setDates(firstDateList);
        event2.setDates(secondDateList);
        event3.setDates(thirdDateList);

        dao.save(event1);
        dao.save(event2);
        dao.save(event3);

        List list = dao.getNextEvents(parseDate("01.02.2018"));
        assertTrue(dao.getNextEvents(parseDate("01.12.2018")).size() == 1);
        assertEquals(event2, dao.getNextEvents(parseDate("01.12.2018")).get(0));

    }

    private static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}