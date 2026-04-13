package com.re.demo.controller;

import com.re.demo.model.Student;
import com.re.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("students",studentRepository.getAllStudent());
        System.out.println(studentRepository.getAllStudent());
        return "home";
    }

    @GetMapping("/form-add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form-add";
    }

    @PostMapping("/handle-add")
    public String handleAdd(@ModelAttribute(name = "student") Student student){
        System.out.println(student);
        studentRepository.addStudent(student);
        return "redirect:/home";
    }
}