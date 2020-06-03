package eu.delebarre.testspring.restservices.dao;

import eu.delebarre.testspring.restservices.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("mapOfFakeUsers")
@Primary
public class FakeUserMap implements UserDao{
    private static Map<UUID, User> userMap = new HashMap<>();

    static {
        User user = new User("Philippe");
        userMap.put(user.getId(),user);
        user=new User("Ana");
        userMap.put(user.getId(),user);
    }

    public Object listAll() {
        return userMap;
    }

    @Override
    public User getUserById(UUID id) {
        return userMap.get(id);
    }

    @Override
    public boolean deleteUserById(UUID id) {
        return userMap.remove(id, getUserById(id));
    }

    @Override
    public boolean updateUser(User user) {
        User oldUser = userMap.get(user.getId());
        return userMap.replace(oldUser.getId(),oldUser,user);
    }
}
