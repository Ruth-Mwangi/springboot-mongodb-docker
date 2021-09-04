package com.example.School.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.School.models.User;
import com.example.School.repository.UserRepo;
import com.mongodb.client.result.DeleteResult;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userrepo;

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userrepo.save(user);
	}

	@Override
	public User getById(String id) {
		// TODO Auto-generated method stub
		return userrepo.getById(id);
	}

	@Override
	public List<User> getByName(String name) {
		// TODO Auto-generated method stub
		return userrepo.getByName(name);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userrepo.getAll();
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userrepo.update(user);
	}

	@Override
	public DeleteResult deleteById(String id) {
		// TODO Auto-generated method stub
		return userrepo.deleteById(id);
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		userrepo.deleteAll();
		
	}

}
