package com.stark.homework.service.impl;

import com.stark.homework.entity.Department;
import com.stark.homework.mapper.DepartmentMapper;
import com.stark.homework.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @Override
    public List<Department> getAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public boolean isExist(String departmentName) {
        Department department = departmentMapper.selectByName(departmentName);
        return !(department == null);
    }

    @Override
    public int create(String departmentName) {
        // 新建 Department 对象
        Department department = new Department();
        department.setName(departmentName);
        department.setCreateAt(new Date());
        department.setUpdateAt(new Date());
        // 插入部门信息
        departmentMapper.insert(department);
        return department.getId();
    }
}
