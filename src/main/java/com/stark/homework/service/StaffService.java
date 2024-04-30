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
     * 根据部分员工信息模糊查询
     *
     * @param staff 部分员工信息
     * @return 模糊查询的结果
     */
    List<Staff> search(Staff staff);
}
