package services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.User;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final static int NUMBER_OF_USERS = 2;
    private final static String EMAIL = "test@test.com";
    private static User user1;
    private static User user2;
    private UserService service = new UserService();

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        user1 = (User) context.getBean("user");
        user2 = (User) context.getBean("user");

        user1.setEmail(EMAIL);
    }

    @AfterEach
    void afterTestCleanUp(){
        service.remove(user1);
    }

    @Test
    void testSetId(){
        assertNotEquals(user1.getId(), user2.getId());
    }

    @Test
    void testSave(){
        service.save(user1);
        assertTrue(service.getAllUsers().contains(user1));
    }

    @Test
    void testRemove(){
        service.save(user1);
        service.remove(user1);
        assertFalse(service.getAllUsers().contains(user1));
    }

    @Test
    void testGetById(){
        service.save(user1);
        assertEquals(service.getById(user1.getId()), user1);
    }

    @Test
    void testGetByEmail(){
        service.save(user1);
        assertEquals(service.getByEmail(user1.getEmail()), user1);
    }

    @Test
    void getAllUsers(){
        service.save(user1);
        service.save(user2);
        assertEquals(service.getAllUsers().size(), NUMBER_OF_USERS);
    }
}