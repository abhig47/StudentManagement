package com.example.StudentManagement.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int std;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
}