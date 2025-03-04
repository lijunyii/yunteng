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

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);


}
