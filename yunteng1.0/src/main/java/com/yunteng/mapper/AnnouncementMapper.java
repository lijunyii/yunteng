package com.yunteng.mapper;

import com.yunteng.pojo.Announcement;
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
}
