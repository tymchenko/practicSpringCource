package dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Booking;
import vo.Event;
import vo.Ticket;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingDaoTest {
    private static BookingDao dao;

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        dao = (BookingDao) context.getBean("bookingDao");
    }

    @Test
    void save() {
        Booking booking = getBooking(false);
        dao.save(booking);
        assertTrue(dao.getAll().contains(booking));

        dao.remove(booking);
    }

    @Test
    void remove() {
        Booking booking = getBooking(false);
        dao.save(booking);
        assertTrue(dao.getAll().contains(booking));

        dao.remove(booking);
        assertFalse(dao.getAll().contains(booking));
    }

    @Test
    void getAll() {
        Booking booking1 = getBooking(true);
        Booking booking2 = getBooking(false);
        Booking booking3 = getBooking(true);
        Booking booking4 = getBooking(false);

        dao.save(booking1);
        dao.save(booking2);
        dao.save(booking3);
        dao.save(booking4);

        assertTrue(dao.getAll().contains(booking1));
        assertTrue(dao.getAll().contains(booking2));
        assertTrue(dao.getAll().contains(booking3));
        assertTrue(dao.getAll().contains(booking4));

        dao.remove(booking1);
        dao.remove(booking2);
        dao.remove(booking3);
        dao.remove(booking4);

    }

    private Booking getBooking(boolean isVip){
        Booking booking = new Booking();
        booking.setTickets(Arrays.asList(getTestTicket(isVip)));
        return booking;
    }

    private Ticket getTestTicket(boolean isVip){
        Ticket ticket = new Ticket();
        ticket.setDate(new Date());
        ticket.setEvent(new Event());
        ticket.setVip(isVip);

        return ticket;
    }
}