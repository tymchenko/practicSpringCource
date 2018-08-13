package vo;

import enams.EventRating;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Event {
    private Long id;
    private String name;
    private double price;
    private double vipPrice;
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

    public double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(double vipPrice) {
        this.vipPrice = vipPrice;
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
        dates.sort((Date d1, Date d2) -> d1.compareTo(d2));
    }

    public List<Date> getTime() {
        return time;
    }

    public void setTime(List<Date> time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Double.compare(event.price, price) == 0 &&
                Objects.equals(id, event.id) &&
                Objects.equals(name, event.name) &&
                rating == event.rating &&
                Objects.equals(dates, event.dates) &&
                Objects.equals(time, event.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, rating, dates, time);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", dates=" + dates +
                ", time=" + time +
                '}';
    }
}
