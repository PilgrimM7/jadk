package com.pilgrimm.web.user.mapper;

import java.util.List;

import com.pilgrimm.web.user.model.User;

public interface UserMapper {
	
	boolean save(User user);
	
	boolean update(User user);
	
	boolean delete(int id);
	
	User findById(int id);  
	
    List<User> findAll(); 

}
