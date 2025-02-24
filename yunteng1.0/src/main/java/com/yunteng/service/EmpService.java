package com.yunteng.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Emp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {


    void save(Emp emp);

    List<Dept> list();
}
