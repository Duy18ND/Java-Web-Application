package com.re.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    // Đường dẫn thư mục lưu file (KHÔNG dùng WEB-INF)
    private final String UPLOAD_DIR = "D:/BAITAP/Java Web Application/SESSION07/DEMO/src/main/webapp/image/";

    @GetMapping
    public String formUpload() {
        return "form-upload";
    }

    @PostMapping
    public String handleUpload(@RequestParam("file") MultipartFile file, Model model) {

        if (file.isEmpty()) {
            model.addAttribute("error", "Không có file gửi lên!");
            return "result";
        }

        try {
            String fileName = file.getOriginalFilename();

            if (fileName == null || fileName.isEmpty()) {
                model.addAttribute("error", "Tên file không hợp lệ");
                return "result";
            }

            // Tạo thư mục nếu chưa có
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File destFile = new File(UPLOAD_DIR + fileName);

            file.transferTo(destFile);

            model.addAttribute("message", "Upload thành công");
            model.addAttribute("fileName", fileName);

        } catch (IOException e) {
            e.printStackTrace(); // debug
            model.addAttribute("error", "Lỗi khi upload file");
        }

        return "result";
    }
}