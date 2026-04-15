package com.re.session08_02.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {

    @NotNull(message = "Tuổi không được để trống!")
    @Min(value = 18, message = "Lỗi: Tuổi phải từ 18 trở lên!")
    @Max(value = 60, message = "Lỗi: Tuổi không được vượt quá 60!")
    private Integer age;

    public EmployeeDto() {}

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
}