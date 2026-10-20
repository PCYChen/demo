package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    
    @Autowired
    @Qualifier ("hpPrinter") // Specify the bean name to inject
    private Printer printer;

    @RequestMapping("/test")
    public String test() {
        System.out.println("Hi!");
        return "Hello World";
    }

    @RequestMapping("/print")
    public String print() {
        String message = "Hello from Spring Boot!";
        printer.print(message);
        return "Printed: " + message;
    }

    @RequestMapping("/studentQuery")
    public String studentQuery(@RequestParam Integer id) {
        System.out.println("id : " + id);
        return "success";
    }

    @RequestMapping("/studentQueryThurPost")
    public String studentQueryThurPost (@RequestBody Student student) {
        System.out.println("student id : " + student.getId());
        System.out.println("student name : " + student.getName());
        return "success";
    }

    @RequestMapping("/requestHeader")
    public String requestHeader (@RequestHeader String info) {
        System.out.println("info: " + info);
        return "success";
    }

    @RequestMapping("/pathVariable/{id}")
    public String pathVariable(@PathVariable Integer id) {
        System.out.println("id: " + id);
        return "success";
    }

    @PostMapping("/students")
    public String create(@RequestBody Student student) {
        System.out.println("Creating student with ID: " + student.getId() + " and Name: " + student.getName());
        return "execute Create operation";
    }

    @GetMapping("/students/{studentId}")
    public String read(@PathVariable Integer studentId) {
        System.out.println("studentId: " + studentId);
        return "execute Read operation";
    }

    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId, @RequestBody Student student) {
        System.out.println("studentId: " + studentId);
        System.out.println("new student.name: " + student.getName());
        return "execute Update operation";
    }

    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        System.out.println("studentId: " + studentId);
        return "execute Delete operation";
    }

}
