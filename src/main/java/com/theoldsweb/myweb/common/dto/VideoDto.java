package com.theoldsweb.myweb.common.dto;

import com.theoldsweb.myweb.common.entity.Video;
import lombok.Data;

import java.util.List;

@Data
public class VideoDto extends Video {
    /**
     * 评价数量
     */
    private Integer commentsNum;

    /**
     * 评价内容
     */
    private List comments;

    private Integer selectType;
}