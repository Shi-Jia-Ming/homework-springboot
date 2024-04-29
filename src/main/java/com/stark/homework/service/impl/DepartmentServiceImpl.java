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
    public boolean isExist(int departmentId) {
        Department department = departmentMapper.selectById(departmentId);
        return !(department == null);
    }

    @Override
    public int create(Department department) {
        // 插入部门信息
        departmentMapper.insert(department);
        return department.getId();
    }

    @Override
    public void update(Department department) {
        departmentMapper.update(department);
    }

    @Override
    public void delete(Department department) {
        departmentMapper.delete(department);
    }
}
