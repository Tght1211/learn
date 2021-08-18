package com.tght.servlet.session;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ReSubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 分别取session域和隐藏域中的uuid值
		String uuid2 = request.getParameter("uuid2");// 隐藏域.
		// 刷新之后再提交，就是新的uuid2
		System.out.println("uuid2" + uuid2);
		Object uuid = session.getAttribute("uuid");// session域
		// 判断是否相等
		if (uuid != null && uuid.toString().equals(uuid2)) {
			// 相等：提交，移除session域中的token
			System.out.println("提交啦！！！哈哈");
			session.removeAttribute("uuid");// 移除了为空，就不会再提交
		}
		else {
			System.out.println(uuid);
		}
		System.out.println("end!");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
