package com.example.School.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "course") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Course {
	
	@Id
	private String id;
	private String courseName;
	private String description;
	private List<User> users;

}
