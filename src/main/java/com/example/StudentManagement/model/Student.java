package com.example.StudentManagement.model;

import com.example.StudentManagement.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int rollno;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
//    @JoinColumn(name = "standard_id")
    private Standard standard;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Set<Subject> subject;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Set<Address> address;
}