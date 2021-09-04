package com.example.School.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.School.models.Course;
import com.example.School.models.User;
import com.example.School.repository.CourseRepo;
import com.mongodb.client.result.DeleteResult;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepo courserepo;

	@Override
	public Course save(Course course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public Course getById(String id) {
		// TODO Auto-generated method stub
		return courserepo.getById(id);
	}

	@Override
	public List<Course> getByName(String name) {
		// TODO Auto-generated method stub
		return courserepo.getByName(name);
	}

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsersOfCourse(String id, String role) {
		// TODO Auto-generated method stub
		return courserepo.getAllUsersOfCourse(id, role);
	}

	@Override
	public Course update(Course course) {
		// TODO Auto-generated method stub
		return courserepo.update(course);
	}

	@Override
	public DeleteResult deleteById(String id) {
		// TODO Auto-generated method stub
		return courserepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		courserepo.deleteAll();
		
	}

}
