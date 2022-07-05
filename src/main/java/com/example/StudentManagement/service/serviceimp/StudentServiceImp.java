package com.example.StudentManagement.service.serviceimp;

import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.service.StudentService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student s) {
        return studentRepository.save(s);
    }

    @Transactional
    @Override
    public List<Student> getAllStudent() {
        List<Student> getALLStudent = studentRepository.findAll();
        for (Student s : getALLStudent) {
//            Hibernate.isInitialized(s);
            s.getAddress();
        }
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

    @Override
    public Student getAddress(Student student) {
        Student getAddress = studentRepository.findById(student.getId()).get();
        return null;
    }

    @Override
    public String updateStudentDetails(Student student) throws ParameterNotvalidException {
        Student updateStudent = studentRepository.findById(student.getId()).get();
        if (studentRepository.findById(updateStudent.getId()).isPresent()) {
            updateStudent.setId(student.getId());
            updateStudent.setAddress(student.getAddress());
            studentRepository.save(updateStudent);
            return "Updated Successfully";
        } else {
            throw new ParameterNotvalidException("Data not Found");
        }
    }
}