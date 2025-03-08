package com.yunteng.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.yunteng.pojo.Manage;
import java.util.List;
import java.time.LocalDate;

/**
 * 管理员管理
 */
@Mapper
public interface ManageMapper {
     /**
      * 查询全部管理员
      *
      * @return
      */
    @Select("select * from Manage")
    List<Manage> list();

    /**
     * 根据id删除管理员
     * @param id
     */
    @Delete("delete from Manage where id = #{id}")
    void deleteById(Integer id);


    /**
     * 添加管理员
     * @param manage
     */
    @Insert("manage (name, sex, age, phone, address, email) values (#{name}, #{sex}, #{age}, #{phone}, #{address}, #{email})")
    void insert(Manage manage);

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

    @Select("select * from Manage where username = #{username} and password = #{password}")
    //@Select("select * from manage where username =#{username} and password =#{password})
    Manage getByUsernameAndPassword(Manage manage);

     /**
     * 根据ID查询管理员
     * @param id
     * @return
     */
    @Select("select * from Manage where  id = #{id}")
    Manage getById(Integer id);
}
