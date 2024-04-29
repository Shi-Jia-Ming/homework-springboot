package com.stark.homework.service;

import com.stark.homework.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    /**
     * 获取所有部门信息
     *
     * @return 部门信息列表
     */
    List<Department> getAll();

    /**
     * 根据部门名称查询部门是否存在
     *
     * @param departmentName 部门名称
     * @return 部门是否存在
     */
    boolean isExist(String departmentName);

    /**
     * 根据部门 id 查询部门是否存在
     *
     * @param departmentId 部门 id
     * @return 部门是否存在
     */
    boolean isExist(int departmentId);

    /**
     * 新建部门信息
     *
     * @param department 部门信息
     * @return 新建部门的 id
     */
    int create(Department department);

    /**
     * 更新部门信息
     *
     * @param department 新的部门信息
     */
    void update(Department department);
}
