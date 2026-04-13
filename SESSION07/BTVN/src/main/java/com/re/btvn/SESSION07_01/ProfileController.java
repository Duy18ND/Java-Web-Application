package com.re.btvn.SESSION07_01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfileController {

    // 1. Mở form
    @GetMapping({"/", "/update-profile"})
    public String showForm(Model model){
        model.addAttribute("profile", new RestaurantProfile());
        return "update-profile";
    }

    // 2. Nhận dữ liệu
    @PostMapping("/update-profile")
    public String updateProfile(@ModelAttribute RestaurantProfile profile,
                                RedirectAttributes redirectAttributes) {

        System.out.println("Tên quán: " + profile.getName());
        System.out.println("SĐT: " + profile.getPhone());
        System.out.println("Trạng thái: " + profile.isActive());

        redirectAttributes.addFlashAttribute("profileSuccess", profile);
        redirectAttributes.addFlashAttribute("message", "Cập nhật hồ sơ thành công!");

        // Điều hướng thẳng về /success
        return "redirect:/success";
    }

    // 3. Đón khách ở đúng cửa /success
    @GetMapping("/success")
    public String showSuccessPage() {
        return "success"; // Nhớ rename file HTML của bạn thành success.html nhé!
    }
}