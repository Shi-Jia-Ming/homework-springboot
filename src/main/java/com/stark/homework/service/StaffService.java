package com.stark.homework.service;

import com.stark.homework.entity.Staff;

import java.util.List;

public interface StaffService {

    /**
     * 获取所有员工信息
     *
     * @return 员工信息列表
     */
    List<Staff> getAll();

    /**
     * 获取所有班主任信息
     *
     * @return 班主任信息列表
     */
    List<Staff> getHeadTeacher();

    /**
     * 获取男性职员数量
     *
     * @return 男性职员数量
     */
    int searchMaleCount();

    /**
     * 获取女性职员数量
     *
     * @return 女性职员数量
     */
    int searchFemaleCount();

    /**
     * 获取职位的人数
     *
     * @param job 职位
     * @return 该职位的人数
     */
    int searchJobCount(int job);

    /**
     * 根据部分员工信息模糊查询
     *
     * @param staff 部分员工信息
     * @return 模糊查询的结果
     */
    List<Staff> search(Staff staff);

    /**
     * 判断该用户名是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    boolean isExist(String username);

    /**
     * 判断该用户是否存在
     *
     * @param id 用户 id
     * @return 是否存在
     */
    boolean isExist(int id);

    /**
     * 创建员工信息
     *
     * @param staff 员工信息
     * @return 新建的员工信息 id
     */
    int create(Staff staff);

    /**
     * 更新员工信息
     *
     * @param staff 新的员工信息
     */
    void update(Staff staff);

    /**
     * 删除员工信息
     *
     * @param staff 待删除的员工信息
     */
    void delete(Staff staff);
}
