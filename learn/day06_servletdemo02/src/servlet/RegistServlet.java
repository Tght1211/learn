package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�û���
		String username = request.getParameter("username");
		//У���û����Ƿ���ڣ�admin2��
		if ("admin2".equals(username)) {
			System.out.println("�û����Ѵ��ڣ�����������");
			//�û����Ѵ��ڣ����������룬ע��ʧ�ܣ��ض���regist.html
			response.sendRedirect("pages/regist.html");
			
		}else {
			System.out.println("ע��ɹ�");
			//�û������ã�ע��ɹ���ת��regist_success.htm
			request.getRequestDispatcher("pages/regist_success.html").forward(request, response);
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
