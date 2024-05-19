package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Post;


public interface SnsRepository extends JpaRepository<Post, Integer> {

	List<Post> findByMessageContaining(String message);

	List<Post> findAllByOrderByIdDesc();

}
