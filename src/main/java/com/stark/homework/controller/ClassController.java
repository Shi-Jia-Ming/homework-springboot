package com.stark.homework.controller;

import com.stark.homework.entity.Class;
import com.stark.homework.service.ClassService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据部分班级信息进行模糊查询
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param class_   部分班级信息
     * @return 符合条件的班级信息列表
     */
    @Operation(summary = "根据部分班级信息进行模糊查询")
    @PostMapping("search")
    public ResponseEntity<Object> search(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Class class_
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("模糊查询班级信息").error("Jwt 验证失败");
        }
        List<Class> classList = classService.search(class_);
        return new Response("模糊查询班级信息").ok(classList, "成功");
    }

    /**
     * 新建班级信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param class_   新的班级信息
     * @return 新建班级的 id
     */
    @Operation(summary = "新建班级信息")
    @PostMapping("create")
    public ResponseEntity<Object> create(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Class class_
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("新建班级信息").error("Jwt 验证失败");
        }
        // 判断班级名称是否已存在
        if (classService.isExist(class_.getName())) {
            return new Response("新建班级信息").error("该班级已存在");
        }
        int classId = classService.insert(class_);
        return new Response("新建班级信息").ok(classId, "成功");
    }

    /**
     * 删除班级信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param class_   待删除的班级信息
     * @return 删除状态
     */
    @Operation(summary = "删除班级信息")
    @PostMapping("delete")
    public ResponseEntity<Object> delete(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Class class_
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("删除班级信息").error("Jwt 验证失败");
        }
        // 判断待删除的班级是否存在
        if (!classService.isExist(class_.getId())) {
            return new Response("删除班级信息").error("待删除的班级不存在");
        }
        classService.delete(class_);
        return new Response("删除班级信息").ok("成功");
    }

    /**
     * 更新班级信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param class_   新的班级信息
     * @return 更新状态
     */
    @Operation(summary = "更新班级信息")
    @PostMapping("update")
    public ResponseEntity<Object> update(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Class class_
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("更新班级信息").error("Jwt 验证失败");
        }
        // 判断待删除的班级是否存在
        if (!classService.isExist(class_.getId())) {
            return new Response("更新班级信息").error("待更新的班级不存在");
        }
        classService.update(class_);
        return new Response("更新班级信息").ok("成功");
    }
}
