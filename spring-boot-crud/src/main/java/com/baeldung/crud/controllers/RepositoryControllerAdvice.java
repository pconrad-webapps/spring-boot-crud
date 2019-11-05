package com.baeldung.crud.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.baeldung.crud.repositories.TutorRepository;
import com.baeldung.crud.repositories.CourseOfferingRepository;
import com.baeldung.crud.entities.Tutor;
import com.baeldung.crud.entities.CourseOffering;
import java.util.List;

@ControllerAdvice
public class RepositoryControllerAdvice {
    
    private final TutorRepository tutorRepository;
    private final CourseOfferingRepository courseOfferingRepository;

    @Autowired
    public RepositoryControllerAdvice(
        TutorRepository tutorRepository,
        CourseOfferingRepository courseOfferingRepository
    ) {
        this.tutorRepository = tutorRepository;
        this.courseOfferingRepository = courseOfferingRepository;
    }

    @ModelAttribute("tutors")
    public Iterable<Tutor> getTutors(){
        return tutorRepository.findAll();
    }

    @ModelAttribute("courseOfferings")
    public Iterable<CourseOffering> getCourseOfferings(){
        return courseOfferingRepository.findAll();
    }
}