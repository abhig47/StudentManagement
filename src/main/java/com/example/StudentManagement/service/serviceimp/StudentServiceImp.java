package com.example.StudentManagement.service.serviceimp;

import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.StudentRepository;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
            s.getAddress().size();
        }
        return getALLStudent;
    }

    @Override
    public List<Student> findALLStudentUsingQuery() {
        return studentRepository.findALLStudentUsingQuery();
    }

    @Override
    public List<Student> getAllStudentUsingCB() {
        return studentRepository.findALLStudentUsingCB();
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

    @Override
    public List<Student> findStudentByID(int id) {
        return studentRepository.findStudentById(id);
    }

}