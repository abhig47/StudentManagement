package com.example.StudentManagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "standard")
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int std;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "student_id")
//    private Student student;
}