package com.example.Registration.service;

import com.example.Registration.entity.Student;
import com.example.Registration.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        studentRepo.findAll().forEach(students1 -> students.add(students1));
        return students;
    }

    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    public void saveOrUpdate(Student student) {
        studentRepo.save(student);
    }

    public void update(Student student) {
        studentRepo.saveAndFlush(student);
    }

    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
}
