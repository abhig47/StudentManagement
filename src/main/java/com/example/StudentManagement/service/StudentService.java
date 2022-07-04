package com.example.StudentManagement.service;

import com.example.StudentManagement.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    Student createStudent(Student s);
}