package com.re.demo.dto;

import com.re.demo.model.Gender;
import com.re.demo.validator.EmailExits;
import com.re.demo.validator.NameExists;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PersonDTO {
    @Min(1)
    private Long id;
    @NotBlank(message = "Tên không được bỏ trống")
    @NameExists(message = "Name này đã được đăng ký, vui lòng sử dụng name khác!")
    private String name;
    private Gender gender;
    @PastOrPresent(message = "Không được lớn hơn ngày hiện tại")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateOfBirth;
    @Min(value = 18, message = "Phải nhập bằng hoặc trên 18 tuổi!")
    private Integer age;
    @NotBlank(message = "Email không được bỏ trống")
    @Pattern(regexp = "^$|^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "Email không đúng định dạng")
    @EmailExits(message = "Lỗi: Email này đã được đăng ký, vui lòng dùng email khác!")
    private String email;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, Gender gender, LocalDate dateOfBirth, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
