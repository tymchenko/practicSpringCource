package services;

import db.UserTable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.User;

import java.util.List;

public class UserService {
    private UserTable userTable;

    public UserService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        userTable = (UserTable) context.getBean("userTable");
    }

    public void save(User user){
        userTable.save(user);
    }

    public void remove (User user){
        userTable.remove(user);

    }

    public User getById(long id){
        return userTable.getById(id);
    }

    public User getByEmail(String email){
        return userTable.getByEmail(email);
    }

    public List<User> getAllUsers(){
        return userTable.getAll();
    }
}
