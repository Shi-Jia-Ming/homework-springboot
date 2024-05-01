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
     * 根据部分班级信息模糊查询
     *
     * @param class_ 部分班级信息
     * @return 符合条件的班级列表
     */
    List<Class> selectWithLike(Class class_);
}
