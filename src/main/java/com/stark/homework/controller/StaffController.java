package com.stark.homework.controller;

import com.stark.homework.entity.Staff;
import com.stark.homework.service.StaffService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
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

    /**
     * 根据部分员工信息模糊查询
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param staff    部分员工信息
     * @return 符合条件的查询结果
     */
    @Operation(summary = "对员工信息进行模糊查询")
    @PostMapping("search")
    public ResponseEntity<Object> search(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Staff staff
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("员工信息模糊查询").error("Jwt 验证失败");
        }
        List<Staff> staffList = staffService.search(staff);
        return new Response("员工信息模糊查询").ok(staffList, "成功");
    }

    /**
     * 新增员工信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param staff    员工信息
     * @return 新增员工的 id
     */
    @Operation(summary = "新增员工信息")
    @PostMapping("create")
    public ResponseEntity<Object> create(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Staff staff
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("新建员工信息").error("Jwt 验证失败");
        }
        // 判断该用户名是否已存在
        if (staffService.isExist(staff.getUsername())) {
            return new Response("新建员工信息").error("该用户名已被使用");
        }
        int staffId = staffService.create(staff);
        return new Response("新建员工信息").ok(staffId, "成功");
    }
}
