package com.stark.homework.service.impl;

import com.stark.homework.entity.Department;
import com.stark.homework.mapper.DepartmentMapper;
import com.stark.homework.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public List<Department> getAll() {
        return departmentMapper.selectAll();
    }
}
