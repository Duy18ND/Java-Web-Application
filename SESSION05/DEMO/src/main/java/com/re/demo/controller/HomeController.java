package com.re.demo.controller;

import com.re.demo.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {
    //Hiển thị danh sách sản phẩm ra màn hình
    /*
    Class Product
    - id
    - name
    - price
    - stock
    - status
    */
    List<Product> products = new ArrayList<>(
            Arrays.asList(
                    new Product(1, "Sản phẩm A", 20000.0, 1, true),
                    new Product(2, "Sản phẩm B", 12000.0, 1, false),
                    new Product(3, "Sản phẩm C", 21000.0, 1, true)
            )
    );
    @GetMapping
    public String home(Model model){
        model.addAttribute("shop", products);
        return "home";
    }

    @GetMapping("/delete/${id}")
    public String handleDelete(@PathVariable(name = "id") int id /*,Model model*/){
        products = products.stream().filter(p -> p.getId() != id).toList();
        //Cách 1: Gửi thêm dữ liệu đi chính là shop và products
//        model.addAttribute("shop", products);
        //Cách 2: sử dụng redirect:/ điều hướng đúng đường dẫn của @GetMapping
        return "redirect:/";
    }
}
