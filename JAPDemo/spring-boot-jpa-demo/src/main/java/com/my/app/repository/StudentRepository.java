package com.my.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.my.app.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{
    
    @Query(value = "select s from Student s where s.name = ?1")
    List<Student> findByName(@Param("name") String name);
    
}
