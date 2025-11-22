package com.devsenior.svacca.courses_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.svacca.courses_service.model.Course;
import com.devsenior.svacca.courses_service.service.CourseService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



///DRY - Don't Repeat YourSelf (principio de no repetición innecesaria "No te repitas")
@RestController
@RequestMapping("/api/cursos")
public class CourseController {

    private CourseService courseService;

    
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAll();
    }
    
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.getOneById(id);
    }
    
    @GetMapping("/buscar")
    public List<Course> getCourseContainsText(@RequestParam("nombre") String name) {
        return courseService.getAllThatContainsText(name);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {        
        course = courseService.createCourse(course);
        return course;
    }
    
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
    
}
