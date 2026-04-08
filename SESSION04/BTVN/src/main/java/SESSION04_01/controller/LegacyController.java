package SESSION04_01.controller;

import SESSION04_01.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("legacyControllerBai1")
public class LegacyController {
    private  final OrderService orderService;

    public LegacyController(OrderService orderService){
        this.orderService = orderService;
    }
    @GetMapping(value = "/order-page")
    @ResponseBody
//    @RequestMapping(value = "/order-page", method = RequestMethod.GET)
    public String getAllOrders(Model model) {
        List<String> orders = List.of("Don 1", "Don 2", "Don 3");
        model.addAttribute("orders", orders);
        return "order-page";
    }


    @GetMapping(value = "/order-page/{id}")
    @ResponseBody
//    @RequestMapping(value = "/order-page/{id}", method = RequestMethod.GET)
    public String getOrderById(@PathVariable("id") Long id) {
        System.out.println("GetOrdereById: "+ id);
        return orderService.getOrderById(id);
    }
}

