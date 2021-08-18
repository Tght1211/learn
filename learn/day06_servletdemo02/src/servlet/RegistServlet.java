package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名
		String username = request.getParameter("username");
		//校验用户名是否存在（admin2）
		if ("admin2".equals(username)) {
			System.out.println("用户名已存在，请重新输入");
			//用户名已存在，请重新输入，注册失败，重定向regist.html
			response.sendRedirect("pages/regist.html");
			
		}else {
			System.out.println("注册成功");
			//用户名可用，注册成功，转发regist_success.htm
			request.getRequestDispatcher("pages/regist_success.html").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
