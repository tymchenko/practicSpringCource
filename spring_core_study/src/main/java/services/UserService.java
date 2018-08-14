package services;

import dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.User;

import java.util.List;

public class UserService {
    private UserDao userDao;

    public UserService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring.xml"});
        userDao = (UserDao) context.getBean("userTable");
    }

    public void save(User user){
        userDao.save(user);
    }

    public void remove (User user){
        userDao.remove(user);

    }

    public User getById(long id){
        return userDao.getById(id);
    }

    public User getByEmail(String email){
        return userDao.getByEmail(email);
    }

    public List<User> getAllUsers(){
        return userDao.getAll();
    }
}
