package com.stark.homework.mapper;

import com.stark.homework.entity.Class;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper {
    /**
     * 通过 id 查询课程信息
     *
     * @param id 课程 id
     * @return 课程信息
     */
    Class selectById(int id);
}
