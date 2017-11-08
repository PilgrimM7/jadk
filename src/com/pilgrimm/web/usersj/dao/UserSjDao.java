package com.pilgrimm.web.usersj.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pilgrimm.core.springjdbc.AbstractDao;

@Repository
public class UserSjDao extends AbstractDao {

	public void update(Map<String, Object> paramMap) {
		String sql = "update t_user set name = '" + paramMap.get("name") + "' where id = 1";
		update(sql, paramMap);
	}
	
}
