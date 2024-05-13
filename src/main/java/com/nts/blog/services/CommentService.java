package com.nts.blog.services;

import com.nts.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto,Integer postId);
	
	void deleteComment(Integer commentId);
	
	CommentDto getComments(Integer commentId);
	
	

}
