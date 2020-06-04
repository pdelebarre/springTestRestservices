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
    @Qualifier("dbOfUsers")
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
}
