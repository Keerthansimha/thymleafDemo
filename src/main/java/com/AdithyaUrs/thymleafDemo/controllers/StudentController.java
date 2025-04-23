package com.AdithyaUrs.thymleafDemo.controllers;

import com.AdithyaUrs.thymleafDemo.Model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    @Value("${countries}")
    private List<String> countries;

    @Value("${favProgLang}")
    private List<String> favProgLang;

    @Value("${knownOS}")
    private List<String> knownOS;


    //method to show the form
    @GetMapping("/showStudentForm")
    public String showForm(Model model)
    {
        //create a stud obj
        Student theStudent = new Student();
        //add stud as a model attribute
        model.addAttribute("student",theStudent);

        //add attributes to model
        model.addAttribute("countries",countries);
        model.addAttribute("favProgLang",favProgLang);
        model.addAttribute("knownOS",knownOS);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent)
    {
        System.out.println(theStudent.toString());
        return "student-confirmation";
    }
}
