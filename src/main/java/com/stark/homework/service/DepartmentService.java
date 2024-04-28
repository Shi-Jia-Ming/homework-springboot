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
}
