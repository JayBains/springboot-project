package com.example.pokemon_generator.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser(String username) {
        String sql = "INSERT INTO users (username) VALUES (?) ON DUPLICATE KEY UPDATE username = username";
        jdbcTemplate.update(sql, username);
    }

    public Integer getUserIdByUsername(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, username);
    }
}
