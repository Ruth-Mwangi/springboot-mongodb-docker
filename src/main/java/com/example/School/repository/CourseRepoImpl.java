package com.example.School.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.School.models.Course;
import com.example.School.models.User;
import com.mongodb.client.result.DeleteResult;

import lombok.SneakyThrows;

@Repository
public class CourseRepoImpl implements CourseRepo {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	@SneakyThrows
	public Course save(Course course) {
		// TODO Auto-generated method stub
		return mongoTemplate.save(course, "course");
	}

	@Override
	@SneakyThrows
	public Course getById(String id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, Course.class,"course");
	}

	@Override
	@SneakyThrows
	public List<Course> getByName(String name) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("name").regex(name));
		return mongoTemplate.find(query, Course.class,"course");
	}

	@Override
	@SneakyThrows
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Course.class, "course");
	}

	@Override
	@SneakyThrows
	public List<User> getAllUsersOfCourse(String id, String role) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("courses").all(id).and("role").is(role));
		
	
		
		return mongoTemplate.find(query, User.class, "user");
	}

	@Override
	@SneakyThrows
	public Course update(Course course) {
		// TODO Auto-generated method stub
		return mongoTemplate.save(course,"course");
	}

	@Override
	@SneakyThrows
	public DeleteResult deleteById(String id) {

		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(id));
		
		return mongoTemplate.remove(query, "course");
	}

	@Override
	@SneakyThrows
	public void deleteAll() {
		// TODO Auto-generated method stub
		 mongoTemplate.dropCollection("course");
	}

}
