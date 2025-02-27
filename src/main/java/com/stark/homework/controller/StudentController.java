package com.stark.homework.controller;

import com.stark.homework.entity.Student;
import com.stark.homework.service.StudentService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "学生控制类")
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * 获取所有学生信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @return 学生信息列表
     */
    @Operation(summary = "获取全部学生信息")
    @GetMapping("getAll")
    public ResponseEntity<Object> getAll(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取学生信息").error("Jwt 验证失败");
        }
        List<Student> students = studentService.getAll();
        return new Response("获取学生信息").ok(students, "成功");
    }

    @Operation(summary = "根据部分学生信息模糊查询")
    @PostMapping("search")
    public ResponseEntity<Object> search(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Student student
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("模糊查询学生信息").error("Jwt 验证失败");
        }
        List<Student> students = studentService.search(student);
        return new Response("模糊查询学生信息").ok(students, "成功");
    }

    /**
     * 新建学生信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param student  新的学生信息
     * @return 新数据的 id
     */
    @Operation(summary = "新建学生信息")
    @PostMapping("create")
    public ResponseEntity<Object> create(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Student student
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("新建学生信息").error("Jwt 验证失败");
        }
        // 判断学号是否已经存在
        if (studentService.isExist(student.getStuNumber())) {
            return new Response("新建学生信息").error("学号已存在");
        }
        int studentId = studentService.insert(student);
        return new Response("新建学生信息").ok(studentId, "成功");
    }

    /**
     * 更改学生信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param student  新的学生信息
     * @return 更新的状态
     */
    @Operation(summary = "更改学生信息")
    @PostMapping("update")
    public ResponseEntity<Object> update(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Student student
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("更改学生信息").error("Jwt 验证失败");
        }
        // TODO 更新数据中的相同值验证
        // 判断学号是否已经存在
        if (studentService.isExist(student.getId(), student.getStuNumber())) {
            return new Response("更改学生信息").error("学号已存在");
        }
        studentService.update(student);
        return new Response("更改学生信息").ok("成功");
    }

    /**
     * 删除学生信息
     *
     * @param token       用户 token
     * @param id          用户 id
     * @param username    用户名
     * @param studentList 待删除的学生信息
     * @return 删除状态
     */
    @Operation(summary = "删除学生信息")
    @PostMapping("delete")
    public ResponseEntity<Object> delete(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody List<Student> studentList
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("删除学生信息").error("Jwt 验证失败");
        }
        studentList.forEach((studentService::delete));
        return new Response("删除学生信息").ok("成功");
    }
}
