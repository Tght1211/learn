package om.tght.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.Header;

import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class FileDownLoadDemo
 */
public class FileDownLoadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进来了");
		request.setCharacterEncoding("UTF-8");//编码
	//	response.setContentType("text/html;charset=UTF-8");
		// 获取文件名
		String fileName = request.getParameter("fileName");
		// 获取该文件的真实路径
		String realPath = this.getServletContext().getRealPath("/WEB-INF/download");// 在WebContent中的路径
		String downloadPath = realPath + "/" + fileName;
		System.out.println(downloadPath);
		
		//设置浏览器响应体文件类型
		String mimeType = request.getServletContext().getMimeType(fileName);
		response.setContentType(mimeType);//以文件类型响应出来

		//解决文件名中文乱码问题
		String header = request.getHeader("User-Agent");
		if(header != null && header.contains("Firefox")) {
			fileName = "=?utf-8?B?"+new BASE64Encoder().encode(fileName.getBytes("utf-8"))+"?=";
		}else {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}
		
		//设置浏览器响应体内容格式，为附件格式（告诉浏览器播放，下载）
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		System.out.println("响应了");
		
		//读取目标资源，同时写到客户端（下载）
		//创建读入流
		FileInputStream fis = new FileInputStream(downloadPath);
		//创建写出流
		System.out.println("准备写出");
		ServletOutputStream ops = response.getOutputStream();
		System.out.println("写出了");
		byte[] b = new byte[1024];
		while (fis.read(b) != -1) {
			ops.write(b);
			System.out.println("循环中");
		}
		ops.close();
		fis.close();
		System.out.println("结束了");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
