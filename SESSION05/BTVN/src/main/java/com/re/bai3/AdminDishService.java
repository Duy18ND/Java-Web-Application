package com.re.bai3;

import com.re.bai2.Dish;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AdminDishService {

    // Giả lập Database hiện tại có 3 món ăn
    private List<Dish> mockDatabase = Arrays.asList(
            new Dish(1, "Phở bò xào lăn", 55000.0, true),
            new Dish(2, "Bún chả Hà Nội", 45000.0, true),
            new Dish(3, "Cơm rang dưa bò", 40000.0, false)
    );

    // Lấy toàn bộ (Dùng cho trang danh sách)
    public List<Dish> getAllDishes() {
        return mockDatabase;
    }

    // Tìm kiếm theo ID (Dùng cho trang chỉnh sửa)
    public Dish findById(int id) {
        return mockDatabase.stream()
                .filter(dish -> dish.getId() == id)
                .findFirst()
                .orElse(null); // Trả về null nếu không tìm thấy ID (Bẫy dữ liệu)
    }
}