package com.tght.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rp = request.getParameter("rp");
		System.out.println("rp"+rp);
		//将数据存放Cookie中
		Cookie cookieName = new Cookie("username", username);
		Cookie cookiePwd = new Cookie("cookiePwd", password);		
		//Cookie持久化
		if (rp == null) {
			cookieName.setMaxAge(0);
			cookiePwd.setMaxAge(0);//立即销毁
		}else {
			cookieName.setMaxAge(60*60*24*7);//7天
			cookiePwd.setMaxAge(60*60*24*7);//7天
		}
		
		//将Cookie响应给浏览器
		response.addCookie(cookieName);
		response.addCookie(cookiePwd);
		//跳转
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
