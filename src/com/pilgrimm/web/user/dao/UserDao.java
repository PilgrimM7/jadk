package com.pilgrimm.web.user.dao;

import java.util.Map;

public interface UserDao {

	Map<String, Object> queryForPage(Map<String, Object> paramMap);
	
}
