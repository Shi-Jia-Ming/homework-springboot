package com.stark.homework.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Student {
    // id
    private int id;
    // 姓名
    private String name;
    // 学号
    private String stuNumber;
    // 所属班级
    private Class class_;
    // 性别
    private int gender;
    // 手机号
    private String phone;
    // 最高学历
    private int degree;
    // 违纪次数
    private int breakCount;
    // 违纪扣分
    private int minus;
    // 创建时间
    private Date createAt;
    // 修改时间
    private Date updateAt;
}
