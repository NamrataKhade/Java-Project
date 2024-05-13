package com.nts.blog.services;

import java.util.List;

import com.nts.blog.payloads.PostDto;
import com.nts.blog.payloads.PostResponse;


public interface PostService {
    //create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);

	// update
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete
	void deletePost(Integer postId);

	// getAll post
		PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
		
	// get single post
	PostDto getPostById(Integer postId);
	
	//get all post By category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get All post By User
	List<PostDto> getPostByUser(Integer userId);
	
	//Search Post
	List<PostDto> searchPosts(String keyword);
	
	//Search Post by @Query
	List<PostDto> searchPostsByQuery(String keyword);
	
	
	
	
}
