package com.yunteng.service;

import com.yunteng.pojo.Dept;
import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    /**
     * 查询全部部门
     * @return
     */
    List<Dept> list();


    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);
}
