package com.springboot.spring.dao;

import com.springboot.spring.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//support for component scanning and jdbc error tracking
//sub annotation of @component
@Repository
public class StudentDAOImp implements StudentDAO{

    private EntityManager entityManager;


    @Autowired
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    @Transactional is used we perform any following changes in DB- create,update and delete operations
    @Override
    @Transactional
    public void save(Student thestudent) {
        entityManager.persist(thestudent);
    }

    @Override
    public Student findById(Integer primaryKey) {
        Student student = entityManager.find(Student.class,1);
        return student;
    }
//    always use entity name instead of sql query column name
//    Student - ENTITY name - not table name
//    firstname,last_name and email are the Student Class Entity Names not column names of the student table
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student", Student.class);
        List<Student> allStudents = theQuery.getResultList();
        return allStudents;
    }

    @Override
    public List<Student> findByWhere() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE firstName = 'ravi'", Student.class);
        List<Student> allStudents = theQuery.getResultList();
        return allStudents;
    }

    @Override
    public List<Student> findByLike(String condition) {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student WHERE last_name =:condition", Student.class);
        theQuery.setParameter("condition",condition);
        List<Student> allStudents = theQuery.getResultList();
        return allStudents;
    }

    @Override
    public List<Student> findOrderBy() {
        TypedQuery<Student> theQuery = entityManager.createQuery("From Student ORDER BY email DESC", Student.class);
        List<Student> allStudents = theQuery.getResultList();
        return allStudents;
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        boolean condition = false;
        if(condition){
            entityManager.merge(student);
        }else{
            int numbersUpdated = entityManager.createQuery(
                    "UPDATE Student SET email = 'prudhviddsp@nerdpine.com'"
            ).executeUpdate();
        }

    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
//        int deletedRows = entityManager.createQuery(
//                "DELETE Student WHERE id = 4"
//        ).executeUpdate();
        Student student = entityManager.find(Student.class,id);
        entityManager.remove(student);
    }
}
