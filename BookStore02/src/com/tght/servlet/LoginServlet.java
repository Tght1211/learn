package com.tght.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tght.bean.User;
import com.tght.dao.UserDao;
import com.tght.dao.impl.UserDaoImpl;
import com.tght.service.UserService;
import com.tght.service.Impl.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//UserDao userDao = new UserDaoImpl();
		 UserService userService = new UserServiceImpl();//表示层调用业务逻辑层
		//1.获取输入的用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用dao登录接口，传入参数，来执行方法内部的sql，再返回整个有全部数据的对象,
		//这里不拿数据，只校验有无数据
		//现在是用业务逻辑层调用，该方法，不同的重写，
		//这里的getUser不直接获取数据，还要在内部进行用dao层来调用getUser，才获取数据
		User user = userService.getUser(new User(null, username, password, null));
		if(user == null) {
			//登录失败，转发
			request.getRequestDispatcher("/pages/user/login.html").forward(request, response);
		}else {
			//登录成功，重定向
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.html");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
