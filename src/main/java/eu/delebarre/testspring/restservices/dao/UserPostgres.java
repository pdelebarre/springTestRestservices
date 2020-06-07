package eu.delebarre.testspring.restservices.dao;

import eu.delebarre.testspring.restservices.model.User;
import mapper.UserRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
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
        final String sql = "select * from users where id='" + id + "'";
        List<User> users = template.query(sql, new UserRowMapper());
        return users.get(0);
    }

    @Override
    public boolean deleteUserById(UUID id) {
        final String sql = "delete from users where id='" + id + "'";
        List<User> users = template.query(sql, new UserRowMapper());
        return (users.get(0) != null);
    }

    @Override
    public boolean updateUser(User user) {
        final String sql = "update users set name=:newName where id=:id";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("newName", user.getName());
        return (template.update(sql, param) == 1);
    }

    public boolean addUser(User user) {
        final String sql = "insert into users(id, name) values(:id, :name)";

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", user.getId())
                .addValue("name", user.getName());

        return (template.update(sql, param) == 1);

    }
}
