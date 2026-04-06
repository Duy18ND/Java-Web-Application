package SESSION02_01;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Nạp file cấu hình WebConfig đã viết ở trên
        return new Class[]{WebConfig.class};
    }

    // LỖI ở đây — Servlet Mapping bị đặt sai
    @Override
    protected String[] getServletMappings() {
       // return new String[] { "/api/*" };   // ← Chú ý dòng này
        // SỬA: "/" để tiếp nhận mọi request, thay vì "/api/*"
        return new String[]{"/"};
    }
   /* Câu 1:
     Khi tìm /welcome trên trình duyệt, trình duyệt gửi yêu cầu đến Tomcat
    Vì tomcat nhìn vào cấu hình yêu cầu bắt đầu bằng /api. Vì /welcome không bắt đầu bằng /api, Tomcat sẽ không gọi DispatcherServlet .
    Tomcat sẽ tự đi tìm file /welcome trong thư mục vì project không có file nào tên vậy nên nó trả về 404
    Câu 2:
    - Hậu quả của @ComponentScan(basePackages = "com.demo.service")
        Spring tìm @Controller ở đâu? Nó chỉ quét bên trong package com.demo.service và các package con của nó.
    - Không thể tìm thấy ở đâu? Nó sẽ bỏ qua hoàn toàn package com.demo.controller. Vì các lớp @Controller
        thường nằm ở package controller, Spring sẽ không khởi tạo (instantiate) chúng vào trong Container.
    - Hậu quả: Khi bạn truy cập URL, Spring sẽ báo lỗi 404 vì nó không tìm thấy bất kỳ "đầu mối"
        (Handler Mapping) nào khớp với URL đó trong bộ nhớ.
    Câu 3:
        Đáp án: KHÔNG.
        - Sửa lỗi 1 chỉ giúp Request "chạm" được vào DispatcherServlet. Tuy nhiên, khi vào đến nơi, DispatcherServlet hỏi: "Có Controller nào
        nhận xử lý cái này không?", thì Spring trả lời: "Không có" (vì lỗi Scan nên Controller chưa bao giờ được nạp vào hệ thống). Kết quả vẫn là 404.
    */

}
