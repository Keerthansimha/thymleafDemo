package com.AdithyaUrs.thymleafDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class DemoController
{
    //creatre mapping for "/hellow"
    @GetMapping("/hello")
    public String sayHellow(Model theModel)
    {
        theModel.addAttribute("theDate" , java.time.LocalDateTime.now());
        return "helloworld"; // this will look for the "helloworld.html"" in templates
    }
}
