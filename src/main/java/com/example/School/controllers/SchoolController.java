package com.example.School.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.School.models.Course;
import com.example.School.models.User;

@Controller
public class SchoolController {
	@RequestMapping("/")
	public String index(Model model) {
		 model.addAttribute("user", new User());
		 model.addAttribute("course", new Course());
		return "index.html";
	}
	
	@RequestMapping("home")
	public String home(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("course", new Course());
		 
		return "404.html";
	}
	
	

}
