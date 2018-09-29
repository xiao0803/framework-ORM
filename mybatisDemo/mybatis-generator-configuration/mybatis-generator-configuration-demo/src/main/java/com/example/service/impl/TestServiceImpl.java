package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.TestEntity;
import com.example.mapper.TestMapper;

@Service("testServiceImpl")
public class TestServiceImpl {
    @Autowired
    private TestMapper testMapper;
    public TestEntity selectByPrimaryKey(Integer id) {
    	//TestEntity entiry = testMapper.selectByPrimaryKey(id);
    	List<TestEntity> list = testMapper.getAllTest();
    	List<TestEntity> list2 = testMapper.selectAll();
    	System.out.println("@@@@@@@@@@@@@@:" + list);
        return null;
    }
}

