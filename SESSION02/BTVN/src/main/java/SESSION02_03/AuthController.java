package SESSION02_03;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLogin(HttpSession session) {
        // Tránh việc người đã đăng nhập quay lại trang login
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/orders";
        }
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               HttpSession session,
                               Model model) { // Model trong Spring MVC tương đương Request Scope

        if (("admin".equals(username) && "admin123".equals(password)) ||
                ("staff".equals(username) && "staff123".equals(password))) {

            // Đăng nhập thành công -> Lưu vào Session Scope
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", username.equals("admin") ? "Quản lý" : "Nhân viên");
            return "redirect:/orders";
        }

        // Đăng nhập sai -> Lưu vào Request Scope (thông qua Model)
        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Hủy toàn bộ Session của người dùng này
        return "redirect:/login";
    }
}