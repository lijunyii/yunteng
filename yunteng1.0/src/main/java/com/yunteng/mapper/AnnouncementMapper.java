package com.yunteng.mapper;

import com.yunteng.pojo.Announcement;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface AnnouncementMapper {
    /**
     * 查询公告列表
     * @return
     */
@Select("select * from announcement")
    List<Announcement> list();

    /**
     * 根据id删除公告
     * @param id
     */
    @Delete("delete from announcement where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加公告
     * @param announcement
     */
    @Insert("insert into announcement(title, content, create_time, update_time) values(#{title}, #{content}, #{createTime}, #{updateTime})")
    void insert(Announcement announcement);
}
