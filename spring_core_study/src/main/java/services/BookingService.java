package services;

import dao.BookingDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.Booking;
import vo.Event;
import vo.Ticket;
import vo.User;

import java.util.List;
import java.util.Map;

public class BookingService {
    private BookingDao dao;

    public BookingService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        dao = (BookingDao) context.getBean("bookingDao");
    }

    public Double getTicketsPrice(Booking booking) {
        return booking.getTickets().stream().mapToDouble(ticket -> ticket.getEvent().getPrice()).sum();
    }

    public int calculateDiscount(User user) {
        return 0;
    }

    public List<Map<Event, Double>> getAllPrices(Booking booking) {
        return dao.getAllPrices(booking);
    }

    public void bookTickets(List<Ticket> tickets, User user) {
        tickets.forEach(ticket -> bookTicket(ticket, user));
    }

    public void bookTicket(Ticket ticket, User user) {

    }

    public Map<User, Ticket> getBookedTickets(Event event) {
        return dao.getBookedTickets(event);
    }
}
