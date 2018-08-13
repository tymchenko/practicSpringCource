package services;

import vo.Event;
import vo.Ticket;
import vo.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BookingService {

    public List<String> getTickets(Event event, Date dateTime, User user, List <Integer> seats){
        return null;
    }

    public int calculateDiscount(User user){
        return 0;
    }

    public int getCost(){
        return 0;
    }

    public int getVipCost(){
        return getCost() * 2;
    }

    public Map<Event, Integer> getAllPrices(){
        return null;
    }

    public void bookTickets(List<Ticket> tickets){

    }

    public void bookTicket(Ticket ticket){

    }

    public Map<User, Ticket> getBookedTickets(Event event){
        return null;
    }
}
