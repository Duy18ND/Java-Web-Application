package com.re.demo.dao;

import com.re.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentDAO {
    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1, "Đoàn Mạnh Duy", 20, false),
            new Student(2, "Hello World", 23, true),
            new Student(3, "Đoàn Thị Hoài", 18, false)
    ));

    public List<Student> findAll(){
        return this.students;
    }

    public List<Student> search(String key){
        // Bỏ qua phân biệt hoa thường để tìm kiếm thân thiện hơn
        return students.stream()
                .filter(s -> s.getName().toLowerCase().contains(key.toLowerCase()))
                .toList();
    }

    // BỔ SUNG: Hàm tìm sinh viên theo ID
    public Student findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null); // Trả về null nếu không tìm thấy
    }
}