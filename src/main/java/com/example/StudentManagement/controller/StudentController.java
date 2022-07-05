package com.example.StudentManagement.controller;

import com.example.StudentManagement.constant.CONSTANT;
import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CONSTANT.STUDENTCONTROLLER)
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(CONSTANT.CREATESTUDENT)
    String createStudent(@RequestBody Student student) {
        String result = null;
        try {
            studentService.createStudent(student);
            result = "Successfully created";
        } catch (Exception e) {
            result = "Unsuccessfully created";
        }
        return result;
    }

    @PutMapping(CONSTANT.UPDATESTUDENT)
    String updateStudent(@RequestBody Student student) throws ParameterNotvalidException {
        String s = null;
        try {
            studentService.updateStudentDetails(student);
            s = "successfully Updated";
        } catch (ParameterNotvalidException e) {
            s = "Data Not Found";
        }
        return s;
    }
    @Transactional
    @GetMapping(CONSTANT.GETALLSTUDENT)
    List<Student> getALlStudent() {
        List<Student> getALlStudent = studentService.getAllStudent();
        return getALlStudent;
    }

    @DeleteMapping(CONSTANT.DELETESTUDENT)
    String deleteStudent(@PathVariable("id") int id) throws ParameterNotvalidException {
        String s = null;
        System.out.println("Delete Student Method Executed");
        try {
            studentService.deleteStudent(id);
            s = "Successfully deleted";
        } catch (ParameterNotvalidException p) {
            s = "Data Not Found";
        }
        return s;
    }
}
