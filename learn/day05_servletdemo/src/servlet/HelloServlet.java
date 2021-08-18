package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import jdk.internal.org.objectweb.asm.tree.analysis.SourceInterpreter;

public class HelloServlet implements Servlet{
	
	private ServletConfig config;
	
	public HelloServlet() {
		System.out.println("������");
	}

	//servlet����ʱ����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destory()!!!");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	//��ʼ��������servlet�����ִ��
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()!!!");
		this.config = config;
	}

	//��������/��������
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("service()!!!");
		String initParameter = config.getInitParameter("encode");
		System.out.println("inintParameter��"+initParameter);
		ServletContext servletContext = config.getServletContext();
		System.out.println("servletContext��"+servletContext);
		String servletName = config.getServletName();
		System.out.println("servletName��"+servletName);
		//��ȡ�����Ĳ���
		String initParameter2 = servletContext.getInitParameter("age");
		System.out.println("initParameter2��"+initParameter2);
		//��ȡ��ʵ·��
		String realPath = servletContext.getRealPath("login.html");
		System.out.println("realPath��"+realPath);
		
	}
	
}
