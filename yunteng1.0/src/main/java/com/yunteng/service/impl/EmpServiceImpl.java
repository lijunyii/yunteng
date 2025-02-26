package com.yunteng.service.impl;

import com.yunteng.mapper.EmpMapper;
import com.yunteng.pojo.Emp;
import com.yunteng.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
   @Autowired
   private EmpMapper empMapper;

    @Override
    public void save(Emp emp) {

    }

    @Override
    public List<Emp> list() {
        return empMapper.list();
    }

}
