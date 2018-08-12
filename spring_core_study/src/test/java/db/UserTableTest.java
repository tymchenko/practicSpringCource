package db;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTableTest {
    private static User user;
    private static UserTable table;
    private static final String EMAIL = "test@test.com";


    @BeforeAll
    static void beforeTestSetUp(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});

        user = (User) context.getBean("user");
        user.setEmail(EMAIL);
        table = (UserTable) context.getBean("userTable");
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
        Long id = user.getId();
        table.save(user);
        assertEquals(user, table.getById(id));
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