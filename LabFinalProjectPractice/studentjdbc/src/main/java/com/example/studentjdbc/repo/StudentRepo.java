package com.example.studentjdbc.repo;

//package com.example.studentjdbc.repo;

import com.example.studentjdbc.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private final JdbcTemplate jdbcTemplate;

    public StudentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Student> mapper = (rs, rowNum) ->
            new Student(rs.getInt("id"), rs.getString("name"));

    public int insert(String name) {
        String sql = "INSERT INTO student(name) VALUES (?)";
        return jdbcTemplate.update(sql, name);
    }

    public List<Student> findAll() {
        String sql = "SELECT id, name FROM student ORDER BY id DESC";
        return jdbcTemplate.query(sql, mapper);
    }
}
