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
    /**
     * 员工登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回对应的Emp对象，失败返回null
     */
    Emp login(String username, String password);

}

