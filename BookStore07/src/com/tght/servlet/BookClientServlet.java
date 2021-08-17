package com.tght.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tght.bean.Book;
import com.tght.bean.Page;
import com.tght.service.BookService;
import com.tght.service.Impl.BookServiceImpl;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();
	
	protected void getBooksByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值
		String pageNo = request.getParameter("pageNo");//第一遍为null
		//调用
		Page<Book> page = bookService.getBooksByPage(pageNo);
		//将 page存放在域中
		request.setAttribute("page", page);
		//跳转
		request.getRequestDispatcher("/pages/client/book_client.jsp").forward(request, response);
	}
	/**
	 * 客户端带价格分页查询
	 */
	protected void getBookByPageAndPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取值pageNo，名，max
		String pageNo = request.getParameter("pageNo");
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		//调用
		Page<Book> page =  bookService.getBookByPageAndPrice(pageNo, min, max);
		//域
		request.setAttribute("page", page);
		//跳转
		request.getRequestDispatcher("pages/client/book_client.jsp").forward(request, response);
	}

}
