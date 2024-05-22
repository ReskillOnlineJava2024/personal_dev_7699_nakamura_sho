package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Post;


public interface SnsRepository extends JpaRepository<Post, Integer> {

	Page<Post> findByMessageContainingOrderByIdDesc(String message, Pageable pageable);

	Page<Post> findAllByOrderByIdDesc(Pageable pageable);
	
	Page<Post> findByUserIdOrderByIdDesc(Integer Id, Pageable pageable);

	Page<Post> findByUserIdAndMessageContainingOrderByIdDesc(Integer id, String message, Pageable pageable);

}
