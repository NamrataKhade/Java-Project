package com.nts.blog.services;

import java.util.List;

import com.nts.blog.payloads.UserDto;

public interface UserService {
	
	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers(Integer pageNumber,Integer pageSize);
	
	void deleteUser(Integer userId);

}
