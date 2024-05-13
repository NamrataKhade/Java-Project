package com.nts.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nts.blog.entities.Category;
import com.nts.blog.entities.Post;
import com.nts.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
	
	@Query("select p from Post p where p.title like:key")
	List<Post> searchByTitle(@Param("key")String title);

}
