package com.example.StudentManagement.service.serviceimp;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student s) {
        return studentRepository.save(s);
    }
}
