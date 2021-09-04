package com.example.School.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@ComponentScan(basePackages = {"com.ruth.School"})
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
	 * @return
	 * @throws Exception
	 */
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		ConnectionString connectionString = new ConnectionString("mongodb://"+host+":"+port+"/"+database);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();
		MongoTemplate mt=new MongoTemplate(MongoClients.create(mongoClientSettings), database);
		
		return mt;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }
	

}
