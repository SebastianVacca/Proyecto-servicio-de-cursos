package com.devsenior.svacca.courses_service.service;

import java.util.List;

import com.devsenior.svacca.courses_service.model.Course;

//JAVADOC
/**
 * Clase de lógica de negocio para gestionar cusrsos
 */
public interface CourseService {

    /**
     * Lista todos los cursos existentes en el sistema
     * @returnTodos los cursos existentes. EN caso de que no haya ningún curso, devuelva una lista vacía
     */
    List<Course> getAll();

    /**
     * Consulta el curso que tenga asignado el id dado
     * @param id El identificador del curso a buscar
     * @returnLa información del curso que tiene el id dado
     * @throws IllegalArgumentException si el id es nulo o menor a 0
     * @throws CourseNotFounException si no se encuentra el id en los cursos del sistema
     */
    Course getOneById(Long id);

    List<Course> getAllThatContainsText(String partialText);

    Course createCourse(Course course);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}
