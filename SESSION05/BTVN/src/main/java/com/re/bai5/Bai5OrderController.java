package com.re.bai5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Bai5OrderController {

    private final Bai5OrderService orderService;

    public Bai5OrderController(Bai5OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/quick-order")
    public String showQuickOrderPage(Model model) {
        OrderSummary summary = orderService.getQuickOrderSummary();
        model.addAttribute("summary", summary);
        return "quick-order";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMsg", "Hệ thống đang bảo trì: " + ex.getMessage());
        return "error-page";
    }
}