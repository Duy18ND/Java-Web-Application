package com.re.btvn.SESSION07_02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class DishController {
    /*
     * Mất thời gian & Dễ sót bug: Giả sử quán trà sữa update menu, thêm nhóm món "Đồ ăn vặt".
     * Bạn sẽ phải đi mở từng hàm GET một trong số 20 hàm đó để thêm chữ "Đồ ăn vặt" vào.
     * Chỉ cần lỡ tay quên sửa ở 1 hàm (ví dụ trang Search), hệ thống sẽ bị lỗi logic hiển thị
     * (trang có trang không) rất khó để dò tìm.
     * */
    // API 1: Mở form thêm mới

//    Phần 2:
    @ModelAttribute("categories")
    public List<String> populateCategories() {
        return Arrays.asList("Món chính", "Đồ uống", "Tráng miệng", "Topping");
    }

    // 1. Mở Form nhập liệu (Trỏ vào file dish.html)
    @GetMapping("/dish")
    public String showForm(Model model) {
        model.addAttribute("newDish", new Dish());
        return "dish";
    }

    // 2. Xử lý khi bấm nút Submit trên Form
    @PostMapping("/dish/save")
    public String saveDish(@ModelAttribute Dish newDish, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("dishSuccess", newDish);
        redirectAttributes.addFlashAttribute("message", "Thêm món ăn thành công!");
        System.out.println(newDish);
        return "redirect:/showDish";
    }

    @GetMapping("/showDish")
    public String showResult() {
        return "showDish";
    }
}