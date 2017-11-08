package com.pilgrimm.web.user.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pilgrimm.web.user.mapper.UserMapper;
import com.pilgrimm.web.user.model.User;
import com.pilgrimm.web.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/spring-common.xml")
public class UserTest {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void update() {
		userMapper.update(new User(1, "小李", 27));
	}
	
	@Test
	public void txTest() {
		userService.txTest(new User(1, "aa", 27), new User(1, "bb", 27));
	}
	
}
