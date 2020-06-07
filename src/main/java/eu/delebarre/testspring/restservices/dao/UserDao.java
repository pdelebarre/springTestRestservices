package eu.delebarre.testspring.restservices.dao;

import eu.delebarre.testspring.restservices.model.User;

import java.util.UUID;

public interface UserDao { //extends JpaRepository<User, UUID> {
      Object listAll();

      User getUserById(UUID id);

      boolean deleteUserById(UUID id);

      boolean updateUser(User user);

      boolean addUser(User user);
}
