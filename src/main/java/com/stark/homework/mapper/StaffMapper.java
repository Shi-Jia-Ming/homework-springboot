package com.stark.homework.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stark.homework.entity.Staff;

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