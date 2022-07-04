package com.example.StudentManagement.controller;

import com.example.StudentManagement.constant.CONSTANT;
import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
