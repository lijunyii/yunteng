package com.yunteng.service;

import com.yunteng.pojo.Emp;

import java.util.List;
import java.sql.SQLException;

/**
 * 员工管理
 */
public interface EmpService {

    /**
     * 保存员工信息
     * @param emp 员工对象
     * @throws SQLException 数据库操作异常
     */
    void save(Emp emp) throws SQLException;

    /**
     * 查询所有员工信息
     * @return 员工列表
     * @throws SQLException 数据库操作异常
     */
    List<Emp> list() throws SQLException;

    /**
     * 根据员工 ID 删除员工信息
     * @param id 员工 ID
     * @throws SQLException 数据库操作异常
     */
    void deleteEmployeeById(Integer id) throws SQLException;

    void deleteEmp(Integer id);

    /**
     * 根据 ID 查询员工信息
     * @param id 员工 ID
     * @return 员工对象
     * @throws SQLException 数据库操作异常
     */
    Emp getById(Integer id) throws SQLException;

    /**
     * 员工登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回对应的 Emp 对象，失败返回 null
     * @throws SQLException 数据库操作异常
     */
    Emp login(String username, String password) throws SQLException;
}