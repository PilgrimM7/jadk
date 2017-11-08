package com.pilgrimm.web.user.service;

import java.util.List;

import com.pilgrimm.web.user.model.User;

public interface UserService {

	void save(User user);
	
	boolean update(User user);
	
	boolean delete(int id);
	
	User findById(int id);  
	
    List<User> findAll();
    
    void txTest(User user1, User user2);
}
