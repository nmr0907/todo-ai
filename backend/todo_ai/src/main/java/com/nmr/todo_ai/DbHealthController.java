package com.nmr.todo_ai;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DbHealthController {

    private final JdbcTemplate jdbc;

    public DbHealthController(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @GetMapping("/health/db")
    public Map<String, Object> checkDb() {
        // DBに実クエリを投げる
        Integer one = jdbc.queryForObject("SELECT 1", Integer.class);
        String version = jdbc.queryForObject("SELECT version()", String.class);
        String db = jdbc.queryForObject("SELECT current_database()", String.class);

        return Map.of(
                "ok", one != null && one == 1,
                "database", db,
                "version", version);
    }
}
