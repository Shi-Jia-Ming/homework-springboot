package com.stark.homework.controller;

import com.stark.homework.entity.Department;
import com.stark.homework.service.DepartmentService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("getAll")
    public ResponseEntity<Object> getAll(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestParam("username") String username
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取部门数据").error("Jwt 验证失败");
        }
        List<Department> departments = departmentService.getAll();
        return new Response("获取部门数据").ok(departments, "成功");
    }
}
