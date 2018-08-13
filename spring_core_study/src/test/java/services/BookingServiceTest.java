package services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Booking;
import vo.Event;
import vo.User;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingServiceTest {
    private static final Double TICKET_PRICE = 100.0;
    private static final Double VIP_TICKET_PRICE = 200.0;
    private static Event event;
    private static User user;
    private static BookingService service;
    private Booking booking = new Booking();

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        service = (BookingService) context.getBean("bookingService");
        user = (User) context.getBean("user");
        event = (Event) context.getBean("event");

    }

    /*
    returns total price for buying all tickets for specified event on specific date and time for specified seats
     */
    @Test
    void getTicketsPriceOneTicketPositive() {
        booking.setUser(user);
        booking.setEvents(Arrays.asList(event));
        assertEquals(TICKET_PRICE, service.getTicketsPrice(booking));
    }

    @Test
    void calculateDiscount() {
    }

    @Test
    void getCost() {
    }

    @Test
    void getVipCost() {
    }

    @Test
    void getAllPrices() {
    }

    @Test
    void bookTickets() {
    }

    @Test
    void bookTicket() {
    }

    @Test
    void getBookedTickets() {
    }

    @Test
    void ticketPrice(){
        assertEquals(service.getTicketPrice(), TICKET_PRICE);
        assertEquals(service.getVipTicketPrice(), VIP_TICKET_PRICE);
    }

    @Test
    void getTotalBookingTest(){

    }
}