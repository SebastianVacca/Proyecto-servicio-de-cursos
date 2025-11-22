package com.devsenior.svacca.courses_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.svacca.courses_service.model.Course;
import com.devsenior.svacca.courses_service.service.CourseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

///DRY - Don't Repeat YourSelf (principio de no repetición innecesaria "No te repitas")
@Tag(name = "Cursos", description = "API para la gestión de cursos académicos")
@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Listar todos los cursos", description = "Retorna la información de los cursos habilitados en el sistema")
    @ApiResponse(responseCode = "200", description = "Listado de cursos encontrados de manera exitosa")
    @ApiResponse(responseCode = "205", description = "Listado de cursos encontrados de manera exitosa", content = @Content())
    @ApiResponse(responseCode = "400", description = "No hay cursos", content = @Content())
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }

    @Operation(summary = "Buscar un curso por id", description = "Retorna la información del curso obtenido por el Id")
    @ApiResponse(responseCode = "200", description = "Busqueda de curso por Id exitosa")
    @ApiResponse(responseCode = "500", description = "el curso no fue encontrado", content = @Content())
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Course getCourseById(@PathVariable @Min(value = 1, message = "El Id debe ser mayor a cero") Long id) {
        return courseService.getOneById(id);
    }

    @GetMapping("/buscar")
    public List<Course> getCourseContainsText(@RequestParam(value = "nombre") String name) {
        return courseService.getAllThatContainsText(name);
    }

    @Operation(summary = "Crear un curso")
    @PostMapping
    public Course createCourse(
        //linea para doumentar el swagger sobre la estructura que se espera
            @RequestBody(description = "datos del nuevo curso", required = true, content = @Content(schema = @Schema(implementation = Course.class))) @org.springframework.web.bind.annotation.RequestBody @Valid Course course) {
        course = courseService.createCourse(course);
        return course;
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable @Min(value = 1, message = "El Id debe ser mayor a cero") Long id,
     @RequestBody(description = "Datos del curso a actualizar", required =  true, content = @Content(schema = @Schema(implementation = Course.class)))@org.springframework.web.bind.annotation.RequestBody @Valid Course course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Min(value = 1, message = "El Id debe ser mayor a cero") Long id) {
        courseService.deleteCourse(id);
    }

}
