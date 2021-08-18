package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.LineUnavailableException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");//设置编码
		//response.setContentType("text/html;charset=UTF-8");//将服务器编码与浏览器解码统一设置为UTF-8
		response.setCharacterEncoding("GBK");//直接将服务器编码设置为GBK（响应乱码）
		//request.setCharacterEncoding("UTF-8");
		//设置服务器编码为UTF-8（请求乱码），加上之后请求显示正确，
		//因为请求的服务器编码已经变成UTF-8，服务器解码还是UTF-8（tomcat9）
	
		
		String username = request.getParameter("username");	//服务器对数据进行GBK编码，		
		//控制台显示错误，请求乱码，（????????°）|原因：编码是GBK，服务器解码还是UTF-8（tomcat9）
		System.out.println(username);
		
		String lable = "王";//服务器对数据进行GBK编码
		System.out.println(lable);//控制台显示正确（王）
		
		//获取响应流
		PrintWriter writer = response.getWriter();
		//响应
		writer.write(lable);//浏览器默认GBK解码
		
		
//		if ("admin2".equals(username) && "admin2".equals(pwd)) {
//			//登录成功，跳转login_success.html
//			request.getRequestDispatcher("/pages/login_success.html").forward(request, response);
//			System.out.println("登录成功");
//		}else {
//			System.out.println("登录失败");
//			//登录失败，重定向跳转login.html
//			response.sendRedirect(request.getContextPath()+"/index.html");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
