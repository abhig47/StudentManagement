package com.example.StudentManagement.service;

import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    Student createStudent(Student s);

    String deleteStudent(int id) throws ParameterNotvalidException;

    List<Student> getAllStudent();
}