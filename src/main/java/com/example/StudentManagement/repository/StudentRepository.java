package com.example.StudentManagement.repository;

import com.example.StudentManagement.model.Student;
import com.example.StudentManagement.repository.customrepository.StudentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustom {
    @Query(value = "select s.*,a.* from student s join address a on s.id = a.student_id", nativeQuery = true)
    List<Student> getStudentUsingNQ();

    @Query(value = "select a.* from student s join address a on s.id = a.student_id where s.id =:id", nativeQuery = true)
    Student getStudentAddressUsingNQ(@Param("id") int id);

    @Query(value = "from student s join fetch s.address")
    List<Student> findALLStudentUsingQuery();

}