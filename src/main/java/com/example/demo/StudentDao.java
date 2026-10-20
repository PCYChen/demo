package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component 
public class StudentDao {

    @Autowired 
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Student getStudentById(Integer studentId) {
        String sql = "SELECT * FROM student WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", studentId);
        StudentRowMapper rowMapper = new StudentRowMapper();
        Student student = namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
        return student;
    }
}
