package dao;

import utils.RandomUtils;
import vo.Booking;
import vo.Event;
import vo.Ticket;
import vo.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookingDao {
    private double ticketPrice;
    private double vipTicketPrice;
    Map<Long, Booking> bookings = new HashMap<>();

    public void save(Booking booking){
        booking.setId(new RandomUtils().getRandomLong());
        booking.getTickets()
                .stream()
                .forEach(ticket -> ticket.getEvent()
                        .setPrice(ticket.isVip() ? vipTicketPrice : ticketPrice));
        bookings.put(booking.getId(), booking);
    }

    public void remove(Booking booking){
        bookings.remove(booking.getId());
    }

    public List<Booking> getAll(){
        return bookings.values().stream().collect(Collectors.toList());
    }

    public Double getTicketsPrice(Booking booking) {
        return booking
                .getTickets()
                .stream()
                .mapToDouble(ticket -> ticket.getEvent().getPrice())
                .sum();
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public double getVipTicketPrice() {
        return vipTicketPrice;
    }

    public void setVipTicketPrice(double vipTicketPrice) {
        this.vipTicketPrice = vipTicketPrice;
    }

    public Map<User, Ticket> getBookedTickets(Event event) {
        return null;
    }

    public List<Map<Event, Double>> getAllPrices(Booking booking) {
        List<Map<Event, Double>> prices = new LinkedList();
        for(Ticket ticket : booking.getTickets()) {
            Map<Event, Double> price = new HashMap<>();
            price.put(ticket.getEvent(), ticket.getEvent().getPrice());
            prices.add(price);
        }
        return prices;
    }
}
