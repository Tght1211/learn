package com.tght.service.Impl;

import com.tght.bean.User;
import com.tght.dao.UserDao;
import com.tght.dao.impl.UserDaoImpl;
import com.tght.service.UserService;

public class UserServiceImpl implements UserService{
//业务逻辑层需要调用数据访问层，即dao层
	private UserDao userDao = new UserDaoImpl();
		
	@Override
	public User getUser(User user) {	
		//返回到dao层去，然后在dao层获取数据
		return userDao.getUser(user);
	}
//业务逻辑层类似于不用自己拿数据的测试

	@Override
	public boolean checkUser(String username) {
		
		return userDao.checkUser(username);
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
	
}
