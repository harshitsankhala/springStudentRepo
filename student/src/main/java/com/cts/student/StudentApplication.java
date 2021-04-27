package com.cts.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author Harshit
 *
 */
@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		 SpringApplication.run(StudentApplication.class, args);
	}
	
	 @Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/api").allowedOrigins("http://localhost:3000");
	         }
	      };
	   }
	
	
	
}
//data
/*

[
  {
    "createdBy": "system",
    "createdDate": "06-04-2021",
    "dateOfBirth": "10-10-2017",
    "firstName": "raja",
    "lastName": "kannan",
    "modifiedBy": "system",
    "modifiedDate": "06-04-2021",
    "studentClass": "LKG",
    "studentSection": "a"
  },
 {
    "createdBy": "system",
    "createdDate": "06-04-2021",
    "dateOfBirth": "11-05-2015",
    "firstName": "guru",
    "lastName": "a",
    "modifiedBy": "system",
    "modifiedDate": "06-04-2021",
    "studentClass": "1",
    "studentSection": "c"
  },
 {
    "createdBy": "system",
    "createdDate": "06-04-2021",
    "dateOfBirth": "12-11-2012",
    "firstName": "john",
    "lastName": "s",
    "modifiedBy": "system",
    "modifiedDate": "06-04-2021",
    "studentClass": "3",
    "studentSection": "a"
  },
 {
    "createdBy": "system",
    "createdDate": "06-04-2021",
    "dateOfBirth": "13-02-2010",
    "firstName": "abdul",
    "lastName": "f",
    "modifiedBy": "system",
    "modifiedDate": "06-04-2021",
    "studentClass": "5",
    "studentSection": "b"
  },
 {
    "createdBy": "system",
    "createdDate": "06-04-2021",
    "dateOfBirth": "14-09-2015",
    "firstName": "harini",
    "lastName": "c",
    "modifiedBy": "system",
    "modifiedDate": "06-04-2021",
    "studentClass": "LKG",
    "studentSection": "d"
  }
]

*/