package com.example.StudentManagement.repository.customrepository;

import com.example.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepositoryCustom {
    List<Student> findStudent();

    @Query(value = "from student s join fetch s.address")
    List<Student> findALLStudentUsingNQ();

    //    @Query(value = "from student s join fetch s.address where s.id=:id")
    List<Student> findStudentById(@Param("id") int id);

}