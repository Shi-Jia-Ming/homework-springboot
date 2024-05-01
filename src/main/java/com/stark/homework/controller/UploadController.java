package com.stark.homework.controller;

import com.stark.homework.service.UploadService;
import com.stark.homework.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

@Slf4j
@Tag(name = "文件上传控制器")
@RestController
@RequestMapping("/upload")
public class UploadController {

    private final UploadService uploadService;

    private final String imageUploadPath;

    @Autowired
    public UploadController(UploadService uploadService, Environment environment) {
        this.uploadService = uploadService;
        this.imageUploadPath = Objects.requireNonNull(environment.getProperty("resources.image")).split(":", 2)[1];
        log.info("[Info]  " + "图像上传文件夹 " + this.imageUploadPath);
        if (this.imageUploadPath != null) {
            File file = new File(this.imageUploadPath);
            if (!file.exists() && !file.mkdirs()) {
                log.info("[Error] " + "创建目录失败！");
            }
        }
    }

    /**
     * 上传用户头像
     *
     * @param file 头像文件
     * @return 服务器保存的文件名
     */
    @Operation(summary = "上传图片")
    @PostMapping("image")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file) {
        String fileName = uploadService.uploadFile(file, imageUploadPath);
        if (fileName == null) {
            return new Response("上传图像").error("文件保存失败");
        }
        return new Response("上传图像").ok(fileName, "成功");
    }

    /**
     * 删除数字人头像文件
     *
     * @param fileName 待删除的文件名
     * @return 删除状态
     */
    @Operation(summary = "删除文件")
    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam("fileName") String fileName) {
        if (!uploadService.isExist(fileName, imageUploadPath)) {
            return new Response("删除文件").error("文件不存在");
        } else if (uploadService.deleteFile(fileName, imageUploadPath)) {
            return new Response("删除文件").ok("成功");
        } else {
            return new Response("删除文件").error("未知错误");
        }
    }
}
