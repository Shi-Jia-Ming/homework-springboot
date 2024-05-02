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

    /**
     * 判断学生信息是否存在
     *
     * @param stuNumber 学号
     * @return 返回学生信息
     */
    boolean isExist(String stuNumber);

    /**
     * 插入新的学生数据
     *
     * @param student 新的学生数据
     * @return 新数据的 id
     */
    int insert(Student student);
}
