package eu.delebarre.testspring.restservices.services;

import eu.delebarre.testspring.restservices.dao.UserDao;
import eu.delebarre.testspring.restservices.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserService {
    @Resource
    @Qualifier("dbOfUsers")
    private UserDao userDao;

    public Object findAll() {
        return userDao.listAll();
    }

    public User getUserById(UUID id) {
        return userDao.getUserById(id);
    }

    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean deleteUser(User user) {
        return userDao.deleteUserById(user.getId());
    }

    public void deleteUserById(UUID id) {
        userDao.deleteUserById(id);
    }
}
