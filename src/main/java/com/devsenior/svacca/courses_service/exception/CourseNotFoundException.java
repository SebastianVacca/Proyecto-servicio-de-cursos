package com.devsenior.svacca.courses_service.exception;

public class CourseNotFoundException extends RuntimeException {
    
    public CourseNotFoundException(String message){
        super(message);
    }
}
