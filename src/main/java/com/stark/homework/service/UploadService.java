package com.stark.homework.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface UploadService {

    /**
     * 上传文件
     *
     * @param file       文件对象
     * @param uploadPath 上传路径
     * @return 上传的文件名
     */
    String uploadFile(MultipartFile file, String uploadPath);

    /**
     * 判断文件是否存在
     *
     * @param fileName   文件名
     * @param uploadPath 文件路径
     * @return 文件是否存在
     */
    boolean isExist(String fileName, String uploadPath);

    /**
     * 删除文件
     *
     * @param fileName   待删除的文件名
     * @param uploadPath 待删除的文件的路径
     * @return 删除状态
     */
    boolean deleteFile(String fileName, String uploadPath);
}
