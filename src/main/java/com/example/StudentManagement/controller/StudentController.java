package com.example.StudentManagement.controller;

import com.example.StudentManagement.constant.CONSTANT;
import com.example.StudentManagement.exception.ParameterNotvalidException;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
            s = "successfully deleted";
        } catch (ParameterNotvalidException p) {
            s = "Data Not Found";
        }
        return s;
    }
}
