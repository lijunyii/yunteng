package com.yunteng.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.yunteng.pojo.Manage;
import java.util.List;

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
     * 根据id删除部门
     * @param id
     */
    @Delete("delete from Manage where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param manage
     */
    @Insert("Manage (name, sex, age, phone, address, email) values (#{name}, #{sex}, #{age}, #{phone}, #{address}, #{email})")
    void insert(Manage manage);
}
