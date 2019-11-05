package com.baeldung.crud.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.baeldung.crud.entities.Tutor;
import com.baeldung.crud.repositories.TutorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class TutorController {
    
    private Logger logger = LoggerFactory.getLogger(TutorController.class);

    private final TutorRepository tutorRepository;

    @Autowired
    public TutorController(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }
     
    @GetMapping("/")
    public String home(Model model) {
        logger.info("Entering TutorController.home.  model="+model.toString());
        model.addAttribute("tutors", tutorRepository.findAll());
        logger.info("Exiting TutorController.home.  model="+model.toString());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUpForm(Tutor tutor) {
        return "add-tutor";
    }
   

    @PostMapping("/addtutor")
    public String addTutor(@Valid Tutor tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-tutor";
        }
        
        tutorRepository.save(tutor);
        model.addAttribute("tutors", tutorRepository.findAll());
        return "index";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tutor Id:" + id));
        model.addAttribute("tutor", tutor);
        return "update-tutor";
    }
    
    @PostMapping("/update/{id}")
    public String updateTutor(@PathVariable("id") long id, @Valid Tutor tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            tutor.setId(id);
            return "update-tutor";
        }
        
        tutorRepository.save(tutor);
        model.addAttribute("tutors", tutorRepository.findAll());
        return "index";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteTutor(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid tutor Id:" + id));
        tutorRepository.delete(tutor);
        model.addAttribute("tutors", tutorRepository.findAll());
        return "index";
    }
}
