package com.example.StudentManagement.service.serviceimp;

import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> getALLStudent = studentRepository.findAll();
        return getALLStudent;
    }

    @Override
    public String deleteStudent(int id) throws ParameterNotvalidException {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "successfully deleted";
        } else {
            throw new ParameterNotvalidException("Data Not Found");
        }
    }
}
