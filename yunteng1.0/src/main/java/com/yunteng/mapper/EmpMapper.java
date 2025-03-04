package com.yunteng.mapper;

import com.yunteng.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

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

    /**
     * 删除学生
     *
     * @param id
     */

    @Delete("DELETE FROM tlias.emp WHERE id = #{id}")
    void delete(Integer id);

    /**
     * 根据ID查询员工
     * @param id
     * @return
     */
    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    /**
     * 修改学生信息
     */


}
