package demo;

public class Demo {

	/**
	 	1. �������Ӧ
	 		* ���󣺿ͻ����������
	 			* ���ͣ�HttpServletRequest request
	 			* ���壺�����˿ͻ�������������͵������ģ��ö����ɷ�������web����|Servlet������������
	 					ͬʱ���͸�Service(),Service()���͸�doGet()��doPost()��
	 			* ���� 	
  					1. ��ȡ�������
  						* request.getParameter("username");
  						* request.getParameterValues(name)
  					2. ��ȡ��Ŀ������·��
  						* request.getContextPath();
  					3. ת����·����ת��
  						* request.getRequestDispatcher("").forward(request, response);
  					4. ����󣨸��ĸ���
	 		* ��Ӧ����������ͻ���
	 			* ���ͣ� HttpServletResponse response
	 			* ���壺�����˷�������ͻ��˷��͵���Ӧ���ģ��ö����ɷ�������web����|Servlet������������
	 					ͬʱ���͸�Service(),Service()���͸�doGet()��doPost()��
	 			* ����
	 			 	1. ��������ͻ���������Ӧ���ı�|html��
	 			 		* response.getWriter();
	 			 		* write();|print();
	 			 	2. �ض���·����ת��
	 			 		* response.sendRedirect();
	 	2. ת�����ض�������
	 		* ת����ַ�����䣬�ض����ַ���ı䡣
	 		* ת���ͻ��˷���һ�������ض���ͻ��˷�����������
	 		* ת�����Է���WEB-INF����Դ���ض����ܡ�
	 			* ��ΪWEB-INFĿ¼����WebӦ�õ�˽��Ŀ¼���ͻ����޷�ֱ�ӷ��ʣ� 
	 		* ת������Я��request�����ض����ܡ�
	 	3. Servlet��ϰ��α��¼|αע�ᣩUser:admin2,admin2
	 	4. WebӦ����·������
	 		* ��webӦ���У�����ʹ��ת����ת·��ʱ����ַ�����䡣��ʱʹ�����·����../������404����
	 			��ʹ�þ���·�������webӦ���е�·������
	 		* ʲô�Ǿ���·�����ԡ�/����ͷ��·������֮Ϊ����·����
	 			* ��/��������˼
	 				* �ɷ����������������ŵ�ǰ��Ŀ·����http://localhost:8080/day06_servletdemo2
	 					* ������������ɷ���������
	 						1. web.xml�е�url
	 						2. ת��
	 				* ������������������ŵ�ǰ������·����http://localhost:8080
	 					* ����������������������
	 						1. html�е�·��,eg:src:script|img  href:link|a  action:form
	 						2. �ض���
	 	5. WebӦ������������
	 		* ���룺��������벻һ��ʱ��������������
	 		 	* �������룺�ͻ��˱�������������벻һ��
	 			* ��Ӧ���룺������������ͻ��˽��벻һ��
	 		* ���룺���ַ�ת��Ϊ�����ƵĹ��̳�֮Ϊ����
	 		* ���룺��������ת��Ϊ�ַ��Ĺ��̳�֮Ϊ����
	 		* Ĭ�Ͽͻ�����������˱�������������
	 			* �������ı��������Ĭ��һ��Ϊ��ISO-8859-1
	 			* �ͻ��ˣ������������Ĭ��Ϊ��<meta charset="UTF-8">
	 			 			����Ĭ��Ϊ��GBK
	 		* ���web����������
	 			* ��������
	 				* POST����request.setCharacterEncoding("UTF-8");
	 				* GET����server.xml���޸ģ�URIEncoding="UTF-8"
	 					* eg:<Connector port="8080"  URIEncoding="UTF-8"/>
	 			* ��Ӧ����
	 				* ֱ�ӽ���������������ΪGBK
	 					* response.setCharacterEncoding("GBK"); 
	 				* ���������������������������ΪUTF-8
	 					* response.setContentType("text/html;charset=UTF-8");
	 		* Tomcat8.0֮ǰĬ�ϱ���Ϊ��ISO-8859-1
	 		  Tomcat8.0֮�󣨺�8.0��Ĭ�ϱ���Ϊ��UTF-8
	 	6. ��Ŀ�ڶ��׶�
	 
	 */
	
	
}

