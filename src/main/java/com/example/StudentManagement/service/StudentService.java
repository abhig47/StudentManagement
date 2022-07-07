package com.example.StudentManagement.service;

import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student s);

    String deleteStudent(int id) throws ParameterNotvalidException;

    List<Student> getAllStudent();

    String updateStudentDetails(Student student) throws ParameterNotvalidException;

    List<Student> getALLStudentUsingNQ();

    List<Student> getAllStudentUsingCB();

    List<Student> findStudentByID(int id);

}