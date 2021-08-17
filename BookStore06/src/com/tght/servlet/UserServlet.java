package com.tght.servlet;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import com.tght.bean.User;
import com.tght.service.UserService;
import com.tght.service.Impl.UserServiceImpl;

public class UserServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();//获取session
		
		// UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl();// 表示层调用业务逻辑层
		// 1.获取输入的用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2.调用dao登录接口，传入参数，来执行方法内部的sql，再返回整个有全部数据的对象,
		// 这里不拿数据，只校验有无数据
		// 现在是用业务逻辑层调用，该方法，不同的重写，
		// 这里的getUser不直接获取数据，还要在内部进行用dao层来调用getUser，才获取数据
		User user = userService.getUser(new User(null, username, password, null));
		if (user == null) {
			// 登录失败，转发
			// 标记，在域中存放数据
			request.setAttribute("msg", "用户名或密码有误，请重新输入！");// 带走
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			// 登录成功，重定向
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		
		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//获取验证码
		String code = request.getParameter("code");
		//获取session中的验证码文本
		Object  code2 = session.getAttribute("KAPTCHA_SESSION_KEY");
		

		//判断验证码时候正确
		if (code2 != null && code2.toString().equals(code) ) {
			
			// 调用service中的方法校验
			boolean yOn = userService.checkUser(username);
			if (yOn) {
				// 用户名存在,转发
				request.setAttribute("msg", "用户名已存在,请重新输入!");
				// request.setAttribute("name", "username");//，没太必要

				request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			} else {
					// 用户名不存在，调用saveUser()，重定向
					userService.saveUser(new User(null, username, password, email));
					response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
			}
		}else {
			request.setAttribute("msg", "验证码错误!");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}

	}
	/**
	 * 注销
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//将user从session域中移除
		request.getSession().removeAttribute("user");
		//跳转,需要携带request域就转发，不需要的时候就重定向
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

} 
