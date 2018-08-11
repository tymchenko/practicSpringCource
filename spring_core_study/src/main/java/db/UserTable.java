package db;

import vo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserTable {
    private final Map<Long, User> users = new HashMap();

    public void save(User user){
        users.put(user.getId(), user);
    }

    public List<User> getAll(){
        return users.values().stream().collect(Collectors.toList());
    }
}
