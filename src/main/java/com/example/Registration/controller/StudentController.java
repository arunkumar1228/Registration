package com.example.Registration.controller;

import com.example.Registration.entity.Student;
import com.example.Registration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    private List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{studentid}")
    private Student getStudent(@PathVariable("studentid") Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{studentid}")
    private void delete(@PathVariable("studentid") Long id) {
        studentService.delete(id);
    }

    @PostMapping("/Student")
    private void save(@RequestBody Student student) {
        studentService.saveOrUpdate(student);
        student.getId();
    }

    @PutMapping("/student")
    private Student update(@RequestBody Student student) {
        studentService.update(student);
        return student;
    }
}
