package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component 
public class StudentService {

    @Autowired 
    private StudentDao studentDao;

    public Student getStudentById(Integer studentId) {
        System.out.println("getStudentById by studentId: " + studentId);
        Student student = studentDao.getStudentById(studentId);
        return student;
    }
}
