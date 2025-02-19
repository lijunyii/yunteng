package com.yunteng.service.impl;

import com.yunteng.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yunteng.pojo.Dept;
import java.util.List;
import com.yunteng.mapper.DeptMapper;


@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }
}
