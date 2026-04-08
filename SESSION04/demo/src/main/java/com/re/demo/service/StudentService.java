package com.re.demo.service;

import com.re.demo.model.Student;
import com.re.demo.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    //Tiêm sự phụ thuộc (DI - Dependency Injection)
    @Autowired
    private StudentDAO studentDAO;
    public List<Student> getAllStudent(){
        List<Student> students = studentDAO.findAll();
        return students;
    }

    public List<Student> searchStudent(String key) {
        return studentDAO.search(key);
    }

    public Student getStudentById(int id) {
        return studentDAO.findById(id);
    }
}
