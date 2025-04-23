package com.AdithyaUrs.thymleafDemo.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController
{
    //new controller method to show initial form
    @GetMapping("/showform")
    public String showForm()
    {
        return "helloworld-form";
    }

    //new controller method to process the form
    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }

    //new controller to convert name to uppercase & add data to model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request,Model model)
    {
        //read the request parametre from the html
        String theName = request.getParameter("studentName");

        //convert to upper case and add yo!
        theName = "Yo! " + theName.toUpperCase();

        //add data to model
        model.addAttribute("message",theName); //name of the new attirbute is message , we will use in html
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model)
    {
        //convert to upper case and add yo!
        theName = "Yo yo maa! " + theName.toUpperCase();

        //add data to model
        model.addAttribute("message",theName); //name of the new attirbute is message , we will use in html
        return "helloworld";
    }
}
