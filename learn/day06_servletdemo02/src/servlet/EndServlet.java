package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet");
		//测试request对象
		//1.通过name，获取请求参数
		String username = request.getParameter("username");
		System.out.println("username："+username);
		//2.获取项目虚拟路径
		String contextPath = request.getContextPath();
		System.out.println("contextPath："+contextPath);//contextPath：/day06_servletdemo02
		//转发
		//获取转发器
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("lohin_success.html");
		//执行转发
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("GBK");//服务器编码设置为GBK
		response.setContentType("text/html;charset=UTF-8");//charset=UTF-8解码变成UTF-8
		
		System.out.println("doPost");
		//测试response
		//服务器向客户端做出响应（文本|html）
		//获取响应流
		PrintWriter writer = response.getWriter();
		//响应
		writer.write("<h1>登录成功login  success!</h1>");
		
		//重定向（路径跳转）
		//response.sendRedirect("login_success.html");
	}

}
