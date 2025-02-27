package com.yunteng.service;

import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Manage;


import java.util.List;

/**
 * 管理员管理
 */
public interface ManageService {
    /**
     * 查询全部管理员
     * @return
     */
    List<Manage> list();


    /**
     * 删除管理员
     * @param id
     */
    void delete(Integer id);

    /**
     * 添加部门
     * @param manage
     */
void add(Manage manage);
}
