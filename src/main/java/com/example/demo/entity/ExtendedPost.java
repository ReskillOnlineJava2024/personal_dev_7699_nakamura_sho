package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ExtendedPost {
	
	@Id
	private Integer id;
	
	@Column(name = "user_id")
	private Integer userId;

	private String message;

	private String name;
	

	public Integer getId() {
		return id;
	}
	
	public Integer getUserId() {
		return userId;
	}

	
	public String getMessage() {
		return message;
	}
	public String getName() {
		return name;
	}
}