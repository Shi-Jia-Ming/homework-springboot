package com.stark.homework.service.impl;

import com.stark.homework.entity.Class;
import com.stark.homework.mapper.ClassMapper;
import com.stark.homework.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassMapper classMapper;

    @Autowired
    public ClassServiceImpl(ClassMapper classMapper) {
        this.classMapper = classMapper;
    }

    @Override
    public List<Class> getAll() {
        return classMapper.selectAll();
    }
}
