package com.example.demo.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.ExtendedPost;
public interface ExtendedPostRepository extends JpaRepository<ExtendedPost, Integer> {
	
	@Query(value = "SELECT p.id, p.user_id, p.message, u.name " +
            "FROM posts p LEFT JOIN users u ON p.user_id = u.id " +
            "ORDER BY p.id DESC", nativeQuery = true)
    Page<ExtendedPost> findByExtendedPostDataOrderByIdDesc(Pageable pageable);
	
	@Query(value = "SELECT p.id, p.user_id, p.message, u.name " +
            "FROM posts p LEFT JOIN users u ON p.user_id = u.id " +
            "WHERE p.message LIKE %:keyword% " +
            "ORDER BY p.id DESC", nativeQuery = true)
    Page<ExtendedPost> findExtendedPostDataByMessageContainingOrderByIdDesc(String keyword, Pageable pageable);
	
	@Query(value = "SELECT p.id, p.user_id, p.message, u.name " +
            "FROM posts p LEFT JOIN users u ON p.user_id = u.id " +
            "WHERE user_id = :id " +
            "ORDER BY p.id DESC", nativeQuery = true)
     Page<ExtendedPost> findExtendedPostDataByUserIdOrderByIdDesc( Integer id, Pageable pageable);
	
	@Query(value = "SELECT p.id, p.user_id, p.message, u.name " +
            "FROM posts p " +
            "LEFT JOIN users u ON p.user_id = u.id " +
            "WHERE p.user_id = :id AND p.message LIKE %:keyword% " +
            "ORDER BY p.id DESC", nativeQuery = true)
    Page<ExtendedPost> findExtendedPostDataByUserIdAndMessageContainingOrderByIdDesc(Integer id,String keyword, Pageable pageable);
}