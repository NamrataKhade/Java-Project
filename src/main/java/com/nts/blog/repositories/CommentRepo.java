package com.nts.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nts.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
