package services;

import db.UserTable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.User;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private int NUMBER_OF_USERS = 5;
    private static User user1;
    private static User user2;

    private UserTable users = new UserTable();

    @BeforeAll
    static void beforeTestSetup(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        user1 = (User) context.getBean("user");
        user2 = (User) context.getBean("user");
    }

    @Test
    void testSetId(){
        assertNotEquals(user1.getId(), user2.getId());
    }

    @Test
    void testSave(){
        users.save(user1);
        assertTrue(users.getAll().contains(user1));
    }

    @Test
    void testRemove(User user){

    }

    @Test
    void getById(long id){

    }

    @Test
    void getAllUsers(){
        assertEquals(users.getAll().size(), NUMBER_OF_USERS);
    }
}