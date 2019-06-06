package com.theoldsweb.myweb.common.dto;

import com.theoldsweb.myweb.common.entity.News;
import lombok.Data;

import java.util.List;

@Data
public class NewsDto extends News{

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