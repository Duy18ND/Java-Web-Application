package SESSION04_01.repository;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.List;

@Repository
public class OrderRepository {

    public String getAllOrders(Model model) {
        List<String> orders = List.of("Don 1", "Don 2", "Don 3");
        model.addAttribute("orders", orders);
        return "order-page";
    }

    public String getOrderById(Long id) {
        return "Thong tin don hang voi ID: " + id;
    }



}