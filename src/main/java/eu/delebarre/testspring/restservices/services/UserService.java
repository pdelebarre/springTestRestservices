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
    //@Autowired
    @Qualifier("listOfFakeUsers")
    private UserDao userDao;

    //public UserService(@Qualifier("dbOfUsers") UserDao userDao) {
    //    this.userDao = userDao;
    //}

    public Object getAllUsers() {
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
}
