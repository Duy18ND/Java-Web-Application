package com.re.btvn.SESSION07_03_04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/food")
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();

    // 1. Mở Form
    @GetMapping({"", "/add"})
    public String showForm() {
        return "food-add";
    }

    // 2. Xử lý lưu File và Dữ liệu
    @PostMapping("/add")
    public String processAddFood(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("image") MultipartFile file,
            Model model, RedirectAttributes redirectAttributes) {

        // ... (Giữ nguyên các bước kiểm tra bẫy dữ liệu ở code trước) ...

        try {
            String uploadPath = "D:/BAITAP/Java Web Application/SESSION07/BTVN/src/main/webapp/file/";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // SỬ DỤNG UUID ĐỂ SINH TÊN FILE DUY NHẤT
            String uniqueCode = UUID.randomUUID().toString();
            String finalFileName = uniqueCode + "_" + file.getOriginalFilename();

            File destFile = new File(uploadDir, finalFileName);
            file.transferTo(destFile);

            // Sinh ID ngẫu nhiên cho món ăn và lưu vào danh sách
            Food newFood = new Food(uniqueCode, name, price, finalFileName);
            foodList.add(newFood);

            // Dùng RedirectAttributes truyền thông báo
            redirectAttributes.addFlashAttribute("message", "Thêm món ăn thành công rực rỡ!");

            // CHUYỂN HƯỚNG SANG TRANG CHI TIẾT (Đính kèm ID lên URL)
            return "redirect:/food/detail?id=" + newFood.getId();

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi hệ thống trong quá trình lưu file!");
            return "food-add";
        }
    }

    // 3. API MỚI: Mở trang chi tiết món ăn
    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") String id, Model model) {
        // Tìm món ăn trong danh sách tạm dựa vào ID
        Food foundFood = null;
        for (Food f : foodList) {
            if (f.getId().equals(id)) {
                foundFood = f;
                break;
            }
        }

        // Nếu không tìm thấy thì đẩy về trang thêm
        if (foundFood == null) {
            return "redirect:/food/add";
        }

        // Đẩy đối tượng Food tìm được ra màn hình
        model.addAttribute("food", foundFood);
        return "food-detail";
    }
}