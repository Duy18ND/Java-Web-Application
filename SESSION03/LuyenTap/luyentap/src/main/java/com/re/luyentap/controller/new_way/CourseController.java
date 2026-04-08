package com.re.luyentap.controller.new_way;

import com.re.luyentap.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller // Tạo Bean và chỉ định đây là tâng controller
public class CourseController {
    @Autowired // Kém an toàn  nên sử dụng constructor
    private CourseService courseService;

    //Tạo và xử lý yêu cầu từ CLient
    @RequestMapping("/course") // Tiếp nhận và xử lý request theo method GET với đường dẫn "/course"
    public String courseView() {
        return "course";// Trả về giao diện course.jsp
    }

    //Phương thức xử lý theo get
//    @RequestMapping("/list-product")//Mục dích lấy danh sách sản phẩm với đường dẫn "/list-product"
    @GetMapping("/list-product")
    // Cú pháp tương dương với @RequestMapping nhưng @GetMapping là chỉ lấy không xóa, thêm, vv
    public String listProduct() {
        return "list-product";
    }

    //Phương thức xử lý theo post
    //@RequestMapping(value = "/from", method = RequestMethod.POST) //value là đường dẫn method = RequestMethod.POST, PUT,GET,DELETE, vv
    @PostMapping("/form") //chỉ lấy
    public String formProduct(
            //Nhận tham số trong form
    ) {
        //Xử lý
        //Trả về view
//        return "success"; //Đang trả về 1 view
        //Có thể điều hướng theo phương thức GET
        return "redirect:/list-product";
        //Lưu ý không gọi trực tiếp phương thức mà điều hướng nó = redirect:/
    }

    //Lấy dữ liệu thông qua GET
    @GetMapping("/search")
    //requied là tủy chọn người dùng có thể để trống hoặc nhập dữ liệu required = false là có thể nhập or không
    //defaultValue là giá trị mặc định nếu để trống hoặc null
    public String search(@RequestParam(value = "key", required = false, defaultValue = "") String name){
        //nếu truy cập url = /search?key=Duy
        //name = Duy
        System.out.println("Name: "+ name);
        return "search";
    }

    //Cách 2:
    @GetMapping("/path/{key}")
    public String path(@PathVariable("key") String name){
        //Truy xuất URL
        //Name = Duy
        System.out.println("Name:" + name);
        return "path";
    }
        //Có thể lồng ví dụ mã khách 1 và đơn hàng abc để tìm chính xác
    @GetMapping("/customers/{customerId}/orders/{orderId}")
    public String getOrder(
            @PathVariable("customerId") int cusId,
            @PathVariable("orderId") int ordId) {

        System.out.println("Khách: " + cusId + " | Đơn: " + ordId);
        return "order-detail";
    }

    //Xử lý hiển thị dữ liệu
    //Model
    @GetMapping("/model")
    public String viewModal(Model model){
        model.addAttribute("name","Nguyễn Văn A");
        model.addAttribute("age",18);
        return "result";
    }

    //Model Map
    @GetMapping("/model-map")
    public String viewModal(ModelMap modelMap){
        modelMap.addAttribute("name","Nguyễn Văn A");
        modelMap.addAttribute("age",18);
        return "result";
    }

    //ModelAndView
    @GetMapping("/model-and-view")
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("name","Nguyễn Văn A");
        modelAndView.addObject("age",12);
        return modelAndView;
    }

}
