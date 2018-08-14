package services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Booking;
import vo.Event;
import vo.Ticket;
import vo.User;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingServiceTest {
    private static final Double TICKET_PRICE = 100.0;
    private static final Double VIP_TICKET_PRICE = 200.0;
    private static Event event1 = new Event();
    private static Event event2 = new Event();
    private static User user = new User();
    private static BookingService service;
    private Booking booking = new Booking();

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        service = (BookingService) context.getBean("bookingService");
    }

    @Test
    void getTicketsPriceOneTicketVipFalse() {
        booking.setTickets(Arrays.asList(getTestTicket(false)));
        assertEquals(TICKET_PRICE, service.getTicketsPrice(booking));
    }

    @Test
    void getTicketsPriceOneTicketVipTrue() {
        booking.setTickets(Arrays.asList(getTestTicket(true)));
        assertEquals(VIP_TICKET_PRICE, service.getTicketsPrice(booking));
    }

    @Test
    void calculateDiscount() {
    }

    @Test
    void getAllPrices() {
//        Ticket ticket = new Ticket();
//
//        booking.getTickets(Arrays.asList(event1, event2));
//        for(Map<Event, Double> eventPrice : service.getAllPrices(booking)){
//            for(Event event : eventPrice.keySet()) {
//                assertEquals(TICKET_PRICE, eventPrice.get(event));
//            }
//        }
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

    private Ticket getTestTicket(boolean isVip){
        Ticket ticket = new Ticket();
        ticket.setDate(new Date());
        ticket.setEvent(event1);
        ticket.setVip(isVip);

        return ticket;
    }
}