package com.example.start_with_hibernate.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity   //
@Table    //
@Data     //getter setters
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name;
    String gender;
    int age;
    String address;
    String email;
    String phone;
    String course;
}
