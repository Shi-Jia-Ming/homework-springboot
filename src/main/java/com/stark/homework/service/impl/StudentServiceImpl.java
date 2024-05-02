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

    @Override
    public boolean isExist(String stuNumber) {
        Student student = studentMapper.selectByStuNumber(stuNumber);
        return !(student == null);
    }

    @Override
    public boolean isExist(int id) {
        Student student = studentMapper.selectById(id);
        return !(student == null);
    }

    @Override
    public int insert(Student student) {
        studentMapper.insert(student);
        return student.getId();
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(Student student) {
        studentMapper.delete(student);
    }
}
