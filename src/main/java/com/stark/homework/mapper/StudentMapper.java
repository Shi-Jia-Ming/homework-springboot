package com.stark.homework.mapper;

import com.stark.homework.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    /**
     * 通过学生 id 查询学生信息
     *
     * @param id 学生 id
     * @return 学生信息
     */
    Student selectById(int id);

    /**
     * 查询所有学生信息
     *
     * @return 学生信息列表
     */
    List<Student> selectAll();
}
