package services;

import vo.Booking;
import vo.Event;
import vo.Ticket;
import vo.User;

import java.util.List;
import java.util.Map;

public class BookingService {
    private double ticketPrice;
    private double vipTicketPrice;


    public Double getTicketsPrice(Booking booking) {
        return booking.getEvents().stream().mapToDouble(event -> event.getPrice()).sum();
    }

    public int calculateDiscount(User user) {
        return 0;
    }

    public Map<Event, Integer> getAllPrices() {
        return null;
    }

    public void bookTickets(List<Ticket> tickets, User user) {

    }

    public void bookTicket(Ticket ticket) {

    }

    public Map<User, Ticket> getBookedTickets(Event event) {
        return null;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = Double.parseDouble(ticketPrice);
    }

    public void setVipTicketPrice(String vipTicketPrice) {
        this.vipTicketPrice = Double.parseDouble(vipTicketPrice);
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public Double getVipTicketPrice() {
        return vipTicketPrice;
    }
}
