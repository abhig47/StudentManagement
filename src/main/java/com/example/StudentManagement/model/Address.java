package com.example.StudentManagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String houseNo;
    private String city;
    private String state;
    private String country;

//    @ManyToOne
//    private Student student;
}