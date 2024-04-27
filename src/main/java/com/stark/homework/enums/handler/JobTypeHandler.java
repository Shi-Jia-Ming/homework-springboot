package com.stark.homework.enums.handler;

import com.stark.homework.enums.Job;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.TINYINT)
@MappedTypes(Job.class)
public class JobTypeHandler extends BaseTypeHandler<Job> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Job job, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, job.getValue());
        System.out.println(job.getValue());
    }

    @Override
    public Job getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int value = rs.getInt(columnName);
        System.out.println(value);
        return value == 0 ? null : Job.fromValue(value);
    }

    @Override
    public Job getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int value = rs.getInt(columnIndex);
        System.out.println(value);
        return value == 0 ? null : Job.fromValue(value);
    }

    @Override
    public Job getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int value = cs.getInt(columnIndex);
        System.out.println(value);
        return value == 0 ? null : Job.fromValue(value);
    }
}
