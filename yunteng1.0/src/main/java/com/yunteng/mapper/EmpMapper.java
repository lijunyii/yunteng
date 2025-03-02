package com.yunteng.mapper;

import com.yunteng.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工管理
 */
@Mapper

public interface EmpMapper {

    /**
     * 查询全部部门
     */
    @Select("select * from emp")
    List<Emp> list();

    /**
     * 新增学生
     *
     */
    @Insert("insert into emp(username,name,gender,award,job,entry_date,create_time,dept_id,update_time)" +
            "values(#{username},#{name},#{gender},#{award},#{job},#{entryDate},#{createTime},#{deptId},#{updateTime})")
    void insert(Emp emp);
}
