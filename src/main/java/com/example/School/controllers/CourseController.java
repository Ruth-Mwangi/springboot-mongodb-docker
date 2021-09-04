package com.example.School.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.School.models.Course;
import com.example.School.models.User;
import com.example.School.service.CourseService;

@RestController

public class CourseController {
	
	@Autowired
	private CourseService coursedao;
	
	@PostMapping(value = "save-course")
	public Course saveCourse(@RequestBody Course course) {
		return coursedao.save(course);
	}

	@GetMapping(value = "course")
	public Course getById(@RequestParam(required = true) String id) {
		return coursedao.getById(id);
	}
	
	@GetMapping(value = "courses")
	public List<Course> getAll() {
		return coursedao.getAll();
	}
	
	@GetMapping(value = "course-users")
	public List<User> getUsers(@RequestParam String id,@RequestParam String role) {
		return coursedao.getAllUsersOfCourse(id, role);
	}
	
	@PostMapping(value = "update-course")
	public Course updateCourse(@RequestBody Course course) {
		return coursedao.update(course);
	}
	
	@DeleteMapping(value = "delete-course")
	public String deleteById(@RequestParam(required = true) String id) {
		if(coursedao.deleteById(id).wasAcknowledged()) {
			return "Deleted Successfully";
		}
		return "Not Deleted";
	}
	
	@DeleteMapping(value = "delete-all")
	public String deleteAll() {
		
		coursedao.deleteAll();
		return "redirect:/";
	}

}
