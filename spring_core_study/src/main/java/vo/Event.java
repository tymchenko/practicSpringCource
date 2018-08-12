package vo;

import enams.EventRating;

import java.util.Date;
import java.util.List;

public class Event {
    private Long id;
    private String name;
    private double price;
    private EventRating rating;
    private List<Date> dates;
    private List<Date> time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EventRating getRating() {
        return rating;
    }

    public void setRating(EventRating rating) {
        this.rating = rating;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    public List<Date> getTime() {
        return time;
    }

    public void setTime(List<Date> time) {
        this.time = time;
    }
}
