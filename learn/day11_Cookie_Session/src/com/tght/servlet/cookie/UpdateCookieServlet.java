package com.tght.servlet.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//覆盖式
//		Cookie cookieName = new Cookie("stuName", "lisi");
//		response.addCookie(cookieName);
		
		//直接式
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if("stuName".equals(cookie.getName())) {
				cookie.setValue("Wangwu");
				response.addCookie(cookie);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
