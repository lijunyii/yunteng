package com.yunteng.service;

import com.yunteng.pojo.Emp;

import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {

    /**
     * 新增学生
     *
     * @param emp
     */
    void save(Emp emp);

    /**
     * 查询全部学生
     *
     * @return
     */
    List<Emp> list();

}
