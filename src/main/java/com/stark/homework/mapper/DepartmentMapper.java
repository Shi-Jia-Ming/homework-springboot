package com.stark.homework.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.stark.homework.entity.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    /**
     * 通过部门 id 查询部门信息
     *
     * @param id 部门 id
     * @return 部门信息
     */
    Department selectById(int id);

    /**
     * 通过部门名称查询部门信息
     *
     * @param name 部门名称
     * @return 部门信息
     */
    Department selectByName(String name);

    /**
     * 获取所有部门信息
     *
     * @return 部门信息列表
     */
    List<Department> selectAll();

    /**
     * 删除部门数据
     *
     * @param department 待删除的部门
     */
    void delete(Department department);

    /**
     * 新增部门数据
     *
     * @param department 待新增的部门数据
     */
    void insert(Department department);

    /**
     * 更新部门数据
     *
     * @param department 待更新的部门数据
     */
    void update(Department department);

}
