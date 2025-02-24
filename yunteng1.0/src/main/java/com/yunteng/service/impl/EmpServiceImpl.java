package com.yunteng.service.impl;

import com.yunteng.mapper.EmpMapper;
import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Emp;
import com.yunteng.service.EmpService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Override
    public List<Dept> list() {
        return List.of();
    }

    private final EmpMapper empMapper;

    public EmpServiceImpl(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Override
    public void save(Emp emp){
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }
}
