package com.stark.homework.controller;

import com.stark.homework.service.UserService;
import com.stark.homework.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户登录接口
     * @param username 用户名
     * @param password 密码
     * @return 返回登录状态
     */
    @PostMapping("login")
    public ResponseEntity<Object> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        Map<String, Object> result = this.userService.login(username, password);
        // 定义返回体
        Map<String, Object> response = new HashMap<>();
        if (result.get("code").equals(1)) {
            return new Response("用户登录").error((String) result.get("msg"));
        }
        response.put("id", result.get("id"));
        response.put("token", result.get("token"));
        return new Response("用户登录").ok(response, "成功");
    }
}
