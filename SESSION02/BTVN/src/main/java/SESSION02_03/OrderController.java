package SESSION02_03;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    // Tiêm ServletContext (Application Scope) vào Controller
    @Autowired
    private ServletContext application;

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model) {
        // Tình huống 1: Bẫy chưa đăng nhập -> Đuổi về /login
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // Tình huống 4 & Race Condition: Đếm view an toàn với synchronized
        synchronized (application) {
            Integer count = (Integer) application.getAttribute("totalViewCount");
            if (count == null) {
                count = 0;
            }
            count++;
            application.setAttribute("totalViewCount", count);
        }

        // Tạo dữ liệu giả (Hardcode)
        List<Order> orders = Arrays.asList(
                new Order(101, "Điện thoại iPhone 15", 22500000.0, new Date()),
                new Order(102, "Tai nghe AirPods Pro", 5200000.0, new Date()),
                new Order(103, "Củ sạc Anker 20W", 350000.0, new Date())
        );

        // Đẩy danh sách đơn hàng vào Request Scope
        model.addAttribute("orderList", orders);

        return "orders";
    }
}
