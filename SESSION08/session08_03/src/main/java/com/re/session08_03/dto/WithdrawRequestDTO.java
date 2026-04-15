package com.re.session08_03.dto;

import com.re.session08_03.validator.MultipleOfTenThousand;
import com.sun.net.httpserver.Request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class WithdrawRequestDTO {
    //PHẦN 1:
    /*
    Input: Tham số withdrawAmount từ Request Body (Kiểu dữ liệu: Long hoặc BigDecimal
    ở đây ta dùng Long cho bài toán số nguyên tiền tệ cơ bản).

    Output: Trả về true (Hợp lệ, cho phép rút) hoặc false (Không hợp lệ, chặn request
    và ném ra HTTP Status 400 Bad Request kèm message lỗi).

    2. Đề xuất phương án
    Thay vì nhồi nhét logic vào Controller, chúng ta sẽ kết hợp sức mạnh của hệ sinh thái Bean Validation:
    Dùng các Annotation có sẵn: @NotNull (để bẫy lỗi null) và @Min(50000) (để chặn số âm và số nhỏ hơn 50k).
    Tạo một Custom Annotation mang tên @MultipleOfTenThousand chỉ để xử lý riêng quy tắc "ATM không nhả được tờ 5k".

    3. Mã giả:
            BẮT ĐẦU Validator_BoiSoCua10k(withdrawAmount):
            // Bẫy lỗi Null theo Best Practice
            NẾU withdrawAmount LÀ null:
                TRẢ VỀ true // Nhường quyền báo lỗi Null cho thẻ @NotNull xử lý

            // Kiểm tra bội số
            NẾU (withdrawAmount chia lấy dư cho 10.000) BẰNG 0:
                TRẢ VỀ true
            NGƯỢC LẠI:
                TRẢ VỀ false
        KẾT THÚC
    */
    // 1. Bẫy lỗi NULL
    @NotNull(message = "Số tiền rút không được để trống")
    // 2. Bẫy lỗi số âm (-50000) và điều kiện >= 50.000đ
    @Min(value = 50000, message = "Số tiền rút tối thiểu phải là 50.000 VNĐ")
    // 3. Nghiệp vụ FinTech: ATM nhả tiền chẵn
    @MultipleOfTenThousand(message = "Số tiền rút không hợp lệ, ATM chỉ hỗ trợ bội số của 10.000 VNĐ")
    private Long withdrawAmount;

}