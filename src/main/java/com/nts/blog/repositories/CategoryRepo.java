package com.nts.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nts.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
