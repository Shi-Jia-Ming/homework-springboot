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
     * @param class_ 部分班级信息
     * @return 符合条件的班级信息列表
     */
    List<Class> search(Class class_);

    /**
     * 根据班级名称判断班级是否存在
     *
     * @param name 班级名称
     * @return 是否存在
     */
    boolean isExist(String name);

    /**
     * 根据班级 id 判断班级是否存在
     *
     * @param id 班级 id
     * @return 是否存在
     */
    boolean isExist(int id);

    /**
     * 新建班级数据
     *
     * @param class_ 新的班级数据
     * @return 新的班级的 id
     */
    int insert(Class class_);

    /**
     * 删除班级数据
     *
     * @param class_ 待删除的班级数据
     */
    void delete(Class class_);

    /**
     * 更新班级数据
     *
     * @param class_ 新的班级数据
     */
    void update(Class class_);
}
