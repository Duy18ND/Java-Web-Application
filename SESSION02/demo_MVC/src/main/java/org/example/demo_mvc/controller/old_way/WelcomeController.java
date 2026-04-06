package org.example.demo_mvc.controller.old_way;

// Import các thư viện lõi của Jakarta EE để làm việc với Web
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// =========================================================
// KIỂU CŨ: SỬ DỤNG SERVLET THUẦN TÚY (JAVA EE / JAKARTA EE)
// =========================================================

/**
 * @WebServlet: Đây là Annotation (đánh dấu) của Java Web.
 * - name = "welcomeServlet": Đặt tên nội bộ cho Servlet này (giống như tên định danh của nhân viên Lễ tân).
 * - value = "/welcome": Ánh xạ URL (URL Mapping). Khi người dùng gõ "http://localhost:8080/welcome"
 * thì Tomcat sẽ biết phải gọi class này ra để xử lý. (Nó thay thế cho việc cấu hình lằng nhằng trong file web.xml ngày xưa).
 */
@WebServlet(name = "welcomeServlet", value = "/welcome")
public class WelcomeController extends HttpServlet {
    // extends HttpServlet: Bắt buộc phải kế thừa class này thì class của bạn
    // mới biến thành một "Lễ tân" biết xử lý các giao thức mạng (HTTP) được.

    /**
     * Phương thức doGet(): Tự động được gọi khi người dùng truy cập web bằng phương thức GET
     * (ví dụ: gõ URL lên thanh địa chỉ trình duyệt rồi ấn Enter, hoặc bấm vào 1 thẻ <a>).
     * * @param req (Request): Chứa TOÀN BỘ thông tin mà khách hàng (trình duyệt) gửi lên cho Server.
     * @param resp (Response): Là cái phong bì rỗng để Server nhét dữ liệu (HTML, ảnh, chữ) gửi trả lại khách.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Đoạn này gồm 2 bước kết hợp lại:
        // Bước 1 - req.getRequestDispatcher("/WEB-INF/view/welcome.jsp"):
        //   Lệnh này bảo hệ thống chạy vào khu vực cấm (WEB-INF) tìm đúng cái file giao diện có tên là welcome.jsp.
        //   (Lưu ý: Mình đã sửa lại đuôi .jps thành .jsp cho chuẩn nhé).
        //
        // Bước 2 - .forward(req, resp):
        //   "Chuyển tiếp" công việc. Lễ tân (Servlet) sau khi nhận yêu cầu thì gói luôn cái Request và Response
        //   chuyển thẳng cho nhà bếp (file JSP) để nó trộn HTML rồi tự trả về cho khách.
        req.getRequestDispatcher("/WEB-INF/view/welcome.jsp").forward(req, resp);
    }
}