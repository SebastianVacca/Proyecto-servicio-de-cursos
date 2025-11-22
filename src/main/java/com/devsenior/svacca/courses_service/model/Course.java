package com.devsenior.svacca.courses_service.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

// POJO - Plain Old Java Object 
// JavaBean
// DTO - Data Trnasfer Object
@Schema(description = "Representa un curso académico")
public class Course {
    @Schema(description = "Identificador único generado automáticamente", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del curso", example = "Programación básica")
    private String name;

    @Schema(description = "Código único del curso", example = "JAVA101")
    private String code;

    @Schema(description = "Descripción breve del curso", example = "Curso que provee fundamentos básicos de la programación")
    private String description;

    @Schema(description = "Fecha en la que incia el curso", example = "2025-01-01")
    private LocalDate intialDate;

    @Schema(description = "Fecha en la que finaliza el curso", example = "2025-01-01")
    private LocalDate finallDate;

    @Schema(description = "Cantidad de créditos que tiene el curso", example = "4")
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
