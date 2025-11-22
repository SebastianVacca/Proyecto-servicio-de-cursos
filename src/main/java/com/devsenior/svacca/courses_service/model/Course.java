package com.devsenior.svacca.courses_service.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// POJO - Plain Old Java Object 
// JavaBean
// DTO - Data Trnasfer Object
@Schema(description = "Representa un curso académico")
public class Course {
    @Schema(description = "Identificador único generado automáticamente", example = "1")//Esto doucmneta el Schema en swagger    
    private Long id;

    @Schema(description = "Nombre completo del curso", example = "Programación básica")
    @NotBlank(message = "El campo 'name' es obligatorio")//Esta línea se encarga de hacer la validacion del campo, usando anotacion de spring
    private String name;

    @Schema(description = "Código único del curso", example = "JAVA101")
    @NotBlank(message = "El campo 'code' es obligatorio")//Esta línea se encarga de hacer la validacion del campo, usando anotacion de spring
    @Size(min = 5, message = "El campo code debe tener mínimo 5 caracteres")//Se encargan de validar el mínimo de caracteres que recibe el campo
    @Size(max = 10, message = "El campo code debe tener Máximo 10 caracteres")//Se encargan de validar el máximo de caracteres que recibe el campo
    private String code;

    @Schema(description = "Descripción breve del curso", example = "Curso que provee fundamentos básicos de la programación")
    private String description;

    @Schema(description = "Fecha en la que incia el curso", example = "2025-01-01")
    @FutureOrPresent(message = "La fecha inicial no puede ser menor a la fecha actual")
    private LocalDate intialDate;

    @Schema(description = "Fecha en la que finaliza el curso", example = "2025-01-01")
    @Future(message = "La fecha final debe ser posterior a la fecha actual")
    private LocalDate finallDate;

    @Schema(description = "Cantidad de créditos que tiene el curso", example = "4")
    @Min(value = 1, message = "El campo credits debe tener un valor mínimo de 1")
    @Max(value = 5, message = "El campo credits debe tener un valor máximo de  5")
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
