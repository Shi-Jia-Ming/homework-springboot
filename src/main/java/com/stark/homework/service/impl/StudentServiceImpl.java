package com.stark.homework.service.impl;

import com.stark.homework.entity.Student;
import com.stark.homework.mapper.StudentMapper;
import com.stark.homework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }
}