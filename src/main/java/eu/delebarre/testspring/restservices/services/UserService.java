package eu.delebarre.testspring.restservices.services;

import eu.delebarre.testspring.restservices.dao.UserDao;
import eu.delebarre.testspring.restservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    @Qualifier("listOfFakeUsers")
    private final UserDao userDao;

    public UserService(@Qualifier("listOfFakeUsers") UserDao userDao) {
        this.userDao = userDao;
    }

    public Object getAllUsers() {
        return userDao.listAll();
    }

    public User getUserById(UUID id) {
        return userDao.getUserById(id);
    }
}
