package com.tght.test;


import org.junit.jupiter.api.Test;

import com.tght.bean.User;
import com.tght.dao.UserDao;
import com.tght.dao.impl.UserDaoImpl;

class UserDaoImplTest {

	private UserDao userDao = new UserDaoImpl();//多态
	//private UserDaoImpl uImpl = new UserDaoImpl();
	@Test
	void testGetUser() {
		//
		 User user = userDao.getUser(new User(null,"test01","test01",null));
		System.out.println(user);
	}

	@Test
	void testCheckUser() {
		//
		 boolean yOn = userDao.checkUser("test01d");
		System.out.println(yOn);
	}
}
