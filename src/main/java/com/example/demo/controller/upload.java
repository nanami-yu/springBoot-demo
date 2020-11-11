package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

@ResponseBody
@Controller
public class upload {

    @Autowired
    FileService fileService;

    /**
     * 上传图片
     * @return
     */
    @PostMapping("/api/upload")
    @Transactional
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String fileId = fileService.save(file.getInputStream());
        return fileId;
    }

    /**
     * 上传视频
     * @return
     */
    @PostMapping("/api/upload1")
    @Transactional
    public ResponseEntity<byte[]>  upload1(@RequestParam("file") MultipartFile file) throws IOException {
        String fileId = fileService.save(file.getInputStream());
        byte [] body = null;
        InputStream in = file.getInputStream();
        body = new byte[in.available()];
        in.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename="
                + "测试视频.mp4");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> response =
                new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }


    /**
     * 下载
     * @return
     */
    @PostMapping("/api/download")
    @Transactional
    public ResponseEntity<byte[]>  download(@RequestParam("id") String id, HttpSession session,
                          HttpServletRequest request, HttpServletResponse responsek) throws IOException {
        byte [] body = null;
        InputStream in = fileService.getByFileId(id);
        body = new byte[in.available()];
        in.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename="
                + "测试图片.jpg");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> response =
                new ResponseEntity<byte[]>(body, headers, statusCode);
        return response;
    }


}
