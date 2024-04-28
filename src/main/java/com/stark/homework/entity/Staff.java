package com.stark.homework.entity;

import java.sql.Date;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

import com.stark.homework.utils.Gender;

import lombok.Data;

@Data
public class Staff {
    // 员工 id
    private int id;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String name;
    // 性别
    private Gender gender;
    // 图像
    private String image;
    // 职务
    private Job job;
    // 入职时间
    private Date entryDate;
    // 所属的部门
    private Department department;
    // 创建时间
    private Date createAt;
    // 更新时间
    private Date updateAt;
}
