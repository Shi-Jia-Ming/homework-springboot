package com.stark.homework.mapper;

import com.stark.homework.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {
    /**
     * 通过 id 查询班级信息
     *
     * @param id 班级 id
     * @return 班级信息
     */
    Class selectById(int id);

    /**
     * 获取全部班级信息
     *
     * @return 班级信息列表
     */
    List<Class> selectAll();

    /**
     * 通过名称查询班级信息
     *
     * @param name 班级名称
     * @return 班级信息
     */
    Class selectByName(String name);

    /**
     * 根据部分班级信息模糊查询
     *
     * @param class_ 部分班级信息
     * @return 符合条件的班级列表
     */
    List<Class> selectWithLike(Class class_);

    /**
     * 插入班级信息
     *
     * @param class_ 新的班级信息
     */
    void insert(Class class_);

    /**
     * 删除班级信息
     *
     * @param class_ 待删除的班级信息
     */
    void delete(Class class_);

    /**
     * 更新班级信息
     *
     * @param class_ 新的班级信息
     */
    void update(Class class_);
}
