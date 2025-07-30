package com.example.start_with_hibernate.DAO;

import com.example.start_with_hibernate.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Student_Dao_Implementation  implements Student_Dao {
    private EntityManager em;

    @Autowired
    Student_Dao_Implementation(EntityManager em) {
        this.em = em;
    }
    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    @Transactional
    public void delete(int Id) {
        Student s =em.find(Student.class, Id);
        em.remove(s);
    }

    @Override
    @Transactional
    public void update(Student student) {
        Student s =em.find(Student.class, student.getId());

        em.merge(s);
    }

    @Override
    public Student get(int id) {
        Student s =em.find(Student.class, id);
        return s;
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
        return query.getResultList();
    }
}
