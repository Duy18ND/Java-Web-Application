package com.re.demo.controller;

import com.re.demo.model.Student;
import com.re.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*Cách annotation phổ biến:
    Các annotation không khác gì bean dùng để khởi tạo và sử dụng DI (dependency injection)
    - @Component    //Đánh dấu là Bean để khởi tạo và không có ngữ nghĩa
    - @Controller   //Đánh dấu là Bean và mục đích là điều hướng
    - @Service      //Đánh dấu là Bean và mục đích là xử lý nghiệp vụ
    - @Repository   //Đánh dấu là Bean và mục đích là xử lý tương tác Database (DAO)
    - @Autowired    //Dùng để tiêm sự phụ thuộc DI (Dependency Injection)
*/
//Đánh dấu Bean nó là Controller
@Controller
//Đánh dấu đây là đường dẫn đến Controller
@RequestMapping({"/", "/home"})
public class HomeController {
    //DI
    //Tiêm service vào controller
    @Autowired
    private StudentService service;

    /*
        Biến thể của @RequestMapping
            - @GetMapping   //Đại diện cho phương thức GET
            - @PostMapping  //Đại diện cho phương thức POST
            - @PutMapping   //Đại diện cho phương thức PUT
            - @PatchMapping //Đại diện cho phương thức PATCH
            - @DeleteMapping //Đại diện cho phương thức DELETE

        @RequestMapping(method = RequestMethod.GET) - cách cũ
        @GetMapping - Cách mới
    */
    @RequestMapping
    public String home(Model model) {
        List<Student> students = service.getAllStudent();
        System.out.println(students);

        model.addAttribute("listStudent", students);
        return "home";
    }

    // 2. TÌM KIẾM: Lọc sinh viên theo tên
    @GetMapping("/search")
    public String searchByName(
            @RequestParam(name = "key", defaultValue = "") String keyword,
            Model model) {

        // Gọi Service để tìm kiếm
        List<Student> searchResult = service.searchStudent(keyword);

        // Đẩy kết quả vào Model (dùng chung tên biến listStudent để file home.jsp đỡ phải viết lại code)
        model.addAttribute("listStudent", searchResult);

        // Đẩy lại keyword để hiển thị lên ô input
        model.addAttribute("savedKeyword", keyword);

        return "home";
    }

    //Thường là những trang detail (Chi tiết)
    //Id ở đường dẫn có thể đặt theo tùy biến
    // 3. CHI TIẾT: Xem thông tin 1 sinh viên
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model){ // Bỏ 'name = "id"' đi cho gọn

        // Gọi Service lấy thông tin sinh viên
        Student student = service.getStudentById(id);

        // Đẩy vào Model
        model.addAttribute("studentDetail", student);

        // Thường thì trang chi tiết sẽ là một file JSP riêng biệt
        return "detail";
    }
}
