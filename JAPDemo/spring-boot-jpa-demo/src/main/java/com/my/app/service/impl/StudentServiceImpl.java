package com.my.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.app.domain.Student;
import com.my.app.repository.StudentRepository;
import com.my.app.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findByName(String name) {
        List<Student> students = studentRepository.findByName(name);
        return students != null && !students.isEmpty() ? students.get(0) : null;
    }

    
    
}
