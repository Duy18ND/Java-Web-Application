package com.re.session08_01.controller;

import com.re.session08_01.dto.AddressDto;
import com.sun.net.httpserver.Request;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class UserController {
    //Mã lỗi:
//    @PostMapping("/update")
//    public ResponseEntity<String> update(@RequestBody AddressDto addressDto){
//        return ResponseEntity.ok("Cập nhật thành công!");
//    }
//   Mã sửa:
    // Thêm @Valid là validate theo annotion trong DTO
    //Nếu không có Validate sẽ không chạy
    @PostMapping("/update")
    public ResponseEntity<String> updateAddress(
            @Valid @RequestBody AddressDto addressDto,
            BindingResult result // Dùng để hứng lỗi
    ) {
        if (result.hasErrors()) {
//            Trả về HTTP 400 (Bad Request)
//            Kèm message lỗi
            return ResponseEntity.badRequest().body(
                    result.getFieldError().getDefaultMessage()
            );
        }

        addressDto.setReceiverName(addressDto.getReceiverName().trim());
        addressDto.setDetailAddress(addressDto.getDetailAddress().trim());

        return ResponseEntity.ok("Cập nhật địa chỉ thành công!");
    }
}
