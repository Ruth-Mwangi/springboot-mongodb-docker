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

import lombok.Getter;
import lombok.SneakyThrows;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	@Override
	@SneakyThrows
	public User save(User user) {
		// TODO Auto-generated method stub
		return mongoTemplate.save(user, "user");
	}

	@Override
	@SneakyThrows
	public User getById(String id) {
		// TODO Auto-generated method stub
		return mongoTemplate.findById(id, User.class,"user");
	}

	@Override
	@SneakyThrows
	public List<User> getByName(String name) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("fname").regex(name).orOperator(Criteria.where("lname").regex(name)));
		
		return mongoTemplate.find(query, User.class, "user");
	}

	@Override
	@SneakyThrows
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(User.class, "user");
	}

	@Override
	@SneakyThrows
	public User update(User user) {
		// TODO Auto-generated method stub
		return mongoTemplate.save(user, "user");
	}

	@Override
	@SneakyThrows
	public DeleteResult deleteById(String id) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(id));
		
		return mongoTemplate.remove(query, "user");
	}

	@Override
	@SneakyThrows
	public void deleteAll() {
		// TODO Auto-generated method stub
		 mongoTemplate.dropCollection("user");
	}

	

}
