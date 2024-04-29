package com.stark.homework.service.impl;

import com.stark.homework.entity.Staff;
import com.stark.homework.mapper.StaffMapper;
import com.stark.homework.service.UserService;
import com.stark.homework.utils.JwtAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    private final StaffMapper staffMapper;

    @Autowired
    public UserServiceImpl(StaffMapper staffMapper) {
        this.staffMapper = staffMapper;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        // 在数据库中查询用户信息
        Map<String, Object> result = new HashMap<>();
        Staff staff = staffMapper.selectByUsername(username);
        if (staff == null) {
            result.put("code", 1);
            result.put("msg", "未查询到该用户");
        } else if (!Objects.equals(staff.getPassword(), password)) {
            result.put("code", 1);
            result.put("msg", "用户密码错误");
        } else {
            // 验证成功
            result.put("code", 0);
            result.put("id", staff.getId());
            // 为用户生成 token
            String jwtToken = JwtAuthentication.generateJwtToken(staff.getId(), username);
            result.put("token", jwtToken);
        }
        return result;
    }
}
