package com.stark.homework.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Class {
    // id
    private int id;
    // 班级名称
    private String name;
    // 班级教室
    private String classroom;
    // 开课时间
    private Date startDate;
    // 结课时间
    private Date endDate;
    // 班主任
    private Staff headTeacher;
    // 创建时间
    private Date createAt;
    // 修改时间
    private Date updateAt;
}
