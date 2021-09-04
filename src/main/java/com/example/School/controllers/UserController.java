package com.example.School.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.School.models.User;
import com.example.School.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userdao;

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	@RequestMapping("/error")
	public String error() {
		return "404.html";
	}

	@PostMapping(value = "save-user")
	public User saveUser(@RequestBody User user) {
		return userdao.save(user);
	}

	@GetMapping(value = "user")
	public User getById(@RequestParam(required = true) String id) {
		return userdao.getById(id);
	}
	
	@GetMapping(value = "users")
	public List<User> getAll() {
		return userdao.getAll();
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
