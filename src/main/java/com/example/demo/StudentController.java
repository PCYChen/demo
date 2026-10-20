package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired 
    private StudentService studentService;

    @GetMapping("/mvcSelectStudent/{studentId}")
    public Student mvcSelectStudent(@PathVariable Integer studentId) {
        System.out.println("selectStudent by studentId: " + studentId);
        Student student = studentService.getStudentById(studentId);
        return student;
    }
}
