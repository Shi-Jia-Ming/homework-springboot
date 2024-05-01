package com.stark.homework.service.impl;

import com.stark.homework.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public String uploadFile(MultipartFile file, String uploadPath) {
        try {
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            String filePath = uploadPath + File.separator + fileName;
            // 将文件保存到服务器
            file.transferTo(new File(filePath));
            // 返回文件名
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isExist(String fileName, String uploadPath) {
        File file = new File(uploadPath + fileName);
        return file.exists();
    }

    @Override
    public boolean deleteFile(String fileName, String uploadPath) {
        File fileToDelete = new File(uploadPath + fileName);
        return fileToDelete.delete();
    }
}
