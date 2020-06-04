package eu.delebarre.testspring.restservices.dao;

import eu.delebarre.testspring.restservices.model.User;
import mapper.UserRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Component("dbOfUsers")
public class UserPostgres implements UserDao {
    public UserPostgres(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    NamedParameterJdbcTemplate template;

    @Override
    public List<User> listAll() {
        return template.query("select * from users", new UserRowMapper());
    }

    @Override
    public User getUserById(UUID id) {
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
