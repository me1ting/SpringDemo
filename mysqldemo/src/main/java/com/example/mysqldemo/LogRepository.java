package com.example.mysqldemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepository {
    private static final String ADD = "INSERT INTO log(uid,credits,balance) VALUES (?,?,?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addOne(Log log) {
        jdbcTemplate.update(ADD, log.uid, log.credits, log.balance);
    }
}
