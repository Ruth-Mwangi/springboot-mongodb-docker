package com.example.School.service;

import java.util.List;

import com.example.School.models.User;
import com.mongodb.client.result.DeleteResult;

public interface UserService {
	// create

	public User save(User user);

	// read
	public User getById(String id);

	public List<User> getByName(String name);

	public List<User> getAll();

	// update
	public User update(User user);

	// delete
	public DeleteResult deleteById(String id);

	public void deleteAll();

}
