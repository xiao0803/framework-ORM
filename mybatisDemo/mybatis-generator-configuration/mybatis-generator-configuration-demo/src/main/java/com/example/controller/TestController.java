package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 


import com.example.service.impl.TestServiceImpl;

import java.util.*;
 
/**
 * Created by chenqixuan on 17/10/24.
 */
@RestController
//@RequestMapping("/xiao")
public class TestController {
 
    @Autowired
    private TestServiceImpl testServiceImpl;
 
    @GetMapping(value="/test")
    public String getAllUser(){
        testServiceImpl.selectByPrimaryKey(1);
        return null;
    }
 
 
}
