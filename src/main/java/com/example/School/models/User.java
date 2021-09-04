package com.example.School.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "user") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
	@Id
	private String id;
	private String fname;
	private String lname;
	private String role;
	private String email;

}
