package com.yunteng.mapper;

import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工管理
 */
@Mapper

public interface EmpMapper {

    /**
     * 查询全部部门
     *
     */
    @Select("select * from `tlias`.emp")
    List<Dept> list();

    /**
     * 新增学生
     *
     */
    @Insert("insert into emp(username,name,gender,award,job,entrydate,create_time,dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{award},#{job},#{entrydate},#{createTime},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
