package dao;

import enams.EventRating;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Booking;
import vo.Event;
import vo.Ticket;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BookingDaoTest {
    private static final Double TICKET_PRICE = 100.0;
    private static final Double VIP_TICKET_PRICE = 200.0;
    private static BookingDao dao;

    @BeforeAll
    static void beforeTestSetup() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring.xml"});

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

    @Test
    void getTicketsPriceOneTicketVipFalse() {
        Booking booking = new Booking();
        booking.setTickets(Arrays.asList(getTestTicket(false)));
        dao.save(booking);
        assertEquals(TICKET_PRICE, dao.getTicketsPrice(booking));
    }

    @Test
    void getTicketsPriceOneTicketVipTrue() {
        Booking booking = new Booking();
        booking.setTickets(Arrays.asList(getTestTicket(true)));
        dao.save(booking);
        assertEquals(VIP_TICKET_PRICE, dao.getTicketsPrice(booking));
    }

    @Test
    void getBookedTickets() {

    }

    @Test
    void getAllPrices() {
        Event event1 = getTestEvent();
        Event event2 = getTestEvent();
        Event event3 = getTestEvent();
        Event event4 = getTestEvent();

        Ticket ticket1 = getTestTicket(true, event1);
        Ticket ticket2 = getTestTicket(true, event2);
        Ticket ticket3 = getTestTicket(true, event3);
        Ticket ticket4 = getTestTicket(true, event4);

        Booking booking = new Booking();
        booking.setTickets(Arrays.asList(ticket1, ticket2, ticket3, ticket4));
        dao.save(booking);

        assertEquals(VIP_TICKET_PRICE, dao.getAllPrices(booking).get(0).get(event1));
        assertEquals(VIP_TICKET_PRICE, dao.getAllPrices(booking).get(1).get(event2));
        assertEquals(VIP_TICKET_PRICE, dao.getAllPrices(booking).get(2).get(event3));
        assertEquals(VIP_TICKET_PRICE, dao.getAllPrices(booking).get(3).get(event4));
    }

    private Event getTestEvent() {
        Event event = new Event();
        event.setName("Test name");
        event.setDates(Arrays.asList(new Date()));
        event.setRating(EventRating.MIDDLE);

        return event;
    }

    private Booking getBooking(boolean isVip) {
        Booking booking = new Booking();
        booking.setTickets(Arrays.asList(getTestTicket(isVip)));
        return booking;
    }

    private Ticket getTestTicket(boolean isVip) {
        Ticket ticket = new Ticket();
        ticket.setDate(new Date());
        ticket.setEvent(new Event());
        ticket.setVip(isVip);

        return ticket;
    }

    private Ticket getTestTicket(boolean isVip, Event event) {
        Ticket ticket = getTestTicket(isVip);
        ticket.setEvent(event);
        return ticket;
    }
}