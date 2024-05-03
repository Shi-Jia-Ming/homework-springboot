package com.stark.homework.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stark.homework.entity.Staff;

import java.util.List;

@Mapper
public interface StaffMapper {

    /**
     * 根据 id 查询员工数据
     *
     * @param id 员工 id
     * @return 员工数据
     */
    Staff selectById(int id);

    /**
     * 根据用户名查询员工数据
     *
     * @param username 用户名
     * @return 员工数据
     */
    Staff selectByUsername(String username);

    /**
     * 模糊查询员工信息
     *
     * @param staff 员工部分信息
     * @return 符合的员工信息列表
     */
    List<Staff> selectWithLike(Staff staff);

    /**
     * 获取所有员工信息
     *
     * @return 员工信息列表
     */
    List<Staff> selectAll();

    /**
     * 获取所有班主任信息
     *
     * @return 班主任信息列表
     */
    List<Staff> selectHeadTeacher();

    /**
     * 查询男性职员的数量
     *
     * @return 男性职员的数量
     */
    int searchMaleCount();

    /**
     * 查询女性职员的数量
     *
     * @return 女性职员的数量
     */
    int searchFemaleCount();

    /**
     * 查询某个职位的人数
     *
     * @param job 职位
     * @return 该职位的人数
     */
    int searchJobCount(int job);

    /**
     * 删除员工数据
     *
     * @param staff 待删除的员工数据
     */
    void delete(Staff staff);

    /**
     * 添加员工数据
     *
     * @param staff 待添加员工的数据
     */
    void insert(Staff staff);

    /**
     * 更新员工数据
     *
     * @param staff 待更新的员工数据
     */
    void update(Staff staff);
}