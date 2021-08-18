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
		//����request����
		//1.ͨ��name����ȡ�������
		String username = request.getParameter("username");
		System.out.println("username��"+username);
		//2.��ȡ��Ŀ����·��
		String contextPath = request.getContextPath();
		System.out.println("contextPath��"+contextPath);//contextPath��/day06_servletdemo02
		//ת��
		//��ȡת����
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("lohin_success.html");
		//ִ��ת��
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setCharacterEncoding("GBK");//��������������ΪGBK
		response.setContentType("text/html;charset=UTF-8");//charset=UTF-8������UTF-8
		
		System.out.println("doPost");
		//����response
		//��������ͻ���������Ӧ���ı�|html��
		//��ȡ��Ӧ��
		PrintWriter writer = response.getWriter();
		//��Ӧ
		writer.write("<h1>��¼�ɹ�login  success!</h1>");
		
		//�ض���·����ת��
		//response.sendRedirect("login_success.html");
	}

}
