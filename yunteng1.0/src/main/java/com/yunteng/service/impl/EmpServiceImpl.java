package com.yunteng.service.impl;

import com.yunteng.mapper.EmpMapper;
import com.yunteng.pojo.Emp;
import com.yunteng.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> list() {
        return List.of();
    }

    @Override
    public Emp login(String username, String password) {
        Emp emp =empMapper.findByUsername(username);
        if(Objects.nonNull(emp) && emp.getPassword().equals(password)){
            return emp;
        }
        return null;
    }


    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);


        }
    }




