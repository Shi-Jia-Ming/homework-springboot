package com.stark.homework.controller;

import com.stark.homework.entity.Staff;
import com.stark.homework.service.StaffService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    /**
     * 获取所有员工信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @return 员工信息列表
     */
    @GetMapping("getAll")
    public ResponseEntity<Object> getAll(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取员工数据").error("Jwt 验证失败");
        }
        List<Staff> staff = staffService.getAll();
        return new Response("获取员工数据").ok(staff, "成功");
    }
}
