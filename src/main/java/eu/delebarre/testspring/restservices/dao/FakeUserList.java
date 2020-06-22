package eu.delebarre.testspring.restservices.dao;

import eu.delebarre.testspring.restservices.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("listOfFakeUsers")
@Primary
public class FakeUserList implements UserDao{
    private static final List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("Philippe", "Delebarre"));
        userList.add(new User("Ana", "Telles"));
    }

    public List<User> listAll() {
        return userList;
    }

    @Override
    public User getUserById(UUID id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUserById(UUID id) {
        return userList.remove(this.getUserById(id));

    }

    @Override
    public boolean updateUser(User user) {
        User oldUser = getUserById(user.getId());
        try {
            userList.set(userList.indexOf(oldUser), user);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean addUser(User user) {
        return userList.add(user);
    }
}
