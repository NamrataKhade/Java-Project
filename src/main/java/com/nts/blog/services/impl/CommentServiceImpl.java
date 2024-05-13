package com.nts.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nts.blog.entities.Comment;
import com.nts.blog.entities.Post;
import com.nts.blog.exception.ResourceNotFoundException;
import com.nts.blog.payloads.CommentDto;
import com.nts.blog.repositories.CommentRepo;
import com.nts.blog.repositories.PostRepo;
import com.nts.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
//		System.out.println(post);
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
//		System.out.println(comment);
		Comment saveComment = this.commentRepo.save(comment);
		return this.modelMapper.map(saveComment, CommentDto.class);

	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment Id", commentId));
		this.commentRepo.delete(comment);

	}

	@Override
	public CommentDto getComments(Integer commentId) {
	// Optional<Comment> comment = commentRepo.findById(commentId);
	    Comment com=commentRepo.getById(commentId);
	    CommentDto commentDto = new CommentDto();
	    commentDto.setCommentId(com.getCommentId());
	    commentDto.setContent(com.getContent());
	    System.out.println(commentDto);
		return modelMapper.map(commentDto, CommentDto.class);
	}





}
