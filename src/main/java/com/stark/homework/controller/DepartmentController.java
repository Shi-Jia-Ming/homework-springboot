package com.stark.homework.controller;

import com.stark.homework.entity.Department;
import com.stark.homework.service.DepartmentService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "部门控制类")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * 获取所有部门信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @return 部门信息列表
     */
    @Operation(summary = "获取所有部门信息")
    @PostMapping("getAll")
    public ResponseEntity<Object> getAll(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestParam("username") String username
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取部门信息").error("Jwt 验证失败");
        }
        List<Department> departments = departmentService.getAll();
        return new Response("获取部门信息").ok(departments, "成功");
    }

    /**
     * 新建部门信息
     *
     * @param token          用户 token
     * @param id             用户 id
     * @param username       用户名
     * @param departmentName 部门名称
     * @return 新建部门的 id
     */
    @Operation(summary = "新建部门信息")
    @PostMapping("create")
    public ResponseEntity<Object> create(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestParam("username") String username,
            @RequestParam("departmentName") String departmentName
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("新建部门信息").error("Jwt 验证失败");
        }
        // 判断该部门是否已经存在
        if (departmentService.isExist(departmentName)) {
            return new Response("新建部门信息").error("该部门已存在");
        }
        int departmentId = departmentService.create(departmentName);
        return new Response("新建部门信息").ok(departmentId, "成功");
    }
}
