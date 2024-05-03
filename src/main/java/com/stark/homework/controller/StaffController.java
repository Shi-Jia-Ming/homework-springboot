package com.stark.homework.controller;

import com.stark.homework.entity.Staff;
import com.stark.homework.service.StaffService;
import com.stark.homework.utils.JwtAuthentication;
import com.stark.homework.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 获取班主任信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @return 班主任信息列表
     */
    @Operation(summary = "获取班主任信息")
    @GetMapping("getHeadTeacher")
    public ResponseEntity<Object> getHeadTeacherList(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取班主任信息").error("Jwt 验证失败");
        }
        List<Staff> headTeacher = staffService.getHeadTeacher();
        return new Response("获取班主任信息").ok(headTeacher, "成功");
    }

    /**
     * 获取职员性别的数量
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @return 职员性别的数量
     */
    @Operation(summary = "获取职员性别的数量")
    @GetMapping("getGenderCount")
    public ResponseEntity<Object> getGenderCount(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取职员性别的数量").error("Jwt 验证失败");
        }
        Map<String, Object> result = new HashMap<>();
        result.put("male", staffService.searchMaleCount());
        result.put("female", staffService.searchFemaleCount());
        return new Response("获取职员性别的数量").ok(result, "成功");
    }

    /**
     * 获取职员职位的数量
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param job      职位种类
     * @return 该职位的人数
     */
    @Operation(summary = "获取职员职位的数量")
    @PostMapping("getJobCount")
    public ResponseEntity<Object> getJobCount(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestParam("job") int job
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("获取职员职位的数量").error("Jwt 验证失败");
        }
        int count = staffService.searchJobCount(job);
        return new Response("获取职员职位的数量").ok(count, "成功");
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

    /**
     * 更改员工信息
     *
     * @param token    用户 token
     * @param id       用户 id
     * @param username 用户名
     * @param staff    新的员工信息
     * @return 返回更新状态
     */
    @Operation(summary = "更改员工信息")
    @PostMapping("edit")
    public ResponseEntity<Object> edit(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody Staff staff
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("更改员工信息").error("Jwt 验证失败");
        }
        if (!(staffService.isExist(staff.getId()))) {
            return new Response("更改员工信息").error("员工不存在");
        }
        staffService.update(staff);
        return new Response("更改员工信息").ok("成功");
    }

    /**
     * 删除员工列表信息
     *
     * @param token     用户 token
     * @param id        用户 id
     * @param username  用户名
     * @param staffList 待删除的员工列表
     * @return 删除状态
     */
    @Operation(summary = "删除员工列表信息")
    @PostMapping("delete")
    public ResponseEntity<Object> delete(
            @RequestHeader("Token") String token,
            @RequestHeader("User-Id") int id,
            @RequestHeader("Username") String username,
            @RequestBody List<Staff> staffList
    ) {
        // 进行 Jwt 验证
        if (!JwtAuthentication.authentication(token, id, username)) {
            return new Response("删除员工信息").error("Jwt 验证失败");
        }
        staffList.forEach((staffService::delete));
        return new Response("删除员工信息").ok("成功");
    }
}
