drop database if exists homework;
create database homework;
use homework;

-- 部门管理
drop table if exists department;
create table department
(
    id        int unsigned primary key auto_increment comment '主键ID',
    name      varchar(10) not null unique comment '部门名称',
    create_at datetime    not null comment '创建时间',
    update_at datetime    not null comment '修改时间'
) comment '部门表';

insert into department (id, name, create_at, update_at)
values (1, '学工部', now(), now()),
       (2, '教研部', now(), now()),
       (3, '咨询部', now(), now()),
       (4, '就业部', now(), now()),
       (5, '人事部', now(), now());


-- 员工管理(带约束)
drop table if exists staff;
create table staff
(
    id         int unsigned primary key auto_increment comment 'ID',
    username   varchar(20)      not null unique comment '用户名',
    password   varchar(32) default '123456' comment '密码',
    name       varchar(10)      not null comment '姓名',
    gender     tinyint unsigned not null comment '性别, 说明: 1 男, 2 女',
    image      varchar(300) comment '图像',
    job        tinyint unsigned comment '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
    entry_date date comment '入职时间',
    dept_id    int unsigned comment '部门ID',
    create_at  datetime         not null comment '创建时间',
    update_at  datetime         not null comment '修改时间'
) comment '员工表';

insert into staff
(id, username, password, name, gender, image, job, entry_date, dept_id, create_at, update_at)
values (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, now(), now()),
       (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, now(), now()),
       (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, now(), now()),
       (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, now(), now()),
       (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', 2, now(), now()),
       (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, now(), now()),
       (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, now(), now()),
       (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, now(), now()),
       (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, now(), now()),
       (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, now(), now()),
       (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 5, '2007-02-01', 3, now(), now()),
       (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, now(), now()),
       (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, now(), now()),
       (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', 2, now(), now()),
       (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', 2, now(), now()),
       (16, 'songyuanqiao', '123456', '宋远桥', 1, '16.jpg', 2, '2007-01-01', 2, now(), now()),
       (17, 'chenyouliang', '123456', '陈友谅', 1, '17.jpg', NULL, '2015-03-21', NULL, now(), now());

-- 班级管理
drop table if exists class;
create table class
(
    id              int unsigned primary key auto_increment comment 'ID',
    name            varchar(20)  not null unique comment '班级名称',
    classroom       varchar(20)  not null comment '班级教室',
    start_date      date         not null comment '开课时间',
    end_date        date         not null comment '结课时间',
    head_teacher_id int unsigned not null comment '班主任ID',
    create_at       datetime     not null comment '创建时间',
    update_at       datetime     not null comment '修改时间'
) comment '班级表';

insert into class
(id, name, classroom, start_date, end_date, head_teacher_id, create_at, update_at)
values (1, '2024第01期01班', 'G102', '2024-03-01', '2024-04-15', 10, now(), now()),
       (2, '2024第01期02班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (3, '2024第01期03班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (4, '2024第01期04班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (5, '2024第01期05班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (6, '2024第01期06班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (7, '2024第01期07班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (8, '2024第01期08班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (9, '2024第01期09班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now()),
       (10, '2024第01期10班', 'G102', '2024-03-01', '2024-04-15', 8, now(), now());

-- 学员管理
drop table if exists student;
create table student
(
    id          int unsigned primary key auto_increment comment 'ID',
    name        varchar(20)      not null comment '姓名',
    stu_number  varchar(20) unique comment '学号',
    class_id    int unsigned     not null comment '班级ID',
    gender      tinyint unsigned not null comment '性别',
    phone       varchar(20)      not null comment '手机号',
    degree      tinyint unsigned not null comment '最高学历, 说明: 1.本科, 2.大专',
    break_count int unsigned     not null comment '违纪次数',
    minus       int unsigned     not null comment '违纪扣分',
    create_at   datetime         not null comment '创建时间',
    update_at   datetime         not null comment '修改时间'
);

insert into student
(id, name, stu_number, class_id, gender, phone, degree, break_count, minus, create_at, update_at)
values (1, '张三', 'A220505001', 1, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (2, '李四', 'A220505002', 2, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (3, '周云梦', 'A220505003', 3, 2, '1880909xxxx', 1, 1, 5, now(), now()),
       (4, '王五', 'A220505004', 4, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (5, '赵六', 'A220505005', 5, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (6, '七大姑', 'A220505006', 6, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (7, '八大姨', 'A220505007', 7, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (8, '小九', 'A220505008', 8, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (9, 'XXX', 'A220505009', 9, 1, '1880909xxxx', 1, 1, 5, now(), now()),
       (10, 'XXX', 'A220505010', 10, 1, '1880909xxxx', 1, 1, 5, now(), now());
