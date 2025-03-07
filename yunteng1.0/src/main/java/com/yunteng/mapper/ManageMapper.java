package com.yunteng.mapper;

import com.yunteng.pojo.Manage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * 学生管理
 */
@Mapper
public interface ManageMapper {

    /**
     * 管理员信息查询
     * @return
     */
    //@Select("select * from manage")
    public List<Manage> list(String name, Short gender, LocalDate begin, LocalDate end);


    /**
     * 新增管理员
     * @param manage
     */
    @Insert("insert into manage(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Manage manage);

    /**
     * 根据ID查询管理员
     * @param id
     * @return
     */
    @Select("select * from manage where  id = #{id}")
    Manage getById(Integer id);


    /**
     * 管理员登录
     * @param manage
     * @return
     */
    Manage login(Manage manage);

    /**
     * 根据用户名和密码查询管理员
     * @param manage
     * @return
     */

    @Select("select * from manage where username = #{username} and password = #{password}")
    //@Select("select * from manage where username =#{username} and password =#{password})
    Manage getByUsernameAndPassword(Manage manage);
}
