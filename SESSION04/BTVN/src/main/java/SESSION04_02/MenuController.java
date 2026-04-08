package SESSION04_02;

import SESSION04_01.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {

    private final OrderService orderService;

    @Autowired
    public MenuController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/menu")
    public String getMenu(
            @RequestParam(value = "category", required = false, defaultValue = "chay") String category,
            Model model
    ) {
        model.addAttribute("loaiMenu", category);
        return "menu";
    }
}