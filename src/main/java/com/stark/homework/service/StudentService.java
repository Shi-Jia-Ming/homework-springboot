package com.stark.homework.service;

import com.stark.homework.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    /**
     * 获取所有学生信息
     *
     * @return 学生信息列表
     */
    List<Student> getAll();
}
