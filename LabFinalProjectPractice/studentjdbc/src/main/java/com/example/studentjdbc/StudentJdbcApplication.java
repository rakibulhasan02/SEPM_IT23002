package com.example.studentjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentJdbcApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentJdbcApplication.class, args);
	}
}
//to run : firstly StudentJdbcApplication run
// secondly: in command: curl http://localhost:8080/students