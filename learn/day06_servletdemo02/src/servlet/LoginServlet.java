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
		request.setCharacterEncoding("GBK");//���ñ���
		//response.setContentType("text/html;charset=UTF-8");//�����������������������ͳһ����ΪUTF-8
		response.setCharacterEncoding("GBK");//ֱ�ӽ���������������ΪGBK����Ӧ���룩
		//request.setCharacterEncoding("UTF-8");
		//���÷���������ΪUTF-8���������룩������֮��������ʾ��ȷ��
		//��Ϊ����ķ����������Ѿ����UTF-8�����������뻹��UTF-8��tomcat9��
	
		
		String username = request.getParameter("username");	//�����������ݽ���GBK���룬		
		//����̨��ʾ�����������룬��????????�㣩|ԭ�򣺱�����GBK�����������뻹��UTF-8��tomcat9��
		System.out.println(username);
		
		String lable = "��";//�����������ݽ���GBK����
		System.out.println(lable);//����̨��ʾ��ȷ������
		
		//��ȡ��Ӧ��
		PrintWriter writer = response.getWriter();
		//��Ӧ
		writer.write(lable);//�����Ĭ��GBK����
		
		
//		if ("admin2".equals(username) && "admin2".equals(pwd)) {
//			//��¼�ɹ�����תlogin_success.html
//			request.getRequestDispatcher("/pages/login_success.html").forward(request, response);
//			System.out.println("��¼�ɹ�");
//		}else {
//			System.out.println("��¼ʧ��");
//			//��¼ʧ�ܣ��ض�����תlogin.html
//			response.sendRedirect(request.getContextPath()+"/index.html");
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
