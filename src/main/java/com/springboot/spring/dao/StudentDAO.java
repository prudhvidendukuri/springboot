package com.springboot.spring.dao;

import com.springboot.spring.entity.Student;

import java.util.List;

public interface StudentDAO {
     void save(Student student);

     Student findById(Integer primaryKey);

     List<Student> findAll();

     List<Student> findByWhere();

     List<Student> findByLike(String condition);

     List<Student> findOrderBy();

     void updateStudent(Student student);

     void deleteStudent(int id);

}
