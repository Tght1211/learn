package com.tght.dao.impl;

import com.tght.bean.User;
import com.tght.dao.BaseDao;
import com.tght.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User getUser(User user) {
		String sql = "SELECT id,username,`password`,email FROM users WHERE username = ? AND `password` = ? ";
		User user2 = this.getBean(sql, user.getUsername(),user.getPassword());
		return user2;
		//返回一个通过，getBean中提供数据，再用sql查询出来的User对象类型，
		//即返回包含该那俩条信息的对象[信息]
	}

	@Override
	public boolean checkUser(String username) {
		String sql = "SELECT id,username,`password`,email FROM users WHERE username = ? "; 
		User user = this.getBean(sql, username);
		return user != null;// 返回true的时候，用户名存在
	}

	@Override
	public void saveUser(User user) {
		String sql = "INSERT INTO users(username,PASSWORD,email) VALUES(?,?,?) ";
		this.update(sql, user.getUsername(),user.getPassword(),user.getEmail());
	}

	
}
