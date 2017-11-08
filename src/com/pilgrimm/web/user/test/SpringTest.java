package com.pilgrimm.web.user.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	@Test
	public void test() {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-common.xml");
		Object userMapper = ctx.getBean("userMapper");
		System.out.println(userMapper);
	}
}
