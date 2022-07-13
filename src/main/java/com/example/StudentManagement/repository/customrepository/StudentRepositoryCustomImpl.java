package com.example.StudentManagement.repository.customrepository;

import com.example.StudentManagement.model.Address;
import com.example.StudentManagement.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> findALLStudentUsingCB() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> studentRoot = query.from(Student.class);
//        Join<Student, Address> studentAddressJoin = studentRoot.join("address");
        query.select(studentRoot);
        List<Student> studentQuery = entityManager.createQuery(query).getResultList();
        return studentQuery;
    }

    @Override
    public List<Student> findStudentById(int id) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> studentRoot = query.from(Student.class);

        Join<Student, Address> studentAddressJoin = studentRoot.join("address");
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(studentRoot.get("id"), id));
        query.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
//        Hibernate.initialize(entityManager.createQuery(query).getResultList());

        List<Student> studentQuery = entityManager.createQuery(query).getResultList();
        return studentQuery;
    }
}