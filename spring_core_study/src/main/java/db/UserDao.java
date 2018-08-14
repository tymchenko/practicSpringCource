package db;

import utils.RandomUtils;
import vo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDao {
    private final Map<Long, User> users = new HashMap();

    public void save(User user){
        user.setId(new RandomUtils().getRandomLong());
        users.put(user.getId(), user);
    }

    public void remove(User user){
        users.remove(user.getId());
    }

    public User getById(Long id){
        return users.get(id);
    }

    public User getByEmail(String email){
        return getAll().stream().filter(i -> i.getEmail().equals(email)).findFirst().get();
    }

    public List<User> getAll(){
        return users.values().stream().collect(Collectors.toList());
    }
}
