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
     * 根据部分学生信息模糊查询
     *
     * @param student 部分学生信息
     * @return 符合条件的信息列表
     */
    List<Student> search(Student student);

    /**
     * 判断学生信息是否存在
     *
     * @param stuNumber 学号
     * @return 是否存在
     */
    boolean isExist(String stuNumber);

    /**
     * 判断学生信息是否存在
     *
     * @param id 学生 id
     * @return 是否存在
     */
    boolean isExist(int id);

    /**
     * 判断该学号是否被其他学员使用
     * @param id 学员 id
     * @param stuNumber 学号
     * @return 是否重复
     */
    boolean isExist(int id, String stuNumber);

    /**
     * 插入新的学生数据
     *
     * @param student 新的学生数据
     * @return 新数据的 id
     */
    int insert(Student student);

    /**
     * 更新学生数据
     *
     * @param student 新的学生数据
     */
    void update(Student student);

    /**
     * 删除学生数据
     *
     * @param student 待删除的学生数据
     */
    void delete(Student student);
}
