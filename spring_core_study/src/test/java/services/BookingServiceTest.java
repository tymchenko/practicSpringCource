package services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Event;
import vo.User;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingServiceTest {
    private static final double TICKET_PRICE = 100.0;
    private static final double VIP_TICKET_PRICE = 200.0;
    private Event event;
    private Date date;
    private User user;
    private static BookingService service;

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        service = (BookingService) context.getBean("bookingService");
    }

    /*
    returns total price for buying all tickets for specified event on specific date and time for specified seats
     */
    @Test
    void getTicketsPrice() {
        assertEquals(service.getTicketsPrice(event, date, user, Arrays.asList(1)), TICKET_PRICE);
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
}