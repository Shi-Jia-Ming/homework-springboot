package com.start.homework.entity;

import lombok.Data;

import java.util.Date;


@Data
public class Department {
    // 部门 id
    private int id;

    // 部门名称
    private String name;

    // 创建时间
    private Date createAt;

    // 更新时间
    private Date updateAt;
}
