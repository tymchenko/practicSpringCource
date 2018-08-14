package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDaoTest {
    private static User user = new User();
    private static UserDao table;
    private static final String EMAIL = "test@test.com";


    @BeforeAll
    static void beforeTestSetUp(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        user.setEmail(EMAIL);
        table = (UserDao) context.getBean("userDao");
    }

    @AfterEach
    void afterTestCleanUp(){
        table.remove(user);
    }

    @Test
    void save() {
        table.save(user);
        assertTrue(table.getAll().contains(user));
    }

    @Test
    void remove() {
        table.save(user);
        assertTrue(table.getAll().contains(user));
        table.remove(user);
        assertFalse(table.getAll().contains(user));
    }

    @Test
    void getById() {
        table.save(user);
        assertEquals(user, table.getById(user.getId()));
    }

    @Test
    void getByEmail() {
        table.save(user);
        assertEquals(table.getByEmail(user.getEmail()), user);
    }

    @Test
    void getAll() {
        table.save(user);
        assertTrue(table.getAll().size() == 1);
    }
}