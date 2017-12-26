package com.pilgrimm.web.user.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pilgrimm.core.common.AbstractDao;
import com.pilgrimm.core.common.DefaultPageResultGenerator;
import com.pilgrimm.core.common.MysqlPageSqlEntry;
import com.pilgrimm.web.user.dao.UserDao;
import com.pilgrimm.web.user.model.User;

@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

	public void update(Map<String, Object> paramMap) {
		String sql = "update t_user set name = '" + paramMap.get("name") + "' where id = 1";
		update(sql, paramMap);
	}
	
	public Map<String, Object> queryForPage(Map<String, Object> paramMap) {
		String sql = "SELECT * FROM t_user WHERE 1=1";
		return queryForPageMap(new MysqlPageSqlEntry(sql), paramMap, 
				new DefaultPageResultGenerator<User>(this));
	}
	
}