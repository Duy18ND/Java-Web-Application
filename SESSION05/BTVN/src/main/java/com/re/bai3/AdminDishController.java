package com.re.bai3;

import com.re.bai2.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminDishController {

    private final AdminDishService adminDishService;

    public AdminDishController(AdminDishService adminDishService) {
        this.adminDishService = adminDishService;
    }

    // 1. Hiển thị danh sách món ăn
    @GetMapping("/bai3/dishes")
    public String showDishes(Model model) {
        model.addAttribute("dishes", adminDishService.getAllDishes());
        return "dish-list";
    }

    // 2. Xử lý logic khi bấm nút "Chỉnh sửa"
    @GetMapping("/bai3/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {

        // Gọi Service lấy dữ liệu
        Dish dish = adminDishService.findById(id);

        // [BẪY DỮ LIỆU]: Không tìm thấy ID
        if (dish == null) {
            // Dùng addFlashAttribute để thông báo sống sót qua lệnh redirect
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy món ăn yêu cầu!");
            return "redirect:/bai3/dishes"; // Điều hướng ngược về trang danh sách
        }

        // Nếu tìm thấy: đẩy đối tượng vào model và mở form
        model.addAttribute("dish", dish);
        return "edit-dish";
    }
}