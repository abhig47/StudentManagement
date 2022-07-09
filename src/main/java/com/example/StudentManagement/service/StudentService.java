package com.example.StudentManagement.service;

import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {

    Student createStudent(Student s);

    String deleteStudent(int id) throws ParameterNotvalidException;

    List<Student> getAllStudent();

    String updateStudentDetails(Student student) throws ParameterNotvalidException;

    List<Student> getAllStudentUsingCB();

    List<Student> findALLStudentUsingQuery();

    List<Student> findStudentByID(@Param("id") int id);

}