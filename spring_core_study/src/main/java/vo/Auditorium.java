package vo;

public class Auditorium {
    private Long id;
    private String name;
    private int numberOfSeats;
    private int numberOfVipSeats;

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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfVipSeats() {
        return numberOfVipSeats;
    }

    public void setNumberOfVipSeats(int numberOfVipSeats) {
        this.numberOfVipSeats = numberOfVipSeats;
    }
}
