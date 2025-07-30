package com.example.start_with_hibernate.DAO;

import com.example.start_with_hibernate.Entity.Student;

import java.util.List;

public interface Student_Dao {
    public void save(Student student);
    public void delete(int Id);
    public void update(Student student);
    public Student get(int id);
    public List<Student> getAll();
}
