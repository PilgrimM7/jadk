package com.pilgrimm.web.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pilgrimm.web.user.mapper.UserMapper;
import com.pilgrimm.web.user.model.User;
import com.pilgrimm.web.user.service.UserService;
import com.pilgrimm.web.usersj.dao.UserSjDao;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserSjDao usersjDao;

	@Override
	public void save(User user) {
		// 执行后id主键自动赋值
		userMapper.save(user);
		// 主键自动递增，产生异常后递增的主键不会回滚
		"".substring(1);
		System.out.println(user.getId());
	}

	@Override
	public boolean update(User user) {
		
		return userMapper.update(user);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void txTest(User user1, User user2) {
		userMapper.update(user1);
		"".substring(1);
		userMapper.update(user2);
		
//		Map<String, Object> map1 = new HashMap<String, Object>();
//		map1.put("name", "cc");
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("name", "dd");
//
//		usersjDao.update(map1);
//		"".substring(1);
//		usersjDao.update(map2);
	}

}
