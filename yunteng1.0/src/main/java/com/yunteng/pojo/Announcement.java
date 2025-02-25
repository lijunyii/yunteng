package com.yunteng.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 公告栏实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    private Integer id;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
