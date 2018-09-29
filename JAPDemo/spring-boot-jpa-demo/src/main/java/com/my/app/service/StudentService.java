package com.my.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.my.app.domain.Student;

public interface StudentService {
    
    Student findByName(String name);
    
}
