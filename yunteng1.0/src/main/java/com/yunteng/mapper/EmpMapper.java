package com.yunteng.mapper;

import com.yunteng.pojo.Dept;
import com.yunteng.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
     *查找
     */
    Emp findByUsername(@Param("username") String username);

    /**
     * 查询全部学生
     */
    @Select("select * from `tlias`.emp")
    List<Emp> list();

    /**
     * 新增学生
     */
    @Insert("insert into emp(username,name,gender,award,job,entrydate,create_time,dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{award},#{job},#{entrydate},#{createTime},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);
}
