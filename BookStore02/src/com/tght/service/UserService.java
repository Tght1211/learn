package com.tght.service;

import com.tght.bean.User;

public interface UserService {
	
	User getUser(User user);
	
	/**
	 * 检查用户名是否存在
	 * 			true：用户名存在,(username != null)成立为true
	 * 			false：用户名不存在 （username != null）不成立为false
	 */
	boolean checkUser(String username);//优化了一下
	
	void saveUser(User user);
}
