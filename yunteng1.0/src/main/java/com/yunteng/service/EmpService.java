package com.yunteng.service;

import com.yunteng.pojo.Emp;

import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {


    void save(Emp emp);

    List<Emp> list();


    void deleteEmp(Integer id);
}
