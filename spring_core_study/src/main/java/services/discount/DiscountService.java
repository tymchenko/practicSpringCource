package services.discount;

import vo.Event;
import vo.User;

import java.util.Date;
import java.util.List;

public class DiscountService {
    private List<DiscountStrategy> strategies;

    public int getDiscount(User user, Event event, Date dateTime, int numberOfTickets){
        return 0;
    }
}
