package com.tght.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tght.bean.User;
import com.tght.service.UserService;
import com.tght.service.Impl.UserServiceImpl;


public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 注册
	 * 			1、取值
	 * 			2、校验用户名是否存在
	 * 				1、不存在，待用save User(),保存用户信息
	 * 				2、存在：跳转回注册页面
	 */


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//修改服务器编码
		response.setContentType("text/html;charset=UTF-8");//浏览器解码统一设置为UTF-8
		
		UserService userService = new UserServiceImpl();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//调用service中的方法校验
		boolean yOn = userService.checkUser(username);
		if (yOn) {
			//用户名存在,转发
			request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
		}else {
			//用户名不存在，调用saveUser()，重定向
			userService.saveUser(new User(null, username, password, email));
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
