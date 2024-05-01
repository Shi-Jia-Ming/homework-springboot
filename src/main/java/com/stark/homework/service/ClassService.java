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
}
