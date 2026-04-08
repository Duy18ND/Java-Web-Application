package com.re.luyentap.model;

import java.util.Date;

public class Course {
    Integer id;
    String courseName;
    Double fee;
    Integer startDate;
    Integer status;

    public Course(){}
    public Course(Integer id, String courseName, Double fee, Integer startDate, Integer status) {
        this.id = id;
        this.courseName = courseName;
        this.fee = fee;
        this.startDate = startDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer startDate) {
        this.startDate = startDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
