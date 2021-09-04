package com.example.School.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.School.repository.CourseRepo;
import com.example.School.repository.CourseRepoImpl;
import com.example.School.repository.UserRepo;
import com.example.School.repository.UserRepoImpl;
import com.example.School.service.CourseService;
import com.example.School.service.CourseServiceImpl;
import com.example.School.service.UserService;
import com.example.School.service.UserServiceImpl;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@ComponentScan(basePackages = { "com.ruth.School" })
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

	@Value("${spring.data.mongodb.host}")
	private String host;
	@Value("${spring.data.mongodb.port}")
	private String port;
	@Value("${spring.data.mongodb.database}")
	private String database;

	/**
	 * Bean For Mongo Template
	 * 
	 * @return
	 * @throws Exception
	 */

	public @Bean MongoClient mongoClient() {
		return MongoClients.create("mongodb://" + host + ":" + port);
	}

	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), database);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**", "/img/**", "/css/**", "/js/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/", "classpath:/static/img/", "classpath:/static/css/",
				"classpath:/static/js/");
	}
	
	public @Bean UserRepo userrepo() {
		return new UserRepoImpl();
	}
	public @Bean CourseRepo courserepo() {
		return new CourseRepoImpl();
	}
	public @Bean UserService userdao() {
		return new UserServiceImpl();
	}
	public @Bean CourseService coursedao() {
		return new CourseServiceImpl();
	}

}
