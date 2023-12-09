package com.example.mysqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepository {
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE id = ?";
    private static final String FIND_BY_ID_FOR_UPDATE = "SELECT * FROM user WHERE id = ? FOR UPDATE";
    private static final String UPDATE_CREDIT = "UPDATE user set credit = ? WHERE id = ?";
    private static final String UPDATE_CREDIT_USING_COST = "UPDATE user set credit = credit - ? WHERE id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    User findById(long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, new UserMapper(), id);
    }

    User findOneForUpdate(long id) {
        return jdbcTemplate.queryForObject(FIND_BY_ID_FOR_UPDATE, new UserMapper(), id);
    }

    void updateCredit(User user) {
        jdbcTemplate.update(UPDATE_CREDIT, user.getCredit(), user.getId());
    }

    void updateCreditWithCost(User user, int cost) {
        jdbcTemplate.update(UPDATE_CREDIT_USING_COST, cost, user.getId());
    }
}

class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        var user = new User();
        user.setId(rs.getLong("id"));
        user.setCredit(rs.getLong("credit"));

        return user;
    }
}
