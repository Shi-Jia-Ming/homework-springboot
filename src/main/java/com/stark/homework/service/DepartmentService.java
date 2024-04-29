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
     * 查询部门是否存在
     *
     * @param departmentName 部门名称
     * @return 部门是否存在
     */
    boolean isExist(String departmentName);

    /**
     * 新建部门信息
     *
     * @param departmentName 部门名称
     * @return 新建部门的 id
     */
    int create(String departmentName);
}
