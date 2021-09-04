package com.example.School.service;

import java.util.List;

import com.example.School.models.Course;
import com.example.School.models.User;
import com.mongodb.client.result.DeleteResult;

public interface CourseService {
	// create

	public Course save(Course course);

	// read
	public Course getById(String id);

	public List<Course> getByName(String name);

	public List<Course> getAll();

	public List<User> getAllUsersOfCourse(String id, String role);

	// update
	public Course update(Course course);

	// delete
	public DeleteResult deleteById(String id);

	public void deleteAll();

}
