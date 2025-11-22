package com.devsenior.svacca.courses_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.devsenior.svacca.courses_service.exception.CourseNotFoundException;
import com.devsenior.svacca.courses_service.model.Course;

@Service
public class CourseServiceInMemory implements CourseService {

    private AtomicLong consecutive; // variable declarada para hacer un id consecutivo con SpringBoot
    private List<Course> courses;

    public CourseServiceInMemory(List<Course> courses) {
        this.courses = new ArrayList<>();
        consecutive = new AtomicLong(1);// se inicializa AtomicLong como un objeto
    }

    @Override
    public List<Course> getAll() {
        return new ArrayList<Course>(courses); // retorna una copia de la lista original
    }

    @Override
    public Course getOneById(Long id) {
        validateID(id);

        var course = courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException(// si no encuentra nada crea un objeto para devolver esta
                                                               // excepción
                        String.format("El curso con Id '%d' no existe", id)));

        return course;
    }

    @Override
    public List<Course> getAllThatContainsText(String partialText) {
        if (partialText == null || partialText.isBlank()) {
            return getAll();
        }
        return courses.stream()
                .filter(c -> c.getName().toLowerCase().contains(partialText.toLowerCase()) || c.getDescription().contains(partialText.toLowerCase()))
                .toList();
    }

    @Override
    public Course createCourse(Course course) {
        validateCourse(course);

        // Generación de Id autoincremental
        course.setId(consecutive.getAndIncrement());// se coloca el id de manera autoincrmental

        // Agregar curso a la lista de cursos
        courses.add(course);

        return course;
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        validateID(id);
        validateCourse(course);

        var existingCourse = getOneById(id);

        existingCourse.setCode(course.getCode());
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setIntialDate(course.getIntialDate());
        existingCourse.setFinallDate(course.getFinallDate());
        existingCourse.setCredits(course.getCredits());
        return existingCourse;
    
    }

    @Override
    public void deleteCourse(Long id) {
        validateID(id);
        var existingCourse = getOneById(id);

        courses.remove(existingCourse);
    }

    private void validateID(Long id) {
        // if (id == null) {
        //     throw new IllegalArgumentException("El id está vacío");
        // }
        // if (id < 0) {
        //     throw new IllegalArgumentException("El id no puede ser negativo");
        // }
    }

    private void validateCourse(Course course){
        // if (course == null) {
        //     throw new IllegalArgumentException("No hay un curso para guardar");
        // }
        // if (course.getName() == null || course.getName().isBlank()) {
        //     throw new IllegalArgumentException("El nombre del curso es obligatorio");
        // }
        // if (course.getCredits() < 0) {
        //     throw new IllegalArgumentException("Los créditos del curso deben ser mayores a cero");
        // }
        if (course.getIntialDate().isAfter(course.getFinallDate())) {
            throw new IllegalArgumentException("La fecha inicio no puede ser mayor a la fecha final");
        }
    }

}
