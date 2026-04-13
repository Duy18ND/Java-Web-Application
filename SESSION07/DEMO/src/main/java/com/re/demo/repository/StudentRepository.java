package com.re.demo.repository;

import com.re.demo.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {
    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Đoàn Mạnh Duy", true, 12, "Hà Nội"),
                    new Student(2, "Đoàn Thị Hoài", false, 18, "Hà Nội"),
                    new Student(3, "Đoàn Văn Tú", true, 24, "Hà Nội"),
                    new Student(4, "Trần Khánh Hoa", false, 21, "Hà Nội")
            )
    );

    public List<Student> getAllStudent(){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
