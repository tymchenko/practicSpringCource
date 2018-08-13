package vo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingTest {
    private static final Double TICKET_PRICE = 100.0;
    private static Event event;
    private static User user;

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        user = (User) context.getBean("user");
        event = (Event) context.getBean("event");

    }

    @Test
    void getTotalPrice() {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvents(Arrays.asList(event));
        assertEquals(TICKET_PRICE, booking.getTotalPrice());
    }
}