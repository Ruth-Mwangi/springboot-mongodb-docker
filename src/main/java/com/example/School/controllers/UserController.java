package com.example.School.controllers;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.School.models.User;
import com.example.School.service.UserService;


@RestController
@Controller
public class UserController {
	@Autowired
	private UserService userdao;

	
	
	@PostMapping(value = "save-user")
	public ModelAndView saveUser( User user, BindingResult result, Model model) {
		userdao.save(user);
		
		return new ModelAndView("redirect:/");
	}

	@GetMapping(value = "user")
	public User getById(@RequestParam(required = true) String id) {
		return userdao.getById(id);
	}
	
	@GetMapping(value = "users")
	public ModelAndView  getAll(Model model) {
		model.addAttribute("users",userdao.getAll() );
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("users");
		return modelAndView;
	}
	
	@PostMapping(value = "update-user")
	public User updateUser(@RequestBody User user) {
		return userdao.update(user);
	}
	
	@DeleteMapping(value = "delete-user")
	public String deleteById(@RequestParam(required = true) String id) {
		if(userdao.deleteById(id).wasAcknowledged()) {
			return "Deleted Successfully";
		}
		return "Not Deleted";
	}
	
	@DeleteMapping(value = "delete-all")
	public String deleteAll() {
		
		userdao.deleteAll();
		return "redirect:/";
	}
	
}
