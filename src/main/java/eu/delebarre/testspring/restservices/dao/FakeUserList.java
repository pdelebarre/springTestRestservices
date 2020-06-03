package eu.delebarre.testspring.restservices.dao;

import eu.delebarre.testspring.restservices.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Component("listOfFakeUsers")
@Primary
public class FakeUserList implements UserDao{
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("Philippe"));
        userList.add(new User("Ana"));
    }

    public List<User> listAll() {
        return userList;
    }

    @Override
    public User getUserById(UUID id) {
        User user;
        for (User value : userList) {
            user = value;
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUserById(UUID id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
