package com.nts.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nts.blog.payloads.ApiResponse;
import com.nts.blog.payloads.CommentDto;
import com.nts.blog.services.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
//	@Autowired
//	private CommentRepo commentRepo;
	
	
	@PostMapping("/create/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){
		System.out.println(commentDto.getCommentId());
		CommentDto createComment = this.commentService.createComment(commentDto, postId);
		return new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteComment/{commentId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
		this.commentService.deleteComment(commentId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Comment Deleted Successfully !!",true),HttpStatus.OK);
		
	}
	
//	get comment
	@GetMapping("/getComment/{commentId}")
	public ResponseEntity<CommentDto> getComment(@PathVariable Integer commentId){
		//System.out.println(commentDto.getCommentId());
		
		CommentDto comments = commentService.getComments(commentId);
		return new ResponseEntity<CommentDto>(comments,HttpStatus.OK);
	}
	

	
	
	

}
