package com.example.start_with_hibernate.Controller;

import com.example.start_with_hibernate.DAO.Student_Dao;
import com.example.start_with_hibernate.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    Student_Dao student_Dao;

    @GetMapping("/home")
    public String home() {
        System.out.println("This is the home");
        return "This is the home returned";
    }
    @PostMapping("/Student")
    public String saveStudent(@RequestBody Student student) {
        student_Dao.save(student);
        return "Student saved "+student.getName();
    }
    @GetMapping("/Student")
    public List<Student> getStudent() {
        return student_Dao.getAll();
    }
    @GetMapping("/Student/{id}")
    public Student getStudent(@PathVariable int id) {
        return student_Dao.get(id);
    }

    @DeleteMapping("/Studend/{id}")
    public String delete(@PathVariable int id) {
        student_Dao.delete(id);
        return id+ " Student deleted ";
    }

    @PutMapping("/Student")
    public String updateStudent(@RequestBody Student student) {
        student_Dao.update(student);
        return "Student updated "+student.getName();
    }

}
