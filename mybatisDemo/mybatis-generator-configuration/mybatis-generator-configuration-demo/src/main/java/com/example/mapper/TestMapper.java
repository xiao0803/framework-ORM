package com.example.mapper;

import java.util.List;

import com.example.common.CommonMapper;
import com.example.entity.TestEntity;

public interface TestMapper extends CommonMapper<TestEntity> {
	public List<TestEntity> getAllTest();
}