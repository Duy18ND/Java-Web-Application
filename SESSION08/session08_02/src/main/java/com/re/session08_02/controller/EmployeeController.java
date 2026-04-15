package com.re.session08_02.controller;

import com.re.session08_02.dto.EmployeeDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    // 1. GET Mapping: Đón người dùng ở đường dẫn gốc và hiển thị Form
    @GetMapping({"/employee-form", "/"})
    public String showForm(Model model) {
        // Gửi một DTO rỗng xuống để Thymeleaf có chỗ bám vào render form
        model.addAttribute("employee", new EmployeeDto());
        return "employee-form";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    // 2. POST Mapping: Xử lý dữ liệu khi người dùng bấm Submit (Cùng đường dẫn "/")
    @PostMapping("/")
    public String saveEmployee(
            @Valid @ModelAttribute("employee") EmployeeDto employee,
            BindingResult bindingResult,
            Model model
    ) {
        // Kiểm tra lỗi (BindingResult đứng ngay sát @Valid)
        if (bindingResult.hasErrors()) {
            return "employee-form"; // Có lỗi thì trả lại trang form
        }

        // Gọi Service lưu vào DB...

        return "redirect:/success";
    }
}