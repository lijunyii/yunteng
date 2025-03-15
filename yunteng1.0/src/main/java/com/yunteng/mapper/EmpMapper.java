package com.yunteng.mapper;

import com.yunteng.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 根据用户名查找员工
     * @param username 用户名
     * @return 员工信息
     */
    @Select("select * from emp where username = #{username}")
    Emp findByUsername(@Param("username") String username);

    /**
     * 查询全部员工
     * @return 员工列表
     */
    @Select("select * from emp")
    List<Emp> list();

    /**
     * 新增员工
     * @param emp 员工信息
     */
    @Insert("insert into emp(username,name,gender,award,job,entry_date,create_time,dept_id,update_time)" +
            "values(#{username},#{name},#{gender},#{award},#{job},#{entryDate},#{createTime},#{deptId},#{updateTime})")
    void insert(Emp emp);

    /**
     * 删除员工
     * @param id 员工ID
     */
    @Delete("DELETE FROM emp WHERE id = #{id}")
    void delete(Integer id);

    /**
     * 根据ID查询员工
     * @param id 员工ID
     * @return 员工信息
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 修改员工信息
     * @param emp 员工信息
     */
    @Update("UPDATE emp " +
            "SET username = #{username}, name = #{name}, gender = #{gender}, " +
            "award = #{award}, job = #{job}, entry_date = #{entryDate}, " +
            "create_time = #{createTime}, dept_id = #{deptId}, update_time = #{updateTime} " +
            "WHERE id = #{id}")
    void update(Emp emp);

    void deleteEmployeeById(Integer id);
}
