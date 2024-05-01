package com.stark.homework.controller;

import com.stark.homework.entity.Class;
import com.stark.homework.service.ClassService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "班级控制类")
@RestController
@RequestMapping("/class")
public class ClassController {

    private final ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    /**
     * 获取全部班级西南西
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @return 班级信息列表a
     */
    @Operation(summary = "获取全部班级信息")
    @GetMapping("getAll")
    public ResponseEntity<Object> getAll(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取班级信息").error("Jwt 验证失败");
        }
        List<Class> classes = classService.getAll();
        return new Response("获取班级信息").ok(classes, "成功");
    }
}
