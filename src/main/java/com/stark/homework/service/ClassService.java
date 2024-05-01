package com.stark.homework.service;

import com.stark.homework.entity.Class;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClassService {

    /**
     * 获取所有班级信息
     *
     * @return 班级信息列表
     */
    List<Class> getAll();

    /**
     * 根据部分班级信息进行模糊查询
     *
     * @param class_   部分班级信息
     * @return 符合条件的班级信息列表
     */
    List<Class> search(Class class_);
}
