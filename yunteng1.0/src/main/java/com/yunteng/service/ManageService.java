package com.yunteng.service;

import com.yunteng.pojo.Manage;
import java.util.List;

/**
 * 员工管理
 */
public interface ManageService {


    /*PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
     */

    /**
     * 新增员工
     *
     * @param manage
     */

    void save(Manage manage);

    /**
     * 根据ID查询员工
     *
     * @param id
     * @return
     */
    Manage getById(Integer id);


    Manage login(Manage manage);

    /**
     * 管理员登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回对应的Manage对象，失败返回null
     */

    Manage login(String username, String password);

}