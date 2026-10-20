package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController {

    @Autowired 
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostMapping ("/insertStudent")
    public String insertStudent(@RequestBody Student student) {
        String sql = "INSERT INTO student (id, name) VALUES (:id, :name)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", student.getId());
        params.put("name", student.getName());
        namedParameterJdbcTemplate.update(sql, params);
        return "Student inserted successfully";
    }

    @PutMapping("/updateStudent/{studentId}")
    public String update(@PathVariable Integer studentId, @RequestBody Student student) {
        String sql = "UPDATE student SET name = :name WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", studentId);
        params.put("name", student.getName());
        namedParameterJdbcTemplate.update(sql, params);
        return "Student updated successfully";
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        String sql = "DELETE FROM student WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", studentId);
        namedParameterJdbcTemplate.update(sql, params);
        return "Student deleted successfully";
    }
    
    @GetMapping("/selectAllStudent")
    public List<Student> selectAllStudent() {
        System.out.println("Reading all students");
        String sql = "SELECT * FROM student";
        Map<String, Object> params = new HashMap<>();
        StudentRowMapper rowMapper = new StudentRowMapper();
        List<Student> students = namedParameterJdbcTemplate.query(sql, params, rowMapper);
        return students;
    }

    @GetMapping("/selectStudent/{studentId}")
    public Student selectStudent(@PathVariable Integer studentId) {
        System.out.println("selectStudent by studentId: " + studentId);
        String sql = "SELECT * FROM student WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", studentId);
        StudentRowMapper rowMapper = new StudentRowMapper();
        Student student = namedParameterJdbcTemplate.queryForObject(sql, params, rowMapper);
        return student;
    }
}
