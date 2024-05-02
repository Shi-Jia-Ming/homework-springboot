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

    @Override
    public List<Class> search(Class class_) {
        return classMapper.selectWithLike(class_);
    }

    @Override
    public boolean isExist(String name) {
        Class class_ = classMapper.selectByName(name);
        return !(class_ == null);
    }

    @Override
    public boolean isExist(int id) {
        Class class_ = classMapper.selectById(id);
        return !(class_ == null);
    }

    @Override
    public int insert(Class class_) {
        classMapper.insert(class_);
        return class_.getId();
    }

    @Override
    public void delete(Class class_) {
        classMapper.delete(class_);
    }

    @Override
    public void update(Class class_) {
        classMapper.update(class_);
    }
}
