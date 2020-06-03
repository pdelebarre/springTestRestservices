package eu.delebarre.testspring.restservices.dao;

import eu.delebarre.testspring.restservices.model.User;

import java.util.UUID;

public interface UserDao {
      Object listAll();

      User getUserById(UUID id);

      boolean deleteUserById(UUID id);

      boolean updateUser(User user);
}
