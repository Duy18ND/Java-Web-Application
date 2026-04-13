package com.re.btvn.SESSION07_05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/merchant/combo")
public class ComboController {

    private static List<Combo> comboList = new ArrayList<>();

    // Mở Form thêm Combo
    @GetMapping("/add")
    public String showComboForm() {
        return "combo-add";
    }

    // Xử lý nộp Form
    @PostMapping("/add")
    public String processAddCombo(
            @RequestParam("name") String name,
            // Thêm required = false để không báo lỗi 400 nếu khách không tick ô nào
            @RequestParam(value = "itemList", required = false) List<String> itemList,
            @RequestParam("banner") MultipartFile file,
            Model model) {

        // --- BẪY DỮ LIỆU: Kiểm tra số lượng món ---
        if (itemList == null || itemList.size() < 2) {
            model.addAttribute("error", "Thất bại: Một siêu Combo phải chứa ít nhất 2 món ăn!");
            return "combo-add";
        }

        // --- LƯU BANNER LÊN MÁY CHỦ ---
        String finalFileName = "default.png";
        if (!file.isEmpty()) {
            try {
                String uploadPath = "D:/BAITAP/Java Web Application/SESSION07/BTVN/src/main/webapp/file/";
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdirs();

                finalFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                file.transferTo(new File(uploadDir, finalFileName));
            } catch (IOException e) {
                model.addAttribute("error", "Lỗi lưu file vào ổ cứng!");
                return "combo-add";
            }
        }

        // --- LƯU COMBO & IN JSON RA CONSOLE ---
        Combo newCombo = new Combo(name, itemList, finalFileName);
        comboList.add(newCombo);

        System.out.println("\n=== ĐÃ LƯU SIÊU COMBO MỚI ===");
        System.out.println(newCombo.toString()); // Gọi hàm tạo JSON ở Model
        System.out.println("=============================\n");

        model.addAttribute("message", "Tạo Combo thành công!");
        return "combo-add";
    }
}