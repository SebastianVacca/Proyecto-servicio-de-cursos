package com.devsenior.svacca.courses_service.model;

import java.time.LocalDate;

// POJO - Plain Old Java Object 
// JavaBean
// DTO - Data Trnasfer Object
public class Course {
    private Long id;
    private String name;
    private String code;
    private String description;
    private LocalDate intialDate;
    private LocalDate finallDate;
    private Integer credits;

    public Course() {
    }

    public Course(Long id, String name, String code, String description, LocalDate intialDate, LocalDate finallDate,
            Integer credits) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.description = description;
        this.intialDate = intialDate;
        this.finallDate = finallDate;
        this.credits = credits;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getIntialDate() {
        return intialDate;
    }

    public void setIntialDate(LocalDate intialDate) {
        this.intialDate = intialDate;
    }

    public LocalDate getFinallDate() {
        return finallDate;
    }

    public void setFinallDate(LocalDate finallDate) {
        this.finallDate = finallDate;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    
    
}
